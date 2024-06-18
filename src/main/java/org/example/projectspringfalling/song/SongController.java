package org.example.projectspringfalling.song;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {

    @GetMapping("/song-detail")
    public String songDetail() {
        return "song/song-detail";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/playlist")
    public String playlist() {
        return "song/playlist";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/song-list")
    public String songList() {
        return "song/song-list";
    }

    @GetMapping("/song-chart")
    public String songChart() {
        return "song/song-chart";
    }

    @GetMapping("/song-genre")
    public String songGenre(){
        return "song/song-genre";
    }

}
