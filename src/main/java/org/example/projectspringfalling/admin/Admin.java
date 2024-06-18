package org.example.projectspringfalling.admin;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "admin_tb")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email; // 아이디 대용
    private String password; // 비밀번호
    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @Builder
    public Admin(Integer id, String email, String password, Timestamp createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }
}
