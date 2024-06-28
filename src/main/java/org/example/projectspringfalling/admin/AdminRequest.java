package org.example.projectspringfalling.admin;

import lombok.Data;

public class AdminRequest {

    @Data
    public static class LoginDTO {
        private String email;
        private String password;
    }
}
