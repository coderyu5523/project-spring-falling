package org.example.projectspringfalling.artist;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ArtistController {
    private final ArtistService artistService;
    private final HttpSession session;

}
