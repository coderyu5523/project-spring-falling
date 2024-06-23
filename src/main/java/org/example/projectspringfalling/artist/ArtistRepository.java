package org.example.projectspringfalling.artist;

import org.example.projectspringfalling.admin.AdminResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {


    // 관리자 아티스트 목록보기
    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$ArtistListDTO(a.id, a.artistImg, a.name, a.artistType) FROM Artist a")
    List<AdminResponse.ArtistListDTO> findAllArtist();
}
