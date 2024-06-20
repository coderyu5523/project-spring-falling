package org.example.projectspringfalling.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email; // 이메일, 유저네임 대용
    private String password; // 비밀번호
    private String phone; // 전화번호
    private String birth; // 생년월일
    private String provider; // oauth 수단
    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @Builder
    public User(Integer id, String email, String password, String phone, String birth, String provider, Timestamp createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.provider = provider;
        this.createdAt = createdAt;
    }
}
