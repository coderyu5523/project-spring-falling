package org.example.projectspringfalling.artist;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ArtistResponse {

    // 가수 상세보기 (앨범)
    @NoArgsConstructor
    @Data
    public static class AlbumListDTO {
        private Integer artistId; // 아티스트 pk
        private String artistImage; // 아티스트 이미지
        private String artistName; // 아티스트 이름
        private String artistType; // 그룹솔로 구분
        // 장르
        private List<AlbumDTO> albumList; // 앨범 리스트


        public AlbumListDTO(Artist artist, List<Album> albumList) {
            this.artistId = artist.getId();
            this.artistImage = artist.getArtistImg();
            this.artistName = artist.getName();
            this.artistType = artist.getArtistType();
            this.albumList = albumList.stream().map(AlbumDTO::new).collect(Collectors.toList());
        }

        @NoArgsConstructor
        @Data
        public static class AlbumDTO {
            private Integer albumId; // 앨범 pk
            private String albumImage; // 앨범 이미지
            private String albumTitle; // 앨범 이름
            private String albumCategory; // 앨범 유형
            private Timestamp createdAt; // 앨범 발매 날짜

            public AlbumDTO(Album album) {
                this.albumId = album.getId();
                this.albumImage = album.getAlbumImg();
                this.albumTitle = album.getTitle();
                this.albumCategory = album.getCategory();
                this.createdAt = album.getCreatedAt();
            }
        }
    }
}
