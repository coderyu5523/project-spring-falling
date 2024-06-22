package org.example.projectspringfalling.song;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.artist.Artist;

import java.sql.Timestamp;
import java.util.List;

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

    @Data
    public static class SearchDTO {

        private String keyword;
        private ArtistDTO artistDTO;
        private List<SongDTO> songs;
        public SearchDTO(List<Song> songList, String keyword) {
            this.keyword = keyword;
            this.artistDTO = new ArtistDTO(songList.get(songList.size() - 1));
            this.songs = songList.stream().map(song -> new SongDTO(song)).toList();
        }

        @Data
        public class ArtistDTO {
            private Integer songId;
            private Integer artistId;
            private Integer albumId;
            private String albumImg;
            private String artistName;
            private String albumTitle;
            private String songTitle;

            public ArtistDTO(Song song) {
                this.songId = song.getId();
                this.artistId = song.getArtist().getId();
                this.albumId = song.getAlbum().getId();
                this.albumImg = song.getAlbum().getAlbumImg();
                this.artistName = song.getArtist().getName();
                this.albumTitle = song.getAlbum().getTitle();
                this.songTitle = song.getTitle();
            }
        }

        @Data
        public class SongDTO {
            private Integer songId;
            private Integer artistId;
            private Integer albumId;
            private String songTitle;
            private String albumTitle;
            private String artistName;
            private String albumImg;
            private String artistImg;
            private String lyrics;
            private String genre;
            private String category;
            private String artistType;
            private String nationality;
            private Timestamp albumCreatedAt;

            public SongDTO(Song song) {
                this.songId = song.getId();
                this.artistId = song.getArtist().getId();
                this.albumId = song.getAlbum().getId();
                this.songTitle = song.getTitle();
                this.albumTitle = song.getAlbum().getTitle();
                this.artistName = song.getArtist().getName();
                this.albumImg = song.getAlbum().getAlbumImg();
                this.artistImg = song.getArtist().getArtistImg();
                this.lyrics = song.getLyrics();
                this.genre = song.getGenre();
                this.nationality = song.getAlbum().getNationality();
                this.artistType = song.getArtist().getArtistType();
                this.category = song.getAlbum().getCategory();
                this.albumCreatedAt = song.getAlbum().getCreatedAt();
            }
        }


    }
}
