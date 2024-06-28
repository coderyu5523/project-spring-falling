package org.example.projectspringfalling.RestAPI;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.ApiUtil;
import org.example.projectspringfalling.history.HistoryResponse;
import org.example.projectspringfalling.history.HistoryService;
import org.example.projectspringfalling.like.LikeService;
import org.example.projectspringfalling.playlist.PlaylistService;
import org.example.projectspringfalling.playlistSong.PlaylistSongRequest;
import org.example.projectspringfalling.playlistSong.PlaylistSongService;
import org.example.projectspringfalling.song.SongService;
import org.example.projectspringfalling.user.SessionUser;
import org.example.projectspringfalling.user.UserResponse;
import org.example.projectspringfalling.user.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final HttpSession session;
    private final RedisTemplate<String, Object> rt;
    private final SongService songService;
    private final PlaylistService playlistService;
    private final PlaylistSongService playlistSongService;
    private final UserService userService;
    private final LikeService likeService;
    private final HistoryService historyService;

    // 필터 및 정렬
    @GetMapping("/{artistId}/sort-and-filter/songs")
    public ResponseEntity<?> sortAndFilterSongs(
            @RequestParam(name = "keyword", required = false) String keyword,
            @PathVariable(name = "artistId") Integer artistId) {
        return ResponseEntity.ok(new ApiUtil<>(songService.sortAndFilterSongs(keyword.trim(), artistId)));
    }

    // 필터 및 정렬
    @GetMapping("/{artistId}/sort-and-filter/albums")
    public ResponseEntity<?> sortAndFilterAlbums(
            @RequestParam(name = "keyword", required = false) String keyword,
            @PathVariable(name = "artistId") Integer artistId) {
        return ResponseEntity.ok(new ApiUtil<>(songService.sortAndFilterAlbums(keyword.trim(), artistId)));
    }


    // 검색 자동완성 기능
    @GetMapping("/search/auto")
    public ApiUtil<List<RestResponse.SearchAutoCompleteDTO>> searchAuto(@RequestParam("keyword") String keyword) {
        List<RestResponse.SearchAutoCompleteDTO> responseDTO = songService.searchKeywordAuto(keyword);
        return new ApiUtil<>(responseDTO);
    }

    // 보관함 - 내 리스트
    // 플레이리스트 모달
    @GetMapping("/storage/my-list")
    public ResponseEntity<?> storageMyList() {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        return ResponseEntity.ok(new ApiUtil<>(playlistService.getMyList(sessionUser.getId())));
    }

    // 보관함 - 좋아요(곡)
    @GetMapping("/storage/like-song")
    public ResponseEntity<?> storageLikedSongs() {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        return ResponseEntity.ok(new ApiUtil<>(likeService.getLikedSongs(sessionUser.getId())));
    }

    // 보관함 - 좋아요(앨범)
    @GetMapping("/storage/like-album")
    public ResponseEntity<?> storageLikedAlbums() {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        return ResponseEntity.ok(new ApiUtil<>(likeService.getLikedAlbums(sessionUser.getId())));
    }

    // 보관함 - 좋아요(아티스트)
    @GetMapping("/storage/like-artist")
    public ResponseEntity<?> storageLikedArtists() {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        return ResponseEntity.ok(new ApiUtil<>(likeService.getLikedArtists(sessionUser.getId())));
    }

    // 보관함 - 최근 감상
    @GetMapping("/storage/recent-song")
    public ResponseEntity<?> storageRecentSongs() {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        return ResponseEntity.ok(new ApiUtil<>(historyService.getRecentSongs(sessionUser.getId())));
    }

    // 플레이리스트 추가하기(모달)
    @PostMapping("/add-playlist")
    public ResponseEntity<?> addPlaylist(String playlistName) {
        System.out.println("playlistName : " + playlistName);
        UserResponse.LoginDTO sessionUser = (UserResponse.LoginDTO) rt.opsForValue().get("sessionUser");
        return ResponseEntity.ok(new ApiUtil<>(playlistService.addPlaylist(sessionUser.getId(), playlistName)));
    }

    // 플레이리스트 곡 추가하기
    @PostMapping("/add-song")
    public ResponseEntity<?> addSongToPlaylist(PlaylistSongRequest.AddSongToPlaylist requestDTO) {
        return playlistSongService.addSongToPlaylist(requestDTO);
    }

    // 재생중인 플레이리스트 데이터 요청
    @GetMapping("/api/playlists/current")
    public List<RestResponse.PlaylistDTO> getCurrentPlaylist() {
        return new ArrayList<>(playlistService.musicTest());
    }

    // 현재 비밀번호 일치 확인
    @GetMapping("/api/password-same-check")
    public @ResponseBody ApiUtil<Boolean> passwordSameCheck(@RequestParam String inputPassword) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        Boolean isValid = userService.passwordCheck(sessionUser.getEmail(), inputPassword);
        return new ApiUtil<>(isValid);
    }

    //  조회수 카운트
    @PutMapping("/api/songs/count")
    public RestResponse.listenCountDTO songCount(Long listenCount, Integer songId) {
        return songService.updateCount(listenCount, songId);

    }

    @PostMapping("/api/history")
    public HistoryResponse.SaveDTO history(Integer songId) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        return historyService.saveHistory(sessionUser, songId);
    }
}
