package org.example.projectspringfalling.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {

    // Song id로 song, album, artist 찾기
    @Query("SELECT s, al, ar FROM Song s JOIN FETCH Album al ON al.id=s.album.id JOIN FETCH Artist ar on ar.id=al.artist.id WHERE al.artist.id=ar.id AND s.id=:id")
    Song findSongAndAlbumAndArtistById(@Param("id") Integer songId);

    // Album id로 song 찾기
    @Query("SELECT s, ar FROM Song s JOIN FETCH Artist ar ON ar.id=s.artist.id WHERE s.album.id=:AlbumId")
    List<Song> findByAlbumId(@Param("AlbumId") Integer AlbumId);
}
