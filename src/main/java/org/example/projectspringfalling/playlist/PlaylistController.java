package org.example.projectspringfalling.playlist;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    // 현재 재생중인 플레이리스트
    @GetMapping("/playlists/current")
    public String currentPlaylist() {
        return "playlist/current-playlist";
    }


    @GetMapping("playlists/test")
    public String playlistTest(Model model) {
        List<PlaylistResponse.PlaylistDTO> songs = playlistService.musicTest();
        model.addAttribute("songs", songs);
        return "playlist/current-playlist";
    }
}
