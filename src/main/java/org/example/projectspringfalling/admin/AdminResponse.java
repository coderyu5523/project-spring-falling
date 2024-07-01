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
        private Integer albumId;
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

    // 아티스트 목록보기
    @AllArgsConstructor
    @Data
    public static class ArtistListDTO {
        private Integer artistId;
        private String artistImg;
        private String artistName;
        private String artistType;
    }

    // 아티스트 상세보기
    @AllArgsConstructor
    @Data
    public static class ArtistDetailDTO {
        private Integer artistId;
        private String artistName;
        private String artistImg;
        private String artistType;
        private String artistGenre;
        private List<ArtistAlbumsDTO> artistAlbums;

        public ArtistDetailDTO(Integer artistId, String artistName, String artistImg, String artistType) {
            this.artistId = artistId;
            this.artistName = artistName;
            this.artistImg = artistImg;
            this.artistType = artistType;
        }

        @AllArgsConstructor
        @Data
        public static class ArtistAlbumsDTO {
            private Integer albumId;
            private String albumImg;
            private String albumTitle;
        }
    }

    // 신고 리스트
    @AllArgsConstructor
    @Data
    public static class ReportedList {
        private Integer reportId;
        private String replyContent;
        private String reportContent;
        private Timestamp createdAt;
        private Boolean status;

        public String getCreatedAt() {
            return timestampToString(this.createdAt);
        }

        public String getStatus() {
            return this.status ? "처리완료" : "처리중";
        }
    }

    // 신고 상세보기
    @AllArgsConstructor
    @Data
    public static class ReportedDetailDTO {
        private Integer reportId;
        private String replyAuthor;
        private String replyContent;
        private String reportContent;
        private String reportUsername;
        private Timestamp replyCreatedAt;
        private Timestamp reportCreatedAt;

        public String getReplyCreatedAt() {
            return timestampToString(this.replyCreatedAt);
        }

        public String getReportCreatedAt() {
            return timestampToString(this.reportCreatedAt);
        }
    }
}
