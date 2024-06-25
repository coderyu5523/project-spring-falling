package org.example.projectspringfalling.RestAPI;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.ApiUtil;
import org.example.projectspringfalling.playlist.PlaylistResponse;
import org.example.projectspringfalling.playlist.PlaylistService;
import org.example.projectspringfalling.playlistSong.PlaylistSongRequest;
import org.example.projectspringfalling.playlistSong.PlaylistSongService;
import org.example.projectspringfalling.song.SongService;
import org.example.projectspringfalling.user.SessionUser;
import org.example.projectspringfalling.user.UserResponse;
import org.example.projectspringfalling.user.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final HttpSession session;
    private final RedisTemplate<String, Object> rt;
    private final SongService songService;
    private final PlaylistService playlistService;
    private final PlaylistSongService playlistSongService;
    private final UserService userService;

    // 검색 자동완성 기능
    @GetMapping("/search/auto")
    public ApiUtil<List<RestResponse.SearchAutoCompleteDTO>> searchAuto(@RequestParam("keyword") String keyword) {
        List<RestResponse.SearchAutoCompleteDTO> responseDTO = songService.searchKeywordAuto(keyword);
        return new ApiUtil<>(responseDTO);
    }

    // 보관함 - 내 리스트
    // 플레이리스트 모달
    @GetMapping("/storage/my-list")
    public ApiUtil<List<RestResponse.StoragePlaylist>> storageMyList() {
        UserResponse.LoginDTO sessionUser = (UserResponse.LoginDTO) rt.opsForValue().get("sessionUser");
        return new ApiUtil<>(playlistService.getMyList(sessionUser.getId()));
    }


    // 플레이리스트 곡 추가하기
    @PostMapping("/add-song")
    public ResponseEntity<?> addSongToPlaylist(PlaylistSongRequest.AddSongToPlaylist requestDTO) {
        return playlistSongService.addSongToPlaylist(requestDTO);
    }

    // 재생중인 플레이리스트 데이터 요청
    @GetMapping("/api/playlists/current")
    public List<RestResponse.PlaylistDTO> getCurrentPlaylist() {
        return new ArrayList<>(playlistService.musicTest());
    }

    // 현재 비밀번호 일치 확인
    @GetMapping("/api/password-same-check")
    public @ResponseBody ApiUtil<Boolean> passwordSameCheck(@RequestParam String inputPassword) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        Boolean isValid = userService.passwordCheck(sessionUser.getEmail(), inputPassword);
        return new ApiUtil<>(isValid);
    }
}
