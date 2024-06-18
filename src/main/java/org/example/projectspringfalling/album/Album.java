package org.example.projectspringfalling.album;

import java.sql.Timestamp;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.song.Song;
import org.hibernate.annotations.CreationTimestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "album_tb")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title; // 앨범 제목
    private String distributor; // 유통사
    private String agency; // 기획사
    private String intro; // 앨범 소개
    private String nationality; // 국내외
    private String category; // 앨범 유형
    private String albumImg; // 앨범 사진
    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private Song song; // 노래

    private Integer artist_id; // 가수 아이디

    @Builder
    public Album(Integer id, String title, String distributor, String agency, String intro, String nationality, String category, String albumImg, Timestamp createdAt, Song song, Integer artist_id) {
        this.id = id;
        this.title = title;
        this.distributor = distributor;
        this.agency = agency;
        this.intro = intro;
        this.nationality = nationality;
        this.category = category;
        this.albumImg = albumImg;
        this.createdAt = createdAt;
        this.song = song;
        this.artist_id = artist_id;
    }
}
