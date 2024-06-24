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
        List<RestResponse.PlaylistDTO> songs = new ArrayList<>();
        songs.add(new RestResponse.PlaylistDTO("고민중독", "QWER", "/upload/song/고민중독.mp3", "/upload/album/고민중독.jpg","이동혁, 한아영\n" +
                "One! Two! Q! W! E! R! \n" +
                "\n" +
                "어떤 인사가 괜찮을까 \n" +
                "천 번쯤 상상해 봤어\n" +
                "근데 오늘도 천 번 하고 \n" +
                "한 번 더 고민 중\n" +
                "\n" +
                "막상 네 앞에 서니 꽁꽁 얼어버렸다\n" +
                "숨겨왔던 나의 맘 \n" +
                "절반의 반도 주지를 못했어\n" +
                "\n" +
                "아, 아, 아직은\n" +
                "준비가 안됐다구요\n" +
                "소용돌이쳐 어지럽다구\n" +
                "\n" +
                "쏟아지는 맘을 멈출 수가 없을까?\n" +
                "너의 작은 인사 한마디에 요란해져서\n" +
                "네 맘의 비밀번호 눌러 열고 싶지만\n" +
                "너를 고민고민해도 좋은 걸 어쩌니\n" +
                "\n" +
                "거울 앞에서 새벽까지 연습한 인사가\n" +
                "손을 들고 웃는 얼굴을 하고서 \n" +
                "고개를 숙였다\n" +
                "\n" +
                "아, 아, 아직도 준비가 안됐나 봐요\n" +
                "소용돌이쳐 어지럽다구\n" +
                "\n" +
                "쏟아지는 맘을 멈출 수가 없을까?\n" +
                "너의 작은 인사 한마디에 요란해져서\n" +
                "네 맘의 비밀번호 눌러 열고 싶지만\n" +
                "너를 고민고민해도 좋은 걸\n" +
                "\n" +
                "이러지도 저러지도 못하는데\n" +
                "속이 왈칵 뒤집히고\n" +
                "이쯤 왔으면 눈치 챙겨야지\n" +
                "날 봐달라구요!\n" +
                "\n" +
                "좋아한다 너를 좋아한다 좋아해\n" +
                "\n" +
                "너를 많이 많이 좋아한단 말이야\n" +
                "벅차오르다 못해 내 맘이 쿡쿡 아려와\n" +
                "두 번은 말 못 해 너 지금 잘 들어봐\n" +
                "매일 고민하고 연습했던 말\n" +
                "좋아해"));
        songs.add(new RestResponse.PlaylistDTO("봄여름가을겨울", "빅뱅", "/upload/song/봄여름가을겨울.mp3", "/upload/album/봄여름가을겨울.jpg","이듬해 질 녘 꽃 피는 봄 \n" +
                "한여름 밤의 꿈\n" +
                "가을 타 겨울 내릴 눈 \n" +
                "1년 네 번 또다시 봄\n" +
                " \n" +
                "정들었던 내 젊은 날 \n" +
                "이제는 안녕\n" +
                "아름답던 우리의 \n" +
                "봄 여름 가을 겨울\n" +
                " \n" +
                "“Four seasons with no reason.”\n" +
                "비 갠 뒤에 비애(悲哀) 대신 \n" +
                "a happy end\n" +
                "비스듬히 씩 비웃듯 \n" +
                "칠색 무늬의 무지개\n" +
                "철없이 철 지나 철들지 못해(still)\n" +
                "철부지에 철 그른지 오래, \n" +
                "Marchin’ 비발디\n" +
                "차이코프스키,\n" +
                "오늘의 사계를 맞이해\n" +
                "마침내, 마치 넷이 못내\n" +
                " \n" +
                "Boy 저 하늘만 바라보고서 \n" +
                "사계절 잘 지내고 있어 Good-bye \n" +
                "떠난 사람 또 나타난 사람\n" +
                "머리 위 저세상 \n" +
                "난 떠나 영감의 amazon\n" +
                "지난 밤의 트라우마 다 묻고 \n" +
                "목숨 바쳐 달려올 \n" +
                "새 출발 하는 왕복선 \n" +
                "변할래 전보다는 더욱더\n" +
                "좋은 사람 더욱더 \n" +
                "더 나은 사람 더욱더\n" +
                "아침 이슬을 맞고 \n" +
                "내 안에 분노 과거에 묻고\n" +
                "For Life\n" +
                "\n" +
                "울었던 웃었던 \n" +
                "소년과 소녀가 그리워 나\n" +
                "찬란했던 사랑했던 \n" +
                "그 시절만 자꾸 기억나\n" +
                " \n" +
                "계절은 날이 갈수록 \n" +
                "속절없이 흘러\n" +
                "붉게 물들이고 파랗게 멍들어 \n" +
                "가슴을 훑고\n" +
                "\n" +
                "언젠가 다시 올 \n" +
                "그날 그때를 위하여 \n" +
                "(그대를 위하여)\n" +
                "아름다울 우리의 \n" +
                "봄 여름 가을 겨울\n" +
                "\n" +
                "La la la la la la la la la la la \n" +
                "La la la la la la la la la la la \n" +
                "La la la la la la la la la la la \n" +
                "La la la la la la la la la la la \n" +
                "\n" +
                "이듬해 질 녘 꽃 피는 봄 \n" +
                "한여름 밤의 꿈\n" +
                "가을 타 겨울 내린 눈 \n" +
                "봄 여름 가을 겨울\n"));
        songs.add(new RestResponse.PlaylistDTO("슈퍼노바", "에스파", "/upload/song/슈퍼노바.mp3", "/upload/album/슈퍼노바.jpg","I’m like some kind of Supernova\n" +
                "Watch out\n" +
                "\n" +
                "Look at me go\n" +
                "재미 좀 볼\n" +
                "빛의 Core\n" +
                "So hot hot\n" +
                "문이 열려\n" +
                "서로의 존재를 느껴\n" +
                "마치 Discord\n" +
                "날 닮은 너 너 누구야\n" +
                "(Drop)\n" +
                "\n" +
                "사건은 다가와 Ah Oh Ay\n" +
                "거세게 커져가 Ah Oh Ay\n" +
                "That tick that tick tick bomb\n" +
                "That tick that tick tick bomb\n" +
                "감히 건드리지 못할 걸\n" +
                "(누구도 말이야)\n" +
                "지금 내 안에선\n" +
                "Su su su Supernova\n" +
                "\n" +
                "Nova\n" +
                "Can’t stop hyperstellar\n" +
                "원초 그걸 찾아\n" +
                "Bring the light of a dying star\n" +
                "불러낸 내 우주를 봐 봐\n" +
                "Supernova\n" +
                "\n" +
                "Ah Body bang\n" +
                "Make it feel too right\n" +
                "\n" +
                "휩쓸린 에너지 It’s so special\n" +
                "잔인한 Queen 이며 Scene 이자 종결\n" +
                "이토록 거대한 내 안의 Explosion\n" +
                "내 모든 세포 별로부터 만들어져\n" +
                "(Under my control Ah)\n" +
                "\n" +
                "질문은 계속돼 Ah Oh Ay\n" +
                "우린 어디서 왔나 Oh Ay\n" +
                "느껴 내 안에선\n" +
                "Su su su Supernova\n" +
                "\n" +
                "Nova\n" +
                "Can’t stop hyperstellar\n" +
                "원초 그걸 찾아\n" +
                "Bring the light of a dying star\n" +
                "불러낸 내 우주를 봐 봐\n" +
                "Supernova\n" +
                "\n" +
                "보이지 않는 힘으로\n" +
                "네게 손 내밀어 볼까\n" +
                "가능한 모든 가능성\n" +
                "무한 속의 너를 만나\n" +
                "It’s about to bang bang\n" +
                "Don’t forget my name\n" +
                "Su su su Supernova\n" +
                "\n" +
                "사건은 다가와 Ah Oh Ay\n" +
                "거세게 커져가 Ah Oh Ay\n" +
                "질문은 계속돼 Ah Oh Ay\n" +
                "우린 어디서 왔나 Oh Ay\n" +
                "\n" +
                "사건은 다가와 Ah Oh Ay\n" +
                "거세게 커져가 Ah Oh Ay\n" +
                "Tell me, tell me, tell me Oh Ay\n" +
                "우린 어디서 왔나 Oh Ay\n" +
                "우린 어디서 왔나 Oh Ay\n" +
                "\n" +
                "Nova\n" +
                "Can’t stop hyperstellar\n" +
                "원초 그걸 찾아\n" +
                "Bring the light of a dying star\n" +
                "불러낸 내 우주를 봐 봐\n" +
                "Supernova\n" +
                "\n" +
                "사건은 다가와 Ah Oh Ay\n" +
                "(Nu star)\n" +
                "거세게 커져가 Ah Oh Ay\n" +
                "질문은 계속돼 Ah Oh Ay\n" +
                "(Nova)\n" +
                "우린 어디서 왔나 Oh Ay\n" +
                "\n" +
                "사건은 다가와 Ah Oh Ay\n" +
                "거세게 커져가 Ah Oh Ay\n" +
                "질문은 계속돼 Ah Oh Ay\n" +
                "(Nova)\n" +
                "Bring the light of a dying star\n" +
                "Supernova\n"));
        return songs;


    }
}
