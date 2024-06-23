package org.example.projectspringfalling.artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    // 가수 상세보기 (앨범)
    @Query("SELECT ar, al FROM Artist ar JOIN FETCH Album al ON al.artist.id=ar.id WHERE ar.id=:artistId")
    Optional<Artist> findArtistAndAlbumByArtistId(@Param("artistId") Integer artistId);
}
