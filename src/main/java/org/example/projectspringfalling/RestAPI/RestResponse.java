package org.example.projectspringfalling.RestAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.projectspringfalling.song.Song;

import java.sql.Timestamp;

import static org.example.projectspringfalling._core.utils.DateUtil.timestampToString;

public class RestResponse {

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
}
