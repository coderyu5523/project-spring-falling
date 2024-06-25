package org.example.projectspringfalling.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

public class UserResponse {
    // 회원가입 DTO
    @Data
    public static class JoinDTO {
        private Integer id; // 유저 번호
        private String email; // 이메일 (로그인 할 때 아이디로 사용)
        private String phone; // 전화번호
        private String provider; // 가입 경로
        private String birth; // 생년월일
        private Timestamp createdAt; // 회원가입 일자

        public JoinDTO(User user) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.phone = user.getPhone();
            this.provider = user.getProvider();
            this.birth = user.getBirth();
            this.createdAt = user.getCreatedAt();
        }
    }

    // 로그인 DTO
    @NoArgsConstructor
    @Data
    public static class LoginDTO {
        private Integer id; // 유저 번호
        private String email; // 이메일 (로그인 할 때 아이디로 사용)
        private String phone; // 전화번호
        private String provider; // 가입 경로
        private String birth; // 생년월일
        private Timestamp createdAt; // 회원가입 일자

        public LoginDTO(User user) {
            this.id = user.getId();
            this.email = user.getEmail();
            this.phone = user.getPhone();
            this.provider = user.getProvider();
            this.birth = user.getBirth();
            this.createdAt = user.getCreatedAt();
        }
    }

    // 카카오 토큰 DTO
    @Data // getter, setter
    public static class KakaoTokenDTO {
        @JsonProperty("access_token") // 이렇게 해주면 access_token으로 파싱된 값이 accessToken에 들어간다.(jackson 라이브러리)
        private String accessToken;

        @JsonProperty("token_type")
        private String tokenType;

        @JsonProperty("refresh_token")
        private String refreshToken;

        @JsonProperty("expires_in")
        private Integer expiresIn;

        private String scope;

        @JsonProperty("refresh_token_expires_in")
        private Integer refreshTokenExpiresIn;
    }

    // 카카오 회원정보 DTO
    @Data
    public static class KakaoUserDTO {
        private Long id; // 값이 커서 Long으로 받아야 한다.

        @JsonProperty("connected_at")
        private Timestamp connectedAt;

        private Properties properties;

        @Data
        class Properties {
            private String nickname;
        }
    }

    // 네이버 토큰 DTO
    @Data // getter, setter
    public static class NaverTokenDTO {
        @JsonProperty("access_token") // 이렇게 해주면 access_token으로 파싱된 값이 accessToken에 들어간다.(jackson 라이브러리)
        private String accessToken;

        @JsonProperty("refresh_token")
        private String refreshToken;

        @JsonProperty("token_type")
        private String tokenType;

        @JsonProperty("expires_in")
        private Integer expiresIn;
    }

    // 네이버 회원정보 DTO
    @Data
    public static class NaverUserDTO {
        private String message;
        private Response response;

        @Data
        static class Response {
            private String id;
            private String email; // 이메일 주소
            private String birthday; // 생일
            private String birthyear; // 출생년도
            private String mobile; // 전화번호
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer id;
        private String phone;

        public UpdateDTO(User user) {
            this.id = user.getId();
            this.phone = user.getPhone();
        }
    }

}
