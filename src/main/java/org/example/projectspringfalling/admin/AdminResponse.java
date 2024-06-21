package org.example.projectspringfalling.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class AdminResponse {

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
}
