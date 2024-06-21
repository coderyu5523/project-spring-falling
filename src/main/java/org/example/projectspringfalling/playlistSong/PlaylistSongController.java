package org.example.projectspringfalling.playlistSong;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.playlist.PlaylistService;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class PlaylistSongController {
    private final PlaylistService playlistService;
}
