package org.example.projectspringfalling.user;

import lombok.Data;

import java.sql.Timestamp;

public class UserRequest {

    // 회원가입 DTO
    @Data
    public static class JoinDTO {
        private Integer id;
        private String email; // 이메일
        private String password; // 비밀번호
        private String phone; // 전화번호
        private String birth; // 생년월일
        private String provider;  // oauth 수단
        private Timestamp createdAt; // 생성날짜

        public User toEntity() {
            return User.builder()
                    .id(id)
                    .email(email)
                    .password(password)
                    .phone(phone)
                    .birth(birth)
                    .provider("Email") // 일반 회원가입을 한 회원은 "Email"로 값 지정
                    .createdAt(createdAt)
                    .build();
        }
    }

    // 로그인 DTO
    @Data
    public static class LoginDTO {
        private String email; // 이메일
        private String password; // 비밀번호
    }
}
