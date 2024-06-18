package org.example.projectspringfalling.song;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {

    @GetMapping("/songs-detail")
    public String songDetail() {
        return "song/song-detail";
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

}
