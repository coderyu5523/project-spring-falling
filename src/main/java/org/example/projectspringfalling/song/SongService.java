package org.example.projectspringfalling.song;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.album.AlbumRepository;
import org.example.projectspringfalling.like.LikeRepository;
import org.example.projectspringfalling.playlist.Playlist;
import org.example.projectspringfalling.playlist.PlaylistRepository;
import org.example.projectspringfalling.playlistSong.PlaylistSongRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final PlaylistRepository playlistRepository;
    private final PlaylistSongRepository playlistSongRepository;
    private final LikeRepository likeRepository;

    // 필터 및 정렬 (곡)
    public List<RestResponse.SongListDTO> sortAndFilterSongs(String keyword, Integer artistId) {
        List<RestResponse.SongListDTO> songListDTO = albumRepository.sortAndFilterSongs(artistId).stream()
                .flatMap(album -> songRepository.findByAlbumId(album.getId()).stream()
                        .map(song -> new RestResponse.SongListDTO(song, album)))
                .toList();

        boolean isRegularAndSingle = false;
        boolean isMini = false;
        boolean isRecentSort = false;
        boolean isPopularSort = false;
        boolean isAlphabeticalSort = false;

        if (keyword != null && !keyword.isEmpty()) {
            String[] tokens = keyword.split("\\s*,\\s*");

            for (String token : tokens) {
                if (token.contains("정규/싱글")) {
                    isRegularAndSingle = true;
                }
                if (token.contains("미니")) {
                    isMini = true;
                }
                if (token.contains("최신순")) {
                    isRecentSort = true;
                }
                if (token.contains("인기순")) {
                    isPopularSort = true;
                }
                if (token.contains("가나다순")) {
                    isAlphabeticalSort = true;
                }
            }
        }

        boolean finalIsRegularAndSingle = isRegularAndSingle;
        boolean finalIsMini = isMini;
        boolean finalIsRecentSort = isRecentSort;
        boolean finalIsPopularSort = isPopularSort;
        boolean finalIsAlphabeticalSort = isAlphabeticalSort;

        return songListDTO.stream()
                .filter(song -> {
                    if (finalIsRegularAndSingle) {
                        return "싱글".equals(song.getCategory()) || "정규".equals(song.getCategory());
                    }
                    if (finalIsMini) {
                        return "미니".equals(song.getCategory());
                    }
                    return true;
                })
                .sorted((song1, song2) -> {
                    if (finalIsRecentSort) {
                        return song2.getCreatedAt().compareTo(song1.getCreatedAt()); // 최신순 내림차순 정렬
                    }
                    if (finalIsPopularSort) {
                        return Long.compare(song2.getListenCount(), song1.getListenCount()); // 인기순 내림차순 정렬
                    }
                    if (finalIsAlphabeticalSort) {
                        return song1.getTitle().compareToIgnoreCase(song2.getTitle()); // 가나다순 오름차순 정렬
                    }
                    return 0; // 기본 정렬 방식
                })
                .collect(Collectors.toList());
    }

    // 필터 및 정렬 (앨범)
    public List<RestResponse.AlbumListDTO> sortAndFilterAlbums(String keyword, Integer artistId) {
        List<RestResponse.AlbumListDTO> albumListDTO = albumRepository.sortAndFilterAlbums(artistId).stream()
                .flatMap(album -> songRepository.findByAlbumId(album.getId()).stream()
                        .map(song -> new RestResponse.AlbumListDTO(song, album)))
                .toList();

        boolean isRegularAndSingle = false;
        boolean isMini = false;
        boolean isRecentSort = false;
        boolean isPopularSort = false;
        boolean isAlphabeticalSort = false;

        if (keyword != null && !keyword.isEmpty()) {
            String[] tokens = keyword.split("\\s*,\\s*");

            for (String token : tokens) {
                if (token.contains("정규/싱글")) {
                    isRegularAndSingle = true;
                }
                if (token.contains("미니")) {
                    isMini = true;
                }
                if (token.contains("최신순")) {
                    isRecentSort = true;
                }
                if (token.contains("인기순")) {
                    isPopularSort = true;
                }
                if (token.contains("가나다순")) {
                    isAlphabeticalSort = true;
                }
            }
        }

        boolean finalIsRegularAndSingle = isRegularAndSingle;
        boolean finalIsMini = isMini;
        boolean finalIsRecentSort = isRecentSort;
        boolean finalIsPopularSort = isPopularSort;
        boolean finalIsAlphabeticalSort = isAlphabeticalSort;

        Set<Integer> seenAlbumIds = new HashSet<>();

        return albumListDTO.stream()
                .filter(album -> {
                    if (seenAlbumIds.contains(album.getAlbumId())) {
                        return false; // 중복된 앨범 아이디는 필터링
                    }
                    seenAlbumIds.add(album.getAlbumId());
                    if (finalIsRegularAndSingle) {
                        return "싱글".equals(album.getCategory()) || "정규".equals(album.getCategory());
                    }
                    if (finalIsMini) {
                        return "미니".equals(album.getCategory());
                    }
                    return true;
                })
                .sorted((album1, album2) -> {
                    if (finalIsRecentSort) {
                        return album2.getAlbumCreatedAt().compareTo(album1.getAlbumCreatedAt()); // 최신순 내림차순 정렬
                    }
                    if (finalIsPopularSort) {
                        return Long.compare(album2.getListenCount(), album1.getListenCount()); // 인기순 내림차순 정렬
                    }
                    if (finalIsAlphabeticalSort) {
                        return album1.getTitle().compareToIgnoreCase(album2.getTitle()); // 가나다순 오름차순 정렬
                    }
                    return 0; // 기본 정렬 방식
                })
                .collect(Collectors.toList());
    }


    // 메인 차트
    public List<SongResponse.ChartDTO> mainChart() {
        List<Song> songList = songRepository.findMainChart();
        return IntStream.range(0, songList.size())
                .mapToObj(i -> new SongResponse.ChartDTO(songList.get(i), songList.get(i).getAlbum(), songList.get(i).getArtist(), i + 1))
                .collect(Collectors.toList());
    }

    // 해외 소셜 차트
    public List<SongResponse.ChartDTO> globalChart() {
        List<Song> songList = songRepository.findGlobalChart();
        return IntStream.range(0, songList.size())
                .mapToObj(i -> new SongResponse.ChartDTO(songList.get(i), songList.get(i).getAlbum(), songList.get(i).getArtist(), i + 1))
                .collect(Collectors.toList());
    }

    // 국내 발라드 차트
    public List<SongResponse.ChartDTO> domesticBalladChart() {
        List<Song> songList = songRepository.findDomesticBalladChart();
        return IntStream.range(0, songList.size())
                .mapToObj(i -> new SongResponse.ChartDTO(songList.get(i), songList.get(i).getAlbum(), songList.get(i).getArtist(), i + 1))
                .collect(Collectors.toList());
    }

    // 해외 팝 차트
    public List<SongResponse.ChartDTO> globalPopChart() {
        List<Song> songList = songRepository.findGlobalPopChart();
        return IntStream.range(0, songList.size())
                .mapToObj(i -> new SongResponse.ChartDTO(songList.get(i), songList.get(i).getAlbum(), songList.get(i).getArtist(), i + 1))
                .collect(Collectors.toList());
    }

    // 해외 힙합 차트
    public List<SongResponse.ChartDTO> globalHipHopChart() {
        List<Song> songList = songRepository.findGlobalHipHopChart();
        return IntStream.range(0, songList.size())
                .mapToObj(i -> new SongResponse.ChartDTO(songList.get(i), songList.get(i).getAlbum(), songList.get(i).getArtist(), i + 1))
                .collect(Collectors.toList());
    }

    // 국내 알앤비 차트
    public List<SongResponse.ChartDTO> domesticRBChart() {
        List<Song> songList = songRepository.findDomesticRBChart();
        return IntStream.range(0, songList.size())
                .mapToObj(i -> new SongResponse.ChartDTO(songList.get(i), songList.get(i).getAlbum(), songList.get(i).getArtist(), i + 1))
                .collect(Collectors.toList());
    }

    // 국내 댄스,일렉 차트
    public List<SongResponse.ChartDTO> domesticDanceAndElectronicChart() {
        List<Song> songList = songRepository.findDomesticDanceAndElectronicChart();
        return IntStream.range(0, songList.size())
                .mapToObj(i -> new SongResponse.ChartDTO(songList.get(i), songList.get(i).getAlbum(), songList.get(i).getArtist(), i + 1))
                .collect(Collectors.toList());
    }

    // 메인 페이지
    public SongResponse.MainDTO main() {

        Pageable pageable = PageRequest.of(0, 6); // 6개만 가져오려고 pageable 설정

        // 오늘 발매 음악
        List<Album> albumList = albumRepository.findLatestAlbums(pageable);
        List<SongResponse.MainDTO.LatestAlbumDTO> latestAlbumList = albumList.stream().map(album -> {
            return new SongResponse.MainDTO.LatestAlbumDTO(album, album.getArtist());
        }).toList();

        // 오늘의 HOT&NEW
        List<Playlist> newPlaylist = playlistRepository.findNewPlaylist(pageable);
        List<SongResponse.MainDTO.AdminPlaylistDTO> hotAndNewPlaylist = newPlaylist.stream().map(p -> {
            String playlistImg = playlistSongRepository.findByPlaylistId(p.getId()).getFirst().getSong().getAlbum().getAlbumImg();
            return new SongResponse.MainDTO.AdminPlaylistDTO(p, playlistImg);
        }).toList();

        // 장르 콜렉션

        // Editor's PICK
        List<Playlist> playlist = playlistRepository.findAdminPlaylist(pageable);
        List<SongResponse.MainDTO.AdminPlaylistDTO> adminPlaylist = playlist.stream().map(p -> {
            String playlistImg = playlistSongRepository.findByPlaylistId(p.getId()).getFirst().getSong().getAlbum().getAlbumImg();
            return new SongResponse.MainDTO.AdminPlaylistDTO(p, playlistImg);
        }).toList();
        return new SongResponse.MainDTO(latestAlbumList, adminPlaylist, hotAndNewPlaylist);
    }

    // 곡 상세보기
    public SongResponse.DetailDTO songDetail(Integer songId, Integer userId) {
        Song song = songRepository.findSongAndAlbumAndArtistById(songId);

        return new SongResponse.DetailDTO(song, song.getAlbum(), likeRepository.findLikeByUserIdAndSongId(userId, songId).isPresent());
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

    @Transactional
    public RestResponse.listenCountDTO updateCount(Long listenCount, Integer songId) {
        Song song = songRepository.findById(songId).orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));
        Long newListenCount = listenCount + song.getListenCount();
        song.updateCount(newListenCount);
        return new RestResponse.listenCountDTO(song);
    }
}
