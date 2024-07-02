package org.example.projectspringfalling.RestAPI;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.ApiUtil;

import org.example.projectspringfalling.artist.ArtistService;

import org.example.projectspringfalling._core.utils.RedisUtil;

import org.example.projectspringfalling.history.HistoryResponse;
import org.example.projectspringfalling.history.HistoryService;
import org.example.projectspringfalling.like.LikeService;
import org.example.projectspringfalling.payment.IamportService;
import org.example.projectspringfalling.payment.PaymentRequest;
import org.example.projectspringfalling.payment.PaymentService;
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

    private final ArtistService artistService;

    private final PaymentService paymentService;
    private final IamportService iamportService;
    private final RedisUtil redisUtil;

    // 환불
    @PostMapping("/refund-payment")
    public ResponseEntity<?> refundPayment() {
        SessionUser sessionUser = redisUtil.getSessionUser();
        paymentService.refundPayment(sessionUser);
        return ResponseEntity.ok("redirect:/");
    }

    // 결제 사전 검증
    @PostMapping("/prepare-payment")
    public ResponseEntity<?> preparePayment(@RequestBody PaymentRequest.PrepareDTO paymentRequest) {
        return iamportService.preparePayment(paymentRequest);
    }

    // 구매 처리
    @PostMapping("/pay")
    public ResponseEntity<?> pay(@RequestBody PaymentRequest.PaymentDTO paymentDTO) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        paymentService.savePayment(paymentDTO, sessionUser);
        return ResponseEntity.ok("redirect:/");
    }

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

    // 관리자 앨범 등록 아티스트 검색
    @GetMapping("/search/artist")
    public ResponseEntity<?> searchArtist(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(new ApiUtil<>(artistService.searchArtistWithKeyword(keyword)));
    }

    // 보관함 - 내 리스트
    // 플레이리스트 모달
    @GetMapping("/storage/my-list")
    public ResponseEntity<?> storageMyList() {
        SessionUser sessionUser = redisUtil.getSessionUser();
        return ResponseEntity.ok(new ApiUtil<>(playlistService.getMyList(sessionUser.getId())));
    }

    // 보관함 - 좋아요(곡)
    @GetMapping("/storage/like-song")
    public ResponseEntity<?> storageLikedSongs() {
        SessionUser sessionUser = redisUtil.getSessionUser();
        return ResponseEntity.ok(new ApiUtil<>(likeService.getLikedSongs(sessionUser.getId())));
    }

    // 보관함 - 좋아요(앨범)
    @GetMapping("/storage/like-album")
    public ResponseEntity<?> storageLikedAlbums() {
        SessionUser sessionUser = redisUtil.getSessionUser();
        return ResponseEntity.ok(new ApiUtil<>(likeService.getLikedAlbums(sessionUser.getId())));
    }

    // 보관함 - 좋아요(아티스트)
    @GetMapping("/storage/like-artist")
    public ResponseEntity<?> storageLikedArtists() {
        SessionUser sessionUser = redisUtil.getSessionUser();
        return ResponseEntity.ok(new ApiUtil<>(likeService.getLikedArtists(sessionUser.getId())));
    }

    // 보관함 - 최근 감상
    @GetMapping("/storage/recent-song")
    public ResponseEntity<?> storageRecentSongs() {
        SessionUser sessionUser = redisUtil.getSessionUser();
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

    // 앨범 좋아요 하기
    @PostMapping("/albums/like")
    public ResponseEntity<?> likeAlbum(@RequestBody Integer albumId) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        likeService.saveLikeAlbum(sessionUser.getId(), albumId);
        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    // 앨범 좋아요 삭제
    @DeleteMapping("/albums/like")
    public ResponseEntity<?> deleteAlbumLike(@RequestBody Integer albumId) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        likeService.deleteLikeAlbum(sessionUser.getId(), albumId);
        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    // 곡 좋아요 하기
    @PostMapping("/songs/like")
    public ResponseEntity<?> likeSong(@RequestBody Integer songId) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        likeService.saveLikeSong(sessionUser.getId(), songId);
        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    // 곡 좋아요 삭제
    @DeleteMapping("/songs/like")
    public ResponseEntity<?> deleteSongLike(@RequestBody Integer songId) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        likeService.deleteLikeSong(sessionUser.getId(), songId);
        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    // 아티스트 좋아요 하기
    @PostMapping("/artists/like")
    public ResponseEntity<?> likeArtist(@RequestBody Integer artistId) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        likeService.saveLikeArtist(sessionUser.getId(), artistId);
        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    // 아티스트 좋아요 삭제
    @DeleteMapping("/artists/like")
    public ResponseEntity<?> deleteArtistLike(@RequestBody Integer artistId) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        likeService.deleteLikeArtist(sessionUser.getId(), artistId);
        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    // 재생중인 플레이리스트 데이터 요청
    @GetMapping("/api/playlists/current")
    public List<RestResponse.PlaylistDTO> getCurrentPlaylist() {
        return new ArrayList<>(playlistService.musicTest());
    }

    // 현재 비밀번호 일치 확인
    @GetMapping("/api/password-same-check")
    public @ResponseBody ApiUtil<Boolean> passwordSameCheck(@RequestParam String inputPassword) {
        SessionUser sessionUser = redisUtil.getSessionUser();
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
        SessionUser sessionUser = redisUtil.getSessionUser();
        return historyService.saveHistory(sessionUser, songId);
    }
}
