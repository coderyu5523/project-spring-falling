package org.example.projectspringfalling.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Integer> {

    // Song id로 song, album, artist 찾기
    @Query("SELECT s, al, ar FROM Song s JOIN FETCH Album al ON al.id=s.album.id JOIN FETCH Artist ar on ar.id=al.artist.id WHERE al.artist.id=ar.id AND s.id=:id")
    Song findSongAndAlbumAndArtistById(@Param("id") Integer id);

    @Query("select s,ar,al from Song s join fetch s.album al join fetch s.artist ar where s.title like %:keyword% or s.lyrics like %:keyword% or " +
            "s.songWriter like %:keyword% or s.lyricist like %:keyword% or s.genre  like %:keyword% or " +
            "al.title like %:keyword% or al.distributor like %:keyword% or al.agency like %:keyword% or al.intro like %:keyword% or al.category  like %:keyword% or " +
            "ar.name like %:keyword% or  ar.artistType like %:keyword%")
    Optional<List<Song>> findByKeyword(@Param("keyword") String keyword);
}
