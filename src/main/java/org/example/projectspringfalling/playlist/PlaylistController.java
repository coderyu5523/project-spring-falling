package org.example.projectspringfalling.playlist;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class PlaylistController {
    private final PlaylistService playlistService;
    private final HttpSession session;

}
