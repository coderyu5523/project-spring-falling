package org.example.projectspringfalling.song;

import org.assertj.core.api.Assertions;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class SongRepositoryTest {

    @Autowired
    SongRepository songRepository;

    @Test
    public void findSongAndAlbumAndArtistById_test() {
        // given
        Integer songId = 2;

        // when
        Song song = songRepository.findSongAndAlbumAndArtistById(songId);

        // eye
        System.out.println("findSongAndAlbumAndArtistById_test songTitle: " + song.getTitle());
        System.out.println("findSongAndAlbumAndArtistById_test albumTitle: " + song.getAlbum().getTitle());
        System.out.println("findSongAndAlbumAndArtistById_test artistName: " + song.getAlbum().getArtist().getName());

        // then
        Assertions.assertThat(song.getAlbum().getCategory()).isEqualTo("Dance");
        Assertions.assertThat(song.getAlbum().getArtist().getArtistType()).isEqualTo("Group");

    }

    @Test
    public void findByAlbumId_test() {
        // given
        Integer albumId = 1;

        // when
        List<Song> songs = songRepository.findByAlbumId(albumId);

        // eye
        System.out.println("findByAlbumId_test songTitle: " + songs.get(0).getTitle());
        System.out.println("findByAlbumId_test albumTitle: " + songs.get(0).getAlbum().getId());

        // then
        Assertions.assertThat(songs.get(0).getAlbum().getCategory()).isEqualTo("정규");
        Assertions.assertThat(songs.get(0).getAlbum().getArtist().getArtistType()).isEqualTo("Solo");

    }

    // 검색 페이지
    @Test
    public void searchKeyword_test(){
        //given
        String keyword = "사랑";

        //when
        List<Song> songList = songRepository.findByKeyword(keyword).orElseThrow(() -> new Exception404("조회된 데이터가 없습니다."));

        // eye
        System.out.println("searchKeyword_tEST songTitle: " + songList.get(1).getTitle());
        System.out.println("searchKeyword_tEST artistName: " + songList.get(1).getArtist().getName());
        System.out.println("searchKeyword_tEST genre: " + songList.get(1).getGenre());

        //then
        Assertions.assertThat(songList.get(0).getAlbum().getCategory()).isEqualTo("정규");
        Assertions.assertThat(songList.get(0).getAlbum().getArtist().getArtistType()).isEqualTo("Solo");
    }

    @Test
    public void searchKeywordAuto_test(){
        //given
        String keyword = "사랑";

        //when
        List<Song> songList = songRepository.findByAutoComplete(keyword).orElseThrow(() -> new RuntimeException("조회된 데이터가 없습니다."));

        // eye
        System.out.println("searchKeyword_tEST songTitle: " + songList.get(1).getTitle());
        System.out.println("searchKeyword_tEST artistName: " + songList.get(1).getArtist().getName());
        System.out.println("searchKeyword_tEST genre: " + songList.get(1).getGenre());

        //then
        Assertions.assertThat(songList.get(0).getAlbum().getArtist().getArtistType()).isEqualTo("Solo");
    }
}
