package org.example.projectspringfalling.album;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class AlbumController {
    private final AlbumService albumService;
    private final HttpSession session;


    @GetMapping("/albums/{id}")
    public String songList(@PathVariable Integer id) {
//        return "album/album-list";
        return "album/album-detail";
    }
}
