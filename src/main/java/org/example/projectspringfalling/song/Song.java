package org.example.projectspringfalling.song;

import jakarta.persistence.*;
import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@NoArgsConstructor
@Table(name = "song_tb")
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title; // 노래 제목
    private String lyrics; // 가사
    private String songWriter; // 작곡가
    private String lyricist; // 작사가
    private String musicVideo; // 뮤직비디오
    private String genre; // 장르
    private Boolean isTitle; // 타이틀 여부
    @CreationTimestamp
    private Timestamp createdAt; // 생성 날짜

    private Integer album_id; // 앨범 아이디
    private Integer artist_id; // 아티스트 아이디
    private Integer playlist_id; // 플레이리스트 아이디;

    @Builder
    public Song(Integer id, String title, String lyrics, String songWriter, String lyricist, String musicVideo, String genre, Boolean isTitle, Timestamp createdAt, Integer album_id, Integer artist_id, Integer playlist_id) {
        this.id = id;
        this.title = title;
        this.lyrics = lyrics;
        this.songWriter = songWriter;
        this.lyricist = lyricist;
        this.musicVideo = musicVideo;
        this.genre = genre;
        this.isTitle = isTitle;
        this.createdAt = createdAt;
        this.album_id = album_id;
        this.artist_id = artist_id;
        this.playlist_id = playlist_id;
    }
}
