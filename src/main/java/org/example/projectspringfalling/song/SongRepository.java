package org.example.projectspringfalling.song;

import org.example.projectspringfalling.admin.AdminResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {

    // Song id로 song, album, artist 찾기
    @Query("SELECT s, al, ar FROM Song s JOIN FETCH Album al ON al.id=s.album.id JOIN FETCH Artist ar on ar.id=al.artist.id WHERE al.artist.id=ar.id AND s.id=:id")
    Song findSongAndAlbumAndArtistById(@Param("id") Integer id);


    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$SongListDTO(s.id, a.albumImg, s.title, s.artist, a.title) FROM Song s, Album a WHERE s.album.id = a.id")
    List<AdminResponse.SongListDTO> findSongList();
    
}
