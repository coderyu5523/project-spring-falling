package org.example.projectspringfalling.album;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AlbumController {
    private final AlbumService albumService;
    private final HttpSession session;

    // 앨범 상세보기
    @GetMapping("/albums/{id}")
    public String songList(@PathVariable Integer id) {
//        return "album/album-list";
        return "album/album-detail";
    }

    // 앨범 추가하기
    @PostMapping("/albums/register")
    public String albumRegister(AlbumRequest.SaveDTO requestDTO) {
        albumService.addAlbum(requestDTO);

        return "redirect:/admin/albums";
    }

    // 앨범 더미 테스트
    @GetMapping("/album-test")
    public String test(HttpServletRequest request) {
        int id = 4;
        Album album = albumService.getImage(id);
        request.setAttribute("album", album);
        return "album-test";
    }
}
