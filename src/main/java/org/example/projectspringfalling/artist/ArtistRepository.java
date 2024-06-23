package org.example.projectspringfalling.artist;

import org.example.projectspringfalling.admin.AdminResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {


    // 관리자 아티스트 목록보기
    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$ArtistListDTO(a.id, a.artistImg, a.name, a.artistType) FROM Artist a")
    List<AdminResponse.ArtistListDTO> findAllArtist();

    // 관리자 아티스트 상세보기
    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$ArtistDetailDTO(a.id, a.name,a.artistImg, a.artistType) FROM Artist a WHERE a.id = :artistId")
    AdminResponse.ArtistDetailDTO findOneArtist(Integer artistId);

    // 관리자 아티스트 앨범 목록보기
    @Query("SELECT new org.example.projectspringfalling.admin.AdminResponse$ArtistDetailDTO$ArtistAlbumsDTO(al.id, al.albumImg, al.title) FROM Album al WHERE al.artist.id = :artistId")
    List<AdminResponse.ArtistDetailDTO.ArtistAlbumsDTO> findAllArtistAlbum(Integer artistId);

    // 관리자 아티스트 장르
    @Query("SELECT DISTINCT s.genre FROM Album a, Song s WHERE a.artist.id = :artistId AND a.id = s.album.id")
    List<String> findArtistGenres(Integer artistId);
}
