package org.example.projectspringfalling.reply;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "reply_tb")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content; // 내용

    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 회원

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album; // 앨범

    @Builder
    public Reply(Integer id, String content, Timestamp createdAt, User user, Album album) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
        this.album = album;
    }
}
