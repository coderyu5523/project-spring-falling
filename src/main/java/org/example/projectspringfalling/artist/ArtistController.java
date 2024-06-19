package org.example.projectspringfalling.artist;

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

    @GetMapping("/artist/{id}")
    public String artistDetail(@PathVariable Integer id) {
        return "artist/artist-detail";
    }

}
