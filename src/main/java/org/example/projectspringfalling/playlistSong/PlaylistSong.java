package org.example.projectspringfalling.playlistSong;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.playlist.Playlist;
import org.example.projectspringfalling.song.Song;

@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "playlist_song_tb")
public class PlaylistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Playlist playlist;

    @ManyToOne(fetch = FetchType.LAZY)
    private Song song;

    @Builder
    public PlaylistSong(Integer id, Playlist playlist, Song song) {
        this.id = id;
        this.playlist = playlist;
        this.song = song;
    }
}
