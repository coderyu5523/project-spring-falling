package org.example.projectspringfalling.playlist;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.artist.Artist;
import org.example.projectspringfalling.song.Song;

import java.sql.Timestamp;
import java.util.List;

public class PlaylistResponse {

    @NoArgsConstructor
    @Data
    public static class PlaylistDetailDTO {
        private Integer playlistId; // 플레이리스트 pk
        private String playListTitle; // 플레이리스트 타이틀
        private Integer playListSongCount; // 플레이리스트의 곡 수
        // TODO: Util써서 Timestamp가 아닌 String으로 받기
        private Timestamp playListCreatedAt; // 플레이리스트 생성 날짜
        private String playlistCover; // 플레이리스트 커버 이미지
        private List<SongListDTO> songList; // 플레이리스트의 곡 리스트

        public PlaylistDetailDTO(Playlist playlist, List<SongListDTO> songList) {
            this.playlistId = playlist.getId();
            this.playListTitle = playlist.getName();
            this.playListSongCount = songList.size();
            this.playListCreatedAt = playlist.getCreatedAt();
            this.playlistCover = songList.getFirst().getAlbumImg();
            this.songList = songList;
        }

        @NoArgsConstructor
        @Data
        public static class SongListDTO {
            private Integer songId; // 노래 pk
            private String albumImg; // 앨범 이미지
            private String songTitle; // 곡 제목
            private Integer albumId; // 앨범 pk
            private String albumTitle; // 앨범 제목
            private Integer artistId; // 아티스트 pk
            private String artistName; // 아티스트 이름

            public SongListDTO(Song song, Album album, Artist artist) {
                this.songId = song.getId();
                this.albumImg = album.getAlbumImg();
                this.songTitle = song.getTitle();
                this.albumId = album.getId();
                this.albumTitle = album.getTitle();
                this.artistId = artist.getId();
                this.artistName = artist.getName();
            }
        }
    }

    @Data
    public static class PlaylistDTO {
        private String songTitle;
        private String artistName;
        private String musicFile;
        private String albumImg;

        public PlaylistDTO(String songTitle, String artistName, String musicFile, String albumImg) {
            this.songTitle = songTitle;
            this.artistName = artistName;
            this.musicFile = musicFile;
            this.albumImg = albumImg;
        }
    }

}
