package org.example.projectspringfalling.like;

import org.example.projectspringfalling.RestAPI.RestResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    // 아티스트 상세보기 - 좋아요
    @Query("SELECT l FROM Like l WHERE l.user.id = :userId AND l.album.id = :albumId")
    Optional<Like> findUserLikedArtist(Integer userId, Integer albumId);

    // 앨범 상세보기 - 좋아요
    @Query("SELECT l FROM Like l WHERE l.user.id = :userId AND l.album.id = :albumId")
    Optional<Like> findUserLikedAlbum(Integer userId, Integer albumId);

    // 보관함 - 좋아요(곡)
    @Query("SELECT new org.example.projectspringfalling.RestAPI.RestResponse$StorageLikeSongs(s.id, a.id, a.albumImg, s.title, a.title, ar.name) FROM Like l JOIN l.song s JOIN s.album a JOIN s.artist ar WHERE l.user.id = :userId")
    List<RestResponse.StorageLikeSongs> findAllLikedSongs(Integer userId);

    // 보관함 - 좋아요(앨범)
    @Query("SELECT new org.example.projectspringfalling.RestAPI.RestResponse$StorageLikeAlbums(a.id, a.albumImg, a.title, ar.name, a.createdAt, a.category) FROM Like l JOIN l.album a JOIN a.artist ar WHERE l.user.id = :userId")
    List<RestResponse.StorageLikeAlbums> findAllLikedAlbums(Integer userId);

    @Query("SELECT new org.example.projectspringfalling.RestAPI.RestResponse$StorageLikeArtists(a.id, a.artistImg, a.name, a.artistType) FROM Like l JOIN l.artist a WHERE l.user.id = :userId")
    List<RestResponse.StorageLikeArtists> findAllLikedArtists(Integer userId);

    // 앨범 좋아요
    Optional<Like> findLikeByUserIdAndAlbumId(Integer userId, Integer albumId);

    // 곡 좋아요
    Optional<Like> findLikeByUserIdAndSongId(Integer userId, Integer songId);

    // 아티스트 좋아요
    Optional<Like> findLikeByUserIdAndArtistId(Integer userId, Integer artistId);

}
