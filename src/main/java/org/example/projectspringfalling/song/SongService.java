package org.example.projectspringfalling.song;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.album.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    public List<RestResponse.SearchAutoCompleteDTO> searchKeywordAuto(String keyword) {
        List<Song> songList = songRepository.findByAutoComplete(keyword).orElseThrow(() -> new RuntimeException("조회된 데이터가 없습니다."));
        return songList.stream().map(song -> new RestResponse.SearchAutoCompleteDTO(song)).toList();
    }

}
