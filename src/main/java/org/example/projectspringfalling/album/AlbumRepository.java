package org.example.projectspringfalling.album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query("SELECT al, ar FROM Album al JOIN FETCH Artist ar ON ar.id=al.artist.id WHERE al.id=:albumId")
    Optional<Album> findAlbumAndArtistById(@Param("albumId") Integer albumId);
}
