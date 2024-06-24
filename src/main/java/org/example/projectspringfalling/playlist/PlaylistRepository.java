package org.example.projectspringfalling.playlist;

import org.example.projectspringfalling.RestAPI.RestResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

    // 보관함 플레이리스트
    @Query("SELECT new org.example.projectspringfalling.RestAPI.RestResponse$StoragePlaylist(p.id, p.name, COUNT(s), p.createdAt) FROM Playlist p, PlaylistSong s WHERE p.user.id = :userId AND p.id = s.playlist.id GROUP BY p.id")
    List<RestResponse.StoragePlaylist> findAllPlaylistById(Integer userId);
}
