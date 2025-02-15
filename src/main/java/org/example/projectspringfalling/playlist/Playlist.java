package org.example.projectspringfalling.playlist;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.admin.Admin;
import org.example.projectspringfalling.playlistSong.PlaylistSong;
import org.example.projectspringfalling.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "playlist_id")
    private List<PlaylistSong> playlistSong;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 회원

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;


    @Builder
    public Playlist(Integer id, String name, Timestamp createdAt, List<PlaylistSong> playlistSong, User user, Admin admin) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.playlistSong = playlistSong;
        this.user = user;
        this.admin = admin;
    }
}
