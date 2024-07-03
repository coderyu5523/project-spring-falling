package org.example.projectspringfalling.album;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.artist.Artist;
import org.example.projectspringfalling.song.Song;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

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

    @Column(columnDefinition = "TEXT") // 255자가 넘어가면 터져서 넣음
    private String intro; // 앨범 소개
    private String nationality; // 국내외
    private String category; // 앨범 유형
    private String albumImg; // 앨범 사진
    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist; // 아티스트

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "song_id")
    private List<Song> song;


    @Builder
    public Album(Integer id, String title, String distributor, String agency, String intro, String nationality, String category, String albumImg, Timestamp createdAt, Artist artist) {
        this.id = id;
        this.title = title;
        this.distributor = distributor;
        this.agency = agency;
        this.intro = intro;
        this.nationality = nationality;
        this.category = category;
        this.albumImg = albumImg;
        this.createdAt = createdAt;
        this.artist = artist;
    }

    // 인서트용 생성자
    // 앨범 이미지는 저장하면서 경로 받아와야 돼서 별도로 받음
    // 노래 리스트는 엔티티화 후에 받아야해서 별도로 받음
    public Album(AlbumRequest.SaveDTO requestDTO, Artist artist, String albumImg, List<Song> song) {
        this.artist = artist;
        this.title = requestDTO.getTitle();
        this.distributor = requestDTO.getDistributor();
        this.agency = requestDTO.getAgency();
        this.intro = requestDTO.getIntro();
        this.nationality = requestDTO.getNationality();
        this.category = requestDTO.getCategory();
        this.albumImg = albumImg;
        this.song = song;
    }
}
