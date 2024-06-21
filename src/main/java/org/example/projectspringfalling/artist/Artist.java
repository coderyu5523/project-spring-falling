package org.example.projectspringfalling.artist;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.song.Song;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "artist_tb")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name; // 가수 이름
    private String artistType; // 그룹솔로 구분
    private String artistImg; // 가수 사진
    @CreationTimestamp
    private Timestamp createdAt; // 생성 날짜

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs; // 가수가 가진 노래들


    @Builder
    public Artist(Integer id, String name, String artistType, String artistImg, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.artistType = artistType;
        this.artistImg = artistImg;
        this.createdAt = createdAt;
    }
}
