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
        private String songImg;
        private String title;
        private Artist artist;
        private String albumTitle;
    }
}
