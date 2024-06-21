package org.example.projectspringfalling.song;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
}
