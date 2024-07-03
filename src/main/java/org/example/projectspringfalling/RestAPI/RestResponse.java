package org.example.projectspringfalling.RestAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.playlist.Playlist;
import org.example.projectspringfalling.song.Song;

import java.sql.Timestamp;
import java.util.List;

import static org.example.projectspringfalling._core.utils.DateUtil.timestampToString;

public class RestResponse {

    // 검색 및 정렬(앨범)
    @NoArgsConstructor
    @Data
    public static class AlbumListDTO {
        private Integer songId; // 곡 pk
        private String lyrics; // 가사
        private String title; // 곡 제목
        private String musicFile; // 음악 파일

        private Integer albumId; // 앨범 pk
        private String coverImg; // 앨범 이미지
        private String albumTitle; // 앨범 이름
        private String artistName; // 가수 이름
        private Timestamp albumCreatedAt; // 앨범 발매 날짜

        /* 필터와 정렬을 위해 필요 */
        private String category; // 앨범 카테고리
        // 앨범 발매 날짜
        private Long listenCount; // 곡 재생 횟수


        public AlbumListDTO(Song song, Album album) {
            this.songId = song.getId();
            this.title = song.getTitle();
            this.artistName = song.getArtist().getName();
            this.musicFile = song.getMusicFile();
            this.lyrics = song.getLyrics();
            this.albumId = album.getId();
            this.coverImg = album.getAlbumImg();
            this.albumTitle = album.getTitle();
            this.category = album.getCategory();
            this.albumCreatedAt = album.getCreatedAt();
            this.listenCount = song.getListenCount();
        }
    }

    // 검색 및 정렬(곡)
    @NoArgsConstructor
    @Data
    public static class SongListDTO {
        private Integer songId; // 곡 pk
        private String title; // 곡 제목
        private String artistName; // 가수 이름
        private String musicFile; // 음악 파일
        private String lyrics; // 가사
        private Integer albumId; // 앨범 pk
        private String coverImg; // 앨범 이미지
        private String albumTitle; // 앨범 이름
        /* 필터와 정렬을 위해 필요 */
        private String category; // 앨범 카테고리
        private Timestamp createdAt; // 곡 발매 날짜
        private Long listenCount; // 곡 재생 횟수


        public SongListDTO(Song song, Album album) {
            this.songId = song.getId();
            this.title = song.getTitle();
            this.artistName = song.getArtist().getName();
            this.musicFile = song.getMusicFile();
            this.lyrics = song.getLyrics();
            this.albumId = album.getId();
            this.coverImg = album.getAlbumImg();
            this.albumTitle = album.getTitle();
            this.category = album.getCategory();
            this.createdAt = song.getCreatedAt();
            this.listenCount = song.getListenCount();
        }
    }

    // 자동완성
    @Data
    public static class SearchAutoCompleteDTO {
        private String songTitle;
        private String albumTitle;
        private String artistName;

        public SearchAutoCompleteDTO(Song song) {
            this.songTitle = song.getTitle();
            this.albumTitle = song.getAlbum().getTitle();
            this.artistName = song.getArtist().getName();
        }
    }

    // 관리자 아티스트 검색(앨범 등록용)
    @AllArgsConstructor
    @Data
    public static class SearchArtistCompleteDTO {
        private Integer artistId;
        private String artistName;
    }

    // 보관함 플레이리스트
    @AllArgsConstructor
    @Data
    public static class StoragePlaylist {
        private Integer playlistId;
        private String playlistName;
        private String albumImg;
        private Long playlistSongCount;
        private Timestamp createdAt;

        public String getCreatedAt() {
            return timestampToString(this.createdAt);
        }
    }

    // 보관함 - 좋아요(곡)
    @AllArgsConstructor
    @Data
    public static class StorageLikeSongs {
        private Integer songId;
        private Integer albumId;
        private String albumImg;
        private String songName;
        private String albumTitle;
        private String artistName;
    }

    // 보관함 - 좋아요(앨범)
    @AllArgsConstructor
    @Data
    public static class StorageLikeAlbums {
        private Integer albumId;
        private String albumImg;
        private String albumTitle;
        private String artistName;
        private Timestamp createdAt;
        private String albumType;

        public String getCreatedAt() {
            return timestampToString(this.createdAt);
        }
    }

    // 보관함 - 좋아요(아티스트)
    @AllArgsConstructor
    @Data
    public static class StorageLikeArtists {
        private Integer artistId;
        private String artistImg;
        private String artistName;
        private String artistType;
    }

    // 보관함 - 최근 감상
    @AllArgsConstructor
    @Data
    public static class RecentSongs {
        private Integer songId;
        private Integer albumId;
        private String albumImg;
        private String songName;
        private String albumTitle;
        private String artistName;
    }

    // 재생중인 플레이리스트
    @Data
    public static class PlaylistDTO {
        private String songTitle;
        private String artistName;
        private String musicFile;
        private String albumImg;
        private List<LyricLineDTO> lyrics;


        public PlaylistDTO(String songTitle, String artistName, String musicFile, String albumImg, List<LyricLineDTO> lyrics) {
            this.songTitle = songTitle;
            this.artistName = artistName;
            this.musicFile = musicFile;
            this.albumImg = albumImg;
            this.lyrics = lyrics;
        }

    }

    // 가사 파싱
    @Data
    public static class LyricLineDTO {
        private int time;
        private String text;

        public LyricLineDTO(int time, String text) {
            this.time = time;
            this.text = text;
        }
    }

    // 플레이리스트 추가하기(모달)
    @Data
    public static class AddPlaylistDTO {
        private Integer playlistId;
        private String playlistName;

        public AddPlaylistDTO(Playlist playlist) {
            this.playlistId = playlist.getId();
            this.playlistName = playlist.getName();
        }
    }

    @Data
    public static class listenCountDTO {
        private Integer songId;
        private Long listenCount;

        public listenCountDTO(Song song) {
            this.songId = song.getId();
            this.listenCount = song.getListenCount();
        }
    }


}
