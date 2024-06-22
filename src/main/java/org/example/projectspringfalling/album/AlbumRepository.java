package org.example.projectspringfalling.album;

import org.example.projectspringfalling.admin.AdminResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    // 관리자 앨범 목록보기
    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$AlbumListDTO(a.id, a.albumImg, a.title, a.artist) FROM Album a")
    List<AdminResponse.AlbumListDTO> findAlbumList();

    // 관리자 앨범 상세보기
    @Query("SELECT DISTINCT new org.example.projectspringfalling.admin.AdminResponse$AlbumDetailDTO(a.id, a.title,a.albumImg,a.artist,a.category,a.intro,a.createdAt,a.distributor,a.agency) FROM Album a, Song s where s.album.id = a.id AND a.id = :albumId")
    AdminResponse.AlbumDetailDTO findOneAlbum(Integer albumId);
}
