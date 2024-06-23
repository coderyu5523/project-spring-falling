package org.example.projectspringfalling.album;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.song.Song;
import org.example.projectspringfalling.song.SongResponse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        private List<SongResponse.AlbumListDTO> songList = new ArrayList<>(); // 앨범 수록곡

        public ListDTO(Album album, List<Song> songList) {
            this.albumId = album.getId();
            this.albumImage = album.getAlbumImg();
            this.albumTitle = album.getTitle();
            this.category = album.getCategory();
            this.createdAt = album.getCreatedAt();
            this.albumArtist = album.getArtist().getName();
            this.songList = IntStream.range(0, songList.size())
                    .mapToObj(i -> new SongResponse.AlbumListDTO(songList.get(i), i + 1))
                    .collect(Collectors.toList());
        }
    }


    // 앨범 상세보기 DTO
    @NoArgsConstructor
    @Data
    public static class DetailDTO {
        private Integer albumId; // 앨범 pk
        private String albumImage; // 앨범 이미지
        private String albumTitle; // 앨범 이름
        private String category; // 앨범 유형
        private Timestamp createdAt; // 앨범 발매 날짜
        private String albumArtist; // 앨범 아티스트 이름
        private String distributor; // 유통사
        private String agency; // 기획사
        private String albumIntro; // 앨범 소개글

        public DetailDTO(Album album) {
            this.albumId = album.getId();
            this.albumImage = album.getAlbumImg();
            this.albumTitle = album.getTitle();
            this.category = album.getCategory();
            this.createdAt = album.getCreatedAt();
            this.albumArtist = album.getArtist().getName();
            this.distributor = album.getDistributor();
            this.agency = album.getAgency();
            this.albumIntro = album.getIntro();
        }
    }
}
