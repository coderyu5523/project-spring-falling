package org.example.projectspringfalling.song;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class SongController {
    private final SongService songService;
    private final HttpSession session;

    // 곡 상세보기
    @GetMapping("/songs/{songId}")
    public String songDetail(@PathVariable Integer songId) {
        SongResponse.DetailDTO resp = songService.songDetail(songId);
        session.setAttribute("song", resp);
        return "song/song-detail";
    }

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 검색 페이지
    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword", required = false) String keyword, HttpServletRequest request) {
        SongResponse.SearchDTO reponseDTO = songService.searchKeyword(keyword);
        request.setAttribute("reponseDTO", reponseDTO);
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


    // todo : 더미 테스트용
    @GetMapping("/song-test")
    public String test(HttpServletRequest request) {
        int id = 31;
        Song song = songService.getImg(id);
        System.out.println("음악" + song.getMusicFile());
        request.setAttribute("song", song);
        return "song-test";
    }



}
