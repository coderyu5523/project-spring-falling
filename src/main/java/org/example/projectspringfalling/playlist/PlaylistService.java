package org.example.projectspringfalling.playlist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public List<PlaylistResponse.PlaylistDTO> musicTest() {
        List<PlaylistResponse.PlaylistDTO> songs = new ArrayList<>();
        songs.add(new PlaylistResponse.PlaylistDTO("고민중독","QWER","/upload/song/고민중독.mp3","/upload/album/고민중독.jpg"));
        songs.add(new PlaylistResponse.PlaylistDTO("봄여름가을겨울","빅뱅","/upload/song/봄여름가을겨울.mp3","/upload/album/봄여름가을겨울.jpg"));
        songs.add(new PlaylistResponse.PlaylistDTO("슈퍼노바","에스파","/upload/song/슈퍼노바.mp3","/upload/album/슈퍼노바.jpg"));
        return songs;

    }
}
