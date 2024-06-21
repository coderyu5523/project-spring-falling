package org.example.projectspringfalling.song;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.artist.Artist;

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

    // 앨범 수록곡 리스트 DTO
    @NoArgsConstructor
    @Data
    public static class AlbumListDTO {
        private Integer songId; // 노래 pk
        private Integer index; // 리스트 index 번호
        private String title; // 노래 제목
        private String musicVideo; // 뮤직비디오
        private Boolean isTitle; // 타이틀 여부
        private String musicFile; // 음악 파일
        private Integer artistId; // 가수
        private String artistName; // 가수 이름

        public AlbumListDTO(Song song, Integer index) {
            this.songId = song.getId();
            this.index = index;
            this.title = song.getTitle();
            this.musicVideo = song.getMusicVideo();
            this.isTitle = song.getIsTitle();
            this.musicFile = song.getMusicFile();
            this.artistId = new ArtistDTO(song.getArtist()).artistId;
            this.artistName = new ArtistDTO(song.getArtist()).artistName;
        }

        public static class ArtistDTO {
            private Integer artistId; // 가수 pk
            private String artistName; // 가수 이름

            public ArtistDTO(Artist artist) {
                this.artistId = artist.getId();
                this.artistName = artist.getName();
            }
        }
    }
}
