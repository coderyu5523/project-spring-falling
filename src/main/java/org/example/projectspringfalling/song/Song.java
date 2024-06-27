package org.example.projectspringfalling.song;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.artist.Artist;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "song_tb")
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title; // 노래 제목

    @Column(columnDefinition = "TEXT") // 255자가 넘어가면 터져서 넣음
    private String lyrics; // 가사
    private String songWriter; // 작곡가
    private String lyricist; // 작사가
    private String musicVideo; // 뮤직비디오
    private String genre; // 장르
    private Boolean isTitle; // 타이틀 여부
    private String musicFile; // 음악 파일
    private Long listenCount;

    @CreationTimestamp
    private Timestamp createdAt; // 생성 날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album; // 앨범 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist; // 아티스트

    @Builder
    public Song(Integer id, String title, String lyrics, String songWriter, String lyricist, String musicVideo, String genre, Boolean isTitle, Timestamp createdAt, Album album, String musicFile,Artist artist,Long listenCount) {
        this.id = id;
        this.title = title;
        this.lyrics = lyrics;
        this.songWriter = songWriter;
        this.lyricist = lyricist;
        this.musicVideo = musicVideo;
        this.genre = genre;
        this.isTitle = isTitle;
        this.createdAt = createdAt;
        this.album = album;
        this.musicFile = musicFile;
        this.artist = artist;
        this.listenCount = listenCount;
    }

    // 인서트용 생성자
    // 뮤직비디오 및 노래는 저장하면서 경로 받아와야 돼서 별도로 받음
    public Song(SongRequest.SaveDTO requestDTO, String musicVideo, String musicFile) {
        this.title = requestDTO.getTitle();
        this.lyrics = requestDTO.getLyrics();
        this.songWriter = requestDTO.getSongWriter();
        this.lyricist = requestDTO.getLyricist();
        this.musicVideo = musicVideo;
        this.genre = requestDTO.getGenre();
        this.isTitle = requestDTO.getIsTitle();
        this.musicFile = musicFile;

    }
    public void updateCount(long newListenCount){
        this.listenCount = newListenCount;
    }
}
