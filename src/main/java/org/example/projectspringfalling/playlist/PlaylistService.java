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
        List<RestResponse.PlaylistDTO> playlist = new ArrayList<>();


        String lyricsText1 = "00:00 One! Two! Q! W! E! R!\n" +
                "00:03 간주중\n"+
                "00:14 어떤 인사가 괜찮을까\n" +
                "00:17 천 번쯤 상상해 봤어\n" +
                "00:19 근데 오늘도 천 번 하고\n" +
                "00:22 한 번 더 고민 중\n" +
                "00:25 막상 네 앞에 서니 꽁꽁 얼어버렸다\n" +
                "00:29 숨겨왔던 나의 맘\n" +
                "00:31 반도 주지를 못했어\n" +
                "00:35 아, 아, 아직은\n" +
                "00:38 준비가 안됐다구요\n" +
                "00:40 소용돌이쳐 어지럽다구\n" +
                "00:45 쏟아지는 맘을 멈출 수가 없을까\n" +
                "00:51 너의 작은 인사 한마디에 요란해져서\n" +
                "00:57 네 맘의 비밀번호 눌러 열고 싶지만\n" +
                "01:01 너를 고민고민해도 좋은 걸\n" +
                "01:07 어쩌니\n"+
                "01:08 간주중\n"+
                "01:20 거울 앞에서 새벽까지 연습한 인사가\n" +
                "01:24 손을 들고 웃는 얼굴을 하고서\n" +
                "01:29 고개를 숙였다\n" +
                "01:31 아, 아, 아직도 준비가 안됐나 봐요\n" +
                "01:36 소용돌이쳐 어지럽다구\n" +
                "01:41 쏟아지는 맘을 멈출 수가 없을까?\n" +
                "01:46 너의 작은 인사 한마디에 요란해져서\n" +
                "01:52 네 맘의 비밀번호 눌러 열고 싶지만\n" +
                "01:57 너를 고민고민해도 좋은 걸\n" +
                "02:03 이러지도 저러지도 못하는데\n" +
                "02:05 속이 왈칵 뒤집히고\n" +
                "02:08 이쯤 왔으면 눈치 챙겨야지\n" +
                "02:11 날 봐달라구요!\n" +
                "02:14 좋아한다 너를 좋아한다 좋아해\n" +
                "02:21 너를 많이 많이 좋아한단 말이야\n" +
                "02:26 벅차오르다 못해 내 맘이 쿡쿡 아려와\n" +
                "02:33 두 번은 말 못 해 너 지금 잘 들어봐\n" +
                "02:37 매일 고민하고 연습했던 말\n" +
                "02:43 좋아해";

        String lyricsText2 =
                "00:00 간주중\n" +
                "00:13 아니길 바랬었어\n" +
                "00:19 꿈이길 기도했지\n" +
                "00:26 너 없는 가슴으로 살아가야 하는 건\n" +
                "00:33 내게는 너무 힘겨운걸\n" +
                "00:40 그렇게 사랑했던\n" +
                "00:46 너무도 소중했던\n" +
                "00:53 지난날이 서러워 자꾸 눈물이 흘러\n" +
                "01:00 내 삶은 너뿐인데\n" +
                "01:10 사랑해 널 잊을 순 없을 거야\n" +
                "01:16 미안해 너를 지키지 못한 것을\n" +
                "01:23 너의 행복한 모습 나 보기를 원해\n" +
                "01:30 부디 새롭게 시작하길 바래\n" +
                "01:36 하늘이 우리를 갈라 놓지만\n" +
                "01:43 눈물로 너를 보내려고 하지만\n" +
                "01:50 너를 얼마나 내가 사랑했는 줄 아니\n" +
                "01:57 영원히 너를 지켜보며 살 거야\n" +
                "02:03 행복하길 바래\n" +
                "02:07 간주중\n" +
                "02:16 그렇게 사랑했던\n" +
                "02:23 너무도 소중했던\n" +
                "02:30 지난날이 서러워 자꾸 눈물이 흘러\n" +
                "02:36 내 삶은 너뿐인데\n" +
                "02:43 우워~\n" +
                "02:46 사랑해 널 잊을 순 없을 거야\n" +
                "02:53 미안해 너를 지키지 못한 것을\n" +
                "03:00 너의 행복한 모습 나 보기를 원해\n" +
                "03:07 부디 새롭게 시작하길 바래\n" +
                "03:13 하늘이 우리를 갈라 놓지만\n" +
                "03:20 눈물로 너를 보내려고 하지만\n" +
                "03:27 너를 얼마나 내가 사랑했는 줄 아니\n" +
                "03:33 영원히 너를 지켜보며 살 거야\n" +
                "03:40 행복하길 바래\n" +
                "03:43 oh 널 사랑해\n" +
                "03:46 미안해 너를 지키지 못한 것을\n" +
                "03:53 너의 행복한 모습 나 보기를 원해\n" +
                "04:00 부디 새롭게 시작하길 바래\n" +
                "04:06 행복하길 바래\n";



        List<RestResponse.LyricLineDTO> lyrics1 = LyricsUtil.parseLyrics(lyricsText1);
        List<RestResponse.LyricLineDTO> lyrics2 = LyricsUtil.parseLyrics(lyricsText2);

        playlist.add(new RestResponse.PlaylistDTO("고민중독", "QWER", "/upload/song/고민중독.mp3", "/upload/album/고민중독.jpg", lyrics1)) ;
        playlist.add(new RestResponse.PlaylistDTO("천상연", "이창섭", "/upload/song/천상연-이창섭.mp3", "/upload/album/천상연.jpg", lyrics2)) ;
        playlist.add(new RestResponse.PlaylistDTO("헤어지자 말해요", "박재정", "/upload/song/헤어지자말해요.mp3", "/upload/album/Alone.jpg", null)) ;


        return playlist;
    }

}
