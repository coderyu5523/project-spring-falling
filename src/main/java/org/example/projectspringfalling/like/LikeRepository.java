package org.example.projectspringfalling.like;

import org.example.projectspringfalling.RestAPI.RestResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    // 보관함 - 좋아요(곡)
    @Query("SELECT new org.example.projectspringfalling.RestAPI.RestResponse$StorageLikeSong(s.id, a.id, a.albumImg, s.title, a.title, ar.name) FROM Like l JOIN l.song s JOIN s.album a JOIN s.artist ar WHERE l.user.id = :userId")
    List<RestResponse.StorageLikeSong> findAllLikedSongs(Integer userId);

}
