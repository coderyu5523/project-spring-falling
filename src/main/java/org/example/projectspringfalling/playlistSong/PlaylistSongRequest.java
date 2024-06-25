package org.example.projectspringfalling.playlistSong;

import lombok.Data;

public class PlaylistSongRequest {

    @Data
    public static class AddSongToPlaylist {
        private Integer songId;
        private Integer playlistId;
    }
}
