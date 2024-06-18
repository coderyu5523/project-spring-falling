package org.example.projectspringfalling.user;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class SessionUser {
    private Integer id;
    private String email;
    private String phone;
    private String provider;
    private Timestamp createdAt;

    @Builder
    public SessionUser(Integer id, String username, String email, String phone, String provider, Timestamp createdAt) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.provider = provider;
        this.createdAt = createdAt;
    }

    public SessionUser(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.provider = user.getProvider();
        this.createdAt = user.getCreatedAt();
    }
}