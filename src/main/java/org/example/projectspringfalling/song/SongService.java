package org.example.projectspringfalling.song;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.album.AlbumRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongResponse.DetailDTO songDetail(Integer songId) {
        Song song = songRepository.findSongAndAlbumAndArtistById(songId);
        return new SongResponse.DetailDTO(song, song.getAlbum());
    }

    public Song getImg(int id) {
        Song song = songRepository.findById(id).get();
        return song;
    }
}
