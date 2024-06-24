package org.example.projectspringfalling.playlist;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.playlistSong.PlaylistSongRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;


    // 보관함 플레이리스트 - Rest
    public List<RestResponse.StoragePlaylist> getMyList(Integer userId) {
        return playlistRepository.findAllPlaylistById(userId);

    // 플레이리스트 상세보기
    public PlaylistResponse.PlaylistDetailDTO playlistDetail(Integer playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new Exception404("존재하지 않는 플레이리스트입니다."));
        List<PlaylistResponse.PlaylistDetailDTO.SongListDTO> playlistSongList = playlistSongRepository.findByPlaylistId(playlistId).stream().map(playlistSong -> {
            return new PlaylistResponse.PlaylistDetailDTO.SongListDTO(playlistSong.getSong(), playlistSong.getSong().getAlbum(), playlistSong.getSong().getArtist());
        }).toList();
        return new PlaylistResponse.PlaylistDetailDTO(playlist, playlistSongList);
    }

    public List<PlaylistResponse.PlaylistDTO> musicTest() {
        List<PlaylistResponse.PlaylistDTO> songs = new ArrayList<>();
        songs.add(new PlaylistResponse.PlaylistDTO("고민중독", "QWER", "/upload/song/고민중독.mp3", "/upload/album/고민중독.jpg"));
        songs.add(new PlaylistResponse.PlaylistDTO("봄여름가을겨울", "빅뱅", "/upload/song/봄여름가을겨울.mp3", "/upload/album/봄여름가을겨울.jpg"));
        songs.add(new PlaylistResponse.PlaylistDTO("슈퍼노바", "에스파", "/upload/song/슈퍼노바.mp3", "/upload/album/슈퍼노바.jpg"));
        return songs;


    }
}
