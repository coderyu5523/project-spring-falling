package org.example.projectspringfalling.like;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.artist.Artist;
import org.example.projectspringfalling.song.Song;
import org.example.projectspringfalling.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "like_tb")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 회원

    @ManyToOne(fetch = FetchType.LAZY)
    private Song song; // 노래

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album; // 앨범

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist; // 아티스트

    @Builder
    public Like(Integer id, Timestamp createdAt, User user, Song song, Album album, Artist artist) {
        this.id = id;
        this.createdAt = createdAt;
        this.user = user;
        this.song = song;
        this.album = album;
        this.artist = artist;
    }
}
