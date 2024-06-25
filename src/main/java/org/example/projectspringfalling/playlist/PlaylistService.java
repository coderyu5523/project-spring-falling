package org.example.projectspringfalling.playlist;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling._core.utils.LyricsUtil;
import org.example.projectspringfalling.playlistSong.PlaylistSongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final PlaylistSongRepository playlistSongRepository;

    // 보관함 플레이리스트 - Rest
    public List<RestResponse.StoragePlaylist> getMyList(Integer userId) {
        return playlistRepository.findAllPlaylistById(userId);
    }

    // 플레이리스트 상세보기
    public PlaylistResponse.PlaylistDetailDTO playlistDetail(Integer playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new Exception404("존재하지 않는 플레이리스트입니다."));
        List<PlaylistResponse.PlaylistDetailDTO.SongListDTO> playlistSongList = playlistSongRepository.findByPlaylistId(playlistId).stream().map(playlistSong -> {
            return new PlaylistResponse.PlaylistDetailDTO.SongListDTO(playlistSong.getSong(), playlistSong.getSong().getAlbum(), playlistSong.getSong().getArtist());
        }).toList();
        return new PlaylistResponse.PlaylistDetailDTO(playlist, playlistSongList);
    }

    // 재생중인 플레이리스트 테스트용
    public List<RestResponse.PlaylistDTO> musicTest() {
        String lyricsText = "00:00 qwer 고민중독 One! Two! Q! W! E! R!\n" +
                "00:04 어떤 인사가 괜찮을까\n" +
                "00:08 천 번쯤 상상해 봤어\n" +
                "00:11 근데 오늘도 천 번 하고\n" +
                "00:15 한 번 더 고민 중\n" +
                "00:19 막상 네 앞에 서니 꽁꽁 얼어버렸다\n" +
                "00:23 숨겨왔던 나의 맘\n" +
                "00:26 절반의 반도 주지를 못했어\n" +
                "00:30 아, 아, 아직은\n" +
                "00:33 준비가 안됐다구요\n" +
                "00:36 소용돌이쳐 어지럽다구\n" +
                "00:39 쏟아지는 맘을 멈출 수가 없을까?\n" +
                "00:43 너의 작은 인사 한마디에 요란해져서\n" +
                "00:47 네 맘의 비밀번호 눌러 열고 싶지만\n" +
                "00:51 너를 고민고민해도 좋은 걸 어쩌니\n" +
                "00:56 거울 앞에서 새벽까지 연습한 인사가\n" +
                "01:00 손을 들고 웃는 얼굴을 하고서\n" +
                "01:03 고개를 숙였다\n" +
                "01:07 아, 아, 아직도 준비가 안됐나 봐요\n" +
                "01:11 소용돌이쳐 어지럽다구\n" +
                "01:14 쏟아지는 맘을 멈출 수가 없을까?\n" +
                "01:18 너의 작은 인사 한마디에 요란해져서\n" +
                "01:22 네 맘의 비밀번호 눌러 열고 싶지만\n" +
                "01:26 너를 고민고민해도 좋은 걸\n" +
                "01:30 이러지도 저러지도 못하는데\n" +
                "01:34 속이 왈칵 뒤집히고\n" +
                "01:37 이쯤 왔으면 눈치 챙겨야지\n" +
                "01:41 날 봐달라구요!\n" +
                "01:45 좋아한다 너를 좋아한다 좋아해\n" +
                "01:49 너를 많이 많이 좋아한단 말이야\n" +
                "01:53 벅차오르다 못해 내 맘이 쿡쿡 아려와\n" +
                "01:57 두 번은 말 못 해 너 지금 잘 들어봐\n" +
                "02:01 매일 고민하고 연습했던 말\n" +
                "02:05 좋아해";

        List<RestResponse.PlaylistDTO.LyricLineDTO> lyrics = LyricsUtil.parseLyrics(lyricsText);

        RestResponse.PlaylistDTO playlistDTO = new RestResponse.PlaylistDTO("고민중독", "QWER", "/upload/song/고민중독.mp3", "/upload/album/고민중독.jpg", lyrics);

        List<RestResponse.PlaylistDTO> playlist = new ArrayList<>();
        playlist.add(playlistDTO);

        return playlist;
    }

}
