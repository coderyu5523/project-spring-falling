package org.example.projectspringfalling.artist;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class ArtistController {
    private final ArtistService artistService;
    private final HttpSession session;

    // 가수 상세보기
    @GetMapping("/artists/{id}")
    public String artistDetail(@PathVariable Integer id) {
//        return "artist/artist-album-list";
        return "artist/artist-song-list";

    }

    // todo : 더미 테스트용 , 삭제 예정
    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        int id = 1;
        Artist artist = artistService.getImage(id);
        request.setAttribute("artist", artist);
        return "test";
    }

}
