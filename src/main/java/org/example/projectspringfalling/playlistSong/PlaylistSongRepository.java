package org.example.projectspringfalling.playlistSong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlaylistSongRepository extends JpaRepository<PlaylistSong, Integer> {
    @Query("SELECT p, s, a, ar FROM PlaylistSong p JOIN FETCH Song s ON p.song.id=s.id " +
            "JOIN FETCH Album a ON s.album.id=a.id JOIN FETCH Artist ar ON ar.id=s.artist.id WHERE p.playlist.id=:playlistId")
    List<PlaylistSong> findByPlaylistId(@Param("playlistId") Integer playlistId);

    @Query("SELECT p FROM PlaylistSong p WHERE p.playlist.id = :playlistId AND p.song.id = :songId ")
    Optional<PlaylistSong> findByPlaylistIdAndUserId(Integer playlistId, Integer songId);
}
