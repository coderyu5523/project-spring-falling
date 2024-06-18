package org.example.projectspringfalling.playlist;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "playlist_tb")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name; // 플레이리스트 이름
    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 회원

    private Integer song_id; // 노래 아이디

    @Builder
    public Playlist(Integer id, String name, Timestamp createdAt, User user, Integer song_id) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.user = user;
        this.song_id = song_id;
    }
}
