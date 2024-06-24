package org.example.projectspringfalling.artist;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.enums.FilePathEnum;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.album.AlbumRepository;
import org.example.projectspringfalling.song.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.projectspringfalling._core.utils.ArrayUtil.removeDuplicates;
import static org.example.projectspringfalling._core.utils.FileUtil.fileSave;

@RequiredArgsConstructor
@Service
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    // 가수 상세보기 (앨범)
    public ArtistResponse.AlbumListDTO artistDetailAlbumList(Integer artistId) {
        Artist artist = artistRepository.findArtistAndAlbumByArtistId(artistId)
                .orElseThrow(() -> new Exception404("존재하지 않는 아티스트입니다."));
        List<Album> albumList = albumRepository.findByArtistId(artistId);
        String artistGenre = removeDuplicates(artistRepository.findArtistGenres(artistId));
        return new ArtistResponse.AlbumListDTO(artist, albumList, artistGenre);
    }

    // 가수 상세보기 (곡)
    public ArtistResponse.ArtistSongListDTO artistDetailSongList(Integer artistId) {
        Artist artist = artistRepository.findArtistAndAlbumByArtistId(artistId)
                .orElseThrow(() -> new Exception404("존재하지 않는 아티스트입니다."));
        String artistGenre = removeDuplicates(artistRepository.findArtistGenres(artistId));
        List<ArtistResponse.ArtistSongListDTO.SongListDTO> songListDTO = albumRepository.findAlbumByArtistId(artistId).stream()
                .flatMap(album -> songRepository.findByAlbumId(album.getId()).stream()
                        .map(song -> new ArtistResponse.ArtistSongListDTO.SongListDTO(song, album)))
                .collect(Collectors.toList());
        return new ArtistResponse.ArtistSongListDTO(artist, songListDTO, artistGenre);
    }

    @Transactional
    public void addArtist(ArtistRequest.AddArtistDTO requestDTO) {
        MultipartFile artistImg = requestDTO.getArtistImg();

        String imgName = fileSave(artistImg, FilePathEnum.IMAGE);

        artistRepository.save(
                Artist.builder()
                        .name(requestDTO.getName())
                        .artistType(requestDTO.getArtistType())
                        .artistImg(imgName)
                        .build());
    }

    public Artist getImage(int id) {
        Artist artist = artistRepository.findById(id).get();
        return artist;

    }
}
