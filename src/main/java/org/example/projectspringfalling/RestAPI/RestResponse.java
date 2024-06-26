package org.example.projectspringfalling.RestAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.projectspringfalling.playlist.Playlist;
import org.example.projectspringfalling.song.Song;

import java.sql.Timestamp;
import java.util.List;

import static org.example.projectspringfalling._core.utils.DateUtil.timestampToString;

public class RestResponse {

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


}
