package org.example.projectspringfalling.album;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.song.Song;
import org.example.projectspringfalling.song.SongResponse;

import java.sql.Timestamp;
import java.util.List;

public class AlbumResponse {
    // 앨범 수록곡 리스트 DTO
    @NoArgsConstructor
    @Data
    public static class ListDTO {
        private Integer albumId; // 앨범 pk
        private String albumImage; // 앨범 이미지
        private String albumTitle; // 앨범 이름
        private String artistId; // 가수 pk
        private String artist; // 가수 이름
        private String category; // 앨범 유형
        private Timestamp createdAt; // 앨범 발매 날짜
        private List<SongResponse.AlbumListDTO> songList; // 앨범 수록곡

        public ListDTO(Song song, Album album) {
            this.albumId = album.getId();
            this.albumImage = album.getAlbumImg();
            this.albumTitle = album.getTitle();
            this.artistId = album.getArtist().getId();
            this.artist = album.getArtist().getName();
            this.

        }
    }
}
