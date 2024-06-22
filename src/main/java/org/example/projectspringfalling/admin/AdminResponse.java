package org.example.projectspringfalling.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.projectspringfalling.artist.Artist;

import java.sql.Timestamp;
import java.util.List;

import static org.example.projectspringfalling._core.utils.DateUtil.timestampToString;

public class AdminResponse {

    // 유저 목록
    @AllArgsConstructor
    @Data
    public static class UserListDTO {
        private List<UserDTO> users;
        private Integer userCount;

        public UserListDTO(List<UserDTO> users) {
            this.users = users;
            this.userCount = users.size();
        }

        @AllArgsConstructor
        @Data
        public static class UserDTO {
            private Integer userId;
            private String email;
            private String provider;
            private String status;
        }
    }

    // 유저 상세보기
    @AllArgsConstructor
    @Data
    public static class UserDetailDTO {
        private Integer userId;
        private String email;
        private String phone;
        private String birth;
        private String provider;
        private Timestamp createdAt;
        private String status;

        public String getCreatedAt() {
            return timestampToString(this.createdAt);
        }
    }

    // 곡 리스트
    @AllArgsConstructor
    @Data
    public static class SongListDTO {
        private Integer songId;
        private String albumImg;
        private String songTitle;
        private Artist artist;
        private String albumTitle;
    }

    // 곡 상세보기
    @AllArgsConstructor
    @Data
    public static class SongDetailDTO {
        private Integer songId;
        private String albumImg;
        private String songTitle;
        private Artist artist;
        private String albumTitle;
        private String songWriter;
        private String lyricist;
        private String lyrics;
    }

    // 앨범 목록보기
    @AllArgsConstructor
    @Data
    public static class AlbumListDTO {
        private Integer albumId;
        private String albumImg;
        private String albumTitle;
        private Artist artist;
    }

    // 앨범 상세보기
    @AllArgsConstructor
    @Data
    public static class AlbumDetailDTO {
        private Integer albumId;
        private String albumTitle;
        private String albumImg;
        private Artist artist;
        private String category;
        private String genres;
        private String intro;
        private Timestamp createdAt;
        private String distributor;
        private String agency;

        public String getCreatedAt() {
            return timestampToString(this.createdAt);
        }

        public AlbumDetailDTO(Integer albumId, String albumTitle, String albumImg, Artist artist, String category, String intro, Timestamp createdAt, String distributor, String agency) {
            this.albumId = albumId;
            this.albumTitle = albumTitle;
            this.albumImg = albumImg;
            this.artist = artist;
            this.category = category;
            this.intro = intro;
            this.createdAt = createdAt;
            this.distributor = distributor;
            this.agency = agency;
        }
    }
}
