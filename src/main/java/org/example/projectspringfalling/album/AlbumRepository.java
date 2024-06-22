package org.example.projectspringfalling.album;

import org.example.projectspringfalling.admin.AdminResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    // 관리자 앨범 목록보기
    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$AlbumListDTO(a.id, a.albumImg, a.title, a.artist) FROM Album a")
    List<AdminResponse.AlbumListDTO> findAlbumList();

}
