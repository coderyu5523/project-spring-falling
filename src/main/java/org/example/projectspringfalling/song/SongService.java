package org.example.projectspringfalling.song;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.album.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public SongResponse.SearchDTO searchKeyword(String keyword) {
        List<Song> songList = songRepository.findByKeyword(keyword).orElseThrow(() -> new Exception404("조회된 데이터가 없습니다."));
        return new SongResponse.SearchDTO(songList, keyword);
    }
}
