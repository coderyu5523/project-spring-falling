package org.example.projectspringfalling.song;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.artist.Artist;
import org.example.projectspringfalling.artist.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class SongController {
    private final SongService songService;
    private final HttpSession session;
    private final ArtistService artistService;

    // 곡 상세보기
    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable Integer id) {
        return "song/song-detail";
    }

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "index";
    }


    // 검색 페이지
    @GetMapping("/search")
    public String search() {
        return "search";
    }

    // 차트별 페이지
    @GetMapping("/song-chart")
    public String songChart() {
        return "song/song-chart";
    }

    // 장르별 페이지
    @GetMapping("/song-genre")
    public String songGenre() {
        return "song/song-genre";
    }

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        int id = 1;
        Artist artist = artistService.getImage(id);
        request.setAttribute("artist", artist);
        return "test";
    }

}
