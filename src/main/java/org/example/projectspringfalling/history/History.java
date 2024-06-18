package org.example.projectspringfalling.history;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.song.Song;
import org.example.projectspringfalling.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "history_tb")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;  // 회원

    @ManyToOne(fetch = FetchType.LAZY)
    private Song song; // 노래

    @Builder
    public History(Integer id, Timestamp createdAt, User user, Song song) {
        this.id = id;
        this.createdAt = createdAt;
        this.user = user;
        this.song = song;
    }
}
