package org.example.projectspringfalling.album;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.song.Song;
import org.example.projectspringfalling.song.SongResponse;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class AlbumResponse {
    // 앨범 수록곡 리스트 DTO
    @NoArgsConstructor
    @Data
    public static class ListDTO {
        private Integer albumId; // 앨범 pk
        private String albumImage; // 앨범 이미지
        private String albumTitle; // 앨범 이름
        private String category; // 앨범 유형
        private Timestamp createdAt; // 앨범 발매 날짜
        private String albumArtist; // 앨범 아티스트 이름
        private List<SongResponse.AlbumListDTO> songList; // 앨범 수록곡

        public ListDTO(Album album, List<Song> songList) {
            this.albumId = album.getId();
            this.albumImage = album.getAlbumImg();
            this.albumTitle = album.getTitle();
            this.category = album.getCategory();
            this.createdAt = album.getCreatedAt();
            this.albumArtist = album.getArtist().getName();
            this.songList = songList.stream().map(SongResponse.AlbumListDTO::new).collect(Collectors.toList());
        }
    }
}
