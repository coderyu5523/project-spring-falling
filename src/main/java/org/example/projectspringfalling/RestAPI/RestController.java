package org.example.projectspringfalling.RestAPI;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.ApiUtil;
import org.example.projectspringfalling.playlist.PlaylistService;
import org.example.projectspringfalling.song.SongService;
import org.example.projectspringfalling.user.UserResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final HttpSession session;
    private final RedisTemplate<String, Object> rt;
    private final SongService songService;
    private final PlaylistService playlistService;

    // 검색 자동완성 기능
    @GetMapping("/search/auto")
    public ApiUtil<List<RestResponse.SearchAutoCompleteDTO>> searchAuto(@RequestParam("keyword") String keyword) {
        List<RestResponse.SearchAutoCompleteDTO> responseDTO = songService.searchKeywordAuto(keyword);
        return new ApiUtil<>(responseDTO);
    }

    // 보관함 - 내 리스트
    @GetMapping("/storage/my-list")
    public ApiUtil<List<RestResponse.StoragePlaylist>> storageMyList() {
        UserResponse.LoginDTO sessionUser = (UserResponse.LoginDTO) rt.opsForValue().get("sessionUser");
        return new ApiUtil<>(playlistService.getMyList(sessionUser.getId()));
    }

}
