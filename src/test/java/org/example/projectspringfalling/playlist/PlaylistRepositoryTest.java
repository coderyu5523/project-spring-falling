package org.example.projectspringfalling.playlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@DataJpaTest
public class PlaylistRepositoryTest {

    @Autowired
    PlaylistRepository playlistRepository;

    @Test
    public void findAdminPlaylist_test() {
        // given
        Pageable pageable = PageRequest.of(0, 6); // 6개만 가져오려고 pageable 설정

        // when
        List<Playlist> playlists = playlistRepository.findAdminPlaylist(pageable);

        // eye
        System.out.println(playlists);

        // then


    }
}
