package org.example.projectspringfalling.album;

import org.example.projectspringfalling.admin.AdminResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    // 최신 앨범 찾기
    @Query("SELECT a, ar FROM Album a JOIN FETCH Artist ar ON ar.id=a.artist.id ORDER BY a.createdAt DESC")
    List<Album> findLatestAlbums(Pageable pageable);

    // 앨범 상세보기
    @Query("SELECT DISTINCT s.genre FROM Album a, Song s WHERE s.album.id = :albumId")
    List<String> findAlbumGenres(@Param("albumId") Integer albumId);

    // 가수 상세보기 (곡)
    @Query("SELECT al FROM Album al WHERE al.artist.id=:artistId")
    List<Album> findAlbumByArtistId(@Param("artistId") Integer artistId);

    // 가수 상세보기 (앨범)
    @Query("SELECT al FROM Album al WHERE al.artist.id=:artistId")
    List<Album> findByArtistId(@Param("artistId") Integer artistId);

    // 앨범 곡 목록보기
    @Query("SELECT al, ar FROM Album al JOIN FETCH Artist ar ON ar.id=al.artist.id WHERE al.id=:albumId")
    Optional<Album> findAlbumAndArtistById(@Param("albumId") Integer albumId);

    // 관리자 앨범 목록보기
    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$AlbumListDTO(a.id, a.albumImg, a.title, a.artist) FROM Album a")
    List<AdminResponse.AlbumListDTO> findAlbumList();

    // 관리자 앨범 상세보기
    @Query("SELECT DISTINCT new org.example.projectspringfalling.admin.AdminResponse$AlbumDetailDTO(a.id, a.title,a.albumImg,a.artist,a.category,a.intro,a.createdAt,a.distributor,a.agency) FROM Album a, Song s where s.album.id = a.id AND a.id = :albumId")
    AdminResponse.AlbumDetailDTO findOneAlbum(Integer albumId);


}
