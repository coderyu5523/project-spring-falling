package org.example.projectspringfalling.history;

import org.example.projectspringfalling.RestAPI.RestResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, Integer> {

    // 보관함 - 최근 감상
    @Query("SELECT new org.example.projectspringfalling.RestAPI.RestResponse$RecentSongs(s.id, a.id, a.albumImg, s.title, a.title, ar.name) FROM History h JOIN h.song s JOIN s.album a JOIN s.artist ar WHERE h.user.id = :userId")
    List<RestResponse.RecentSongs> findAllRecentSongs(Integer userId);

    @Query("select h from History h join fetch h.song s join fetch h.user u where s.id = :songId and u.id = :userId")
    Optional<History> findBySongIdAndUserId(Integer songId, Integer userId);
}
