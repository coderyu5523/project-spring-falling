package org.example.projectspringfalling.RestAPI;

import lombok.Data;
import org.example.projectspringfalling.song.Song;

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
}
