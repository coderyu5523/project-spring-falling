package org.example.projectspringfalling.album;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.artist.Artist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    // 앨범 더미 테스트
    @GetMapping("/album-test")
    public String test(HttpServletRequest request) {
        int id = 1;
        Album album = albumService.getImage(id);
        System.out.println(album.getAlbumImg());
        request.setAttribute("album", album);
        return "album-test";
    }
}
