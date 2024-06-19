package org.example.projectspringfalling.playlist;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PlaylistController {
    private final PlaylistService playlistService;
    private final HttpSession session;

    @GetMapping("/storage")
    public String storage() {
        return "playlist/storage";
    }
}
