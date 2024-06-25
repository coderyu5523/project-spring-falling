package org.example.projectspringfalling.playlistSong;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.ApiUtil;
import org.example.projectspringfalling.playlist.Playlist;
import org.example.projectspringfalling.song.Song;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PlaylistSongService {
    private final PlaylistSongRepository playlistSongRepository;

    // 플레이리스트 곡 추가하기
    @Transactional
    public ResponseEntity<?> addSongToPlaylist(PlaylistSongRequest.AddSongToPlaylist requestDTO) {
        if (playlistSongRepository.findByPlaylistIdAndUserId(requestDTO.getPlaylistId(), requestDTO.getSongId()).isPresent()) {
            return ResponseEntity.ok(new ApiUtil<>(400, "이미 플레이리스트에 곡이 존재합니다."));
        }

        PlaylistSong playlistSong = PlaylistSong.builder()
                .song(Song.builder().id(requestDTO.getSongId()).build())
                .playlist(Playlist.builder().id(requestDTO.getPlaylistId()).build())
                .build();
        playlistSongRepository.save(playlistSong);

        return ResponseEntity.ok(new ApiUtil<>(null));
    }
}
