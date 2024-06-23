package org.example.projectspringfalling.playlist;

import lombok.Data;

public class PlaylistResponse {

    @Data
    public static class PlaylistDTO {
        private String songTitle;
        private String artistName;
        private String musicFile;
        private String albumImg;

        public PlaylistDTO(String songTitle, String artistName, String musicFile, String albumImg) {
            this.songTitle = songTitle;
            this.artistName = artistName;
            this.musicFile = musicFile;
            this.albumImg = albumImg;
        }
    }

}
