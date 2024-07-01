package org.example.projectspringfalling.album;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.RedisUtil;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AlbumController {
    private final AlbumService albumService;
    private final HttpSession session;
    private final RedisUtil redisUtil;

    // 앨범 상세보기
    @GetMapping("/albums/{albumId}/list")
    public String songList(Model model, @PathVariable Integer albumId) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        Integer userId = (sessionUser != null) ? sessionUser.getId() : 0;

        AlbumResponse.DetailDTO resp = albumService.albumDetail(albumId, userId);
        model.addAttribute("album", resp);

        return "album/album-list";
//        return "album/album-detail";
    }


    // 앨범 추가하기
    @PostMapping("/albums/register")
    public String albumRegister(AlbumRequest.SaveDTO requestDTO) {
        albumService.addAlbum(requestDTO);

        return "redirect:/admin/albums";
    }

    // 앨범 더미 테스트
    @GetMapping("/album-test")
    public String test(Model model) {
        int id = 4;
        Album album = albumService.getImage(id);
        model.addAttribute("album", album);
        return "album-test";
    }
}
