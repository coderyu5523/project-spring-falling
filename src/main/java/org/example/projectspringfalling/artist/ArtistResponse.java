package org.example.projectspringfalling.artist;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.song.Song;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ArtistResponse {

    // 가수 상세보기 (앨범)
    @NoArgsConstructor
    @Data
    public static class ArtistDetailDTO {
        private Integer artistId; // 아티스트 pk
        private String artistImage; // 아티스트 이미지
        private String artistName; // 아티스트 이름
        private String artistType; // 그룹솔로 구분
        private String artistGenre; // 장르
        private List<AlbumListDTO> albumList; // 앨범 리스트
        private List<SongListDTO> songList; // 곡 리스트
        private boolean isArtistLike; // 아티스트 좋아요 여부
        private boolean isAlbumLike; // 앨범 좋아요 여부
        private boolean isLogin; // 로그인 여부


        public ArtistDetailDTO(Artist artist, List<Album> albumList, List<SongListDTO> songList, String artistGenre,
                               boolean isArtistLike, boolean isAlbumLike, boolean isLogin) {
            this.artistId = artist.getId();
            this.artistImage = artist.getArtistImg();
            this.artistName = artist.getName();
            this.artistType = artist.getArtistType();
            this.artistGenre = artistGenre;
            this.albumList = albumList.stream().map(AlbumListDTO::new).collect(Collectors.toList());
            this.songList = songList;
            this.isArtistLike = isArtistLike;
            this.isAlbumLike = isAlbumLike;
            this.isLogin = isLogin;
        }

        @NoArgsConstructor
        @Data
        public static class SongListDTO {
            private Integer songId; // 곡 pk
            private String title; // 곡 제목
            private String artistName; // 가수 이름
            private String musicFile; // 음악 파일
            private String lyrics; // 가사
            private Integer albumId; // 앨범 pk
            private String coverImg; // 앨범 이미지
            private String albumTitle; // 앨범 이름


            public SongListDTO(Song song, Album album) {
                this.songId = song.getId();
                this.title = song.getTitle();
                this.artistName = song.getArtist().getName();
                this.musicFile = song.getMusicFile();
                this.lyrics = song.getLyrics();
                this.albumId = album.getId();
                this.coverImg = album.getAlbumImg();
                this.albumTitle = album.getTitle();
            }
        }

        @NoArgsConstructor
        @Data
        public static class AlbumListDTO {
            private Integer albumId; // 앨범 pk
            private String albumImage; // 앨범 이미지
            private String albumTitle; // 앨범 이름
            private String albumCategory; // 앨범 유형
            // TODO: Util써서 Timestamp가 아닌 String으로 받기
            private Timestamp createdAt; // 앨범 발매 날짜

            public AlbumListDTO(Album album) {
                this.albumId = album.getId();
                this.albumImage = album.getAlbumImg();
                this.albumTitle = album.getTitle();
                this.albumCategory = album.getCategory();
                this.createdAt = album.getCreatedAt();
            }
        }
    }
}
