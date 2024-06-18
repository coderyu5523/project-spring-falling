package org.example.projectspringfalling.album;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AlbumController {

    @GetMapping("/albums/{id}")
    public String songList(@PathVariable Integer id) {
        return "album/album-detail";
    }
}
