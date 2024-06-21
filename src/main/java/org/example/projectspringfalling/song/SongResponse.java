package org.example.projectspringfalling.song;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;

public class SongResponse {
    // 노래 상세보기 DTO
    @NoArgsConstructor
    @Data
    public static class DetailDTO {
        private Integer songId; // 노래 pk
        private String title; // 노래 제목
        private Integer albumId; // 앨범 pk
        private String albumImage; // 앨범 커버 이미지
        private String artist; // 가수 이름
        private String albumTitle; // 앨범 제목
        private String songWriter; // 작곡가
        private String lyricist; // 작사가
        private String lyrics; // 가사
        private String musicFile; // 음악 파일


        public DetailDTO(Song song, Album album) {
            this.songId = song.getId();
            this.title = song.getTitle();
            this.albumId = album.getId();
            this.albumImage = album.getAlbumImg();
            this.artist = album.getArtist().getName();
            this.albumTitle = album.getTitle();
            this.songWriter = song.getSongWriter();
            this.lyricist = song.getLyricist();
            this.lyrics = song.getLyrics();
        }
    }
}
