package org.example.projectspringfalling.playlist;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PlaylistController {
    private final PlaylistService playlistService;
    private final HttpSession session;

    // 보관함 페이지
    @GetMapping("/storage")
    public String storage() {
        return "playlist/storage";
    }

    // 플레이리스트 보기
    @GetMapping("/playlists/{id}")
    public String playlist(@PathVariable Integer id) {
        return "playlist/playlist";
    }
}
