package org.example.projectspringfalling.RestAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.projectspringfalling.song.Song;

import java.sql.Timestamp;

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


    // 재생중인 플레이리스트 테스트용
    @Data
    public static class PlaylistDTO {
        private String songTitle;
        private String artistName;
        private String musicFile;
        private String albumImg;
        private String lyrics;

        public PlaylistDTO(String songTitle, String artistName, String musicFile, String albumImg,String lyrics) {
            this.songTitle = songTitle;
            this.artistName = artistName;
            this.musicFile = musicFile;
            this.albumImg = albumImg;
            this.lyrics = lyrics;
        }
    }

}
