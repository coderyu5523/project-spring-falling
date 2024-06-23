package org.example.projectspringfalling.playlistSong;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaylistSongService {
    private final PlaylistSongRepository playlistSongRepository;


}
