package org.example.projectspringfalling.artist;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.enums.FilePathEnum;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.album.AlbumRepository;
import org.example.projectspringfalling.like.LikeRepository;
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
    private final LikeRepository likeRepository;

    // 가수 상세보기 (앨범)
    public ArtistResponse.ArtistDetailDTO artistDetail(Integer artistId, Integer userId) {
        Artist artist = artistRepository.findArtistAndAlbumByArtistId(artistId)
                .orElseThrow(() -> new Exception404("존재하지 않는 아티스트입니다."));
        List<Album> albumList = albumRepository.findByArtistId(artistId);

        List<ArtistResponse.ArtistDetailDTO.SongListDTO> songListDTO = albumRepository.findAlbumByArtistId(artistId).stream()
                .flatMap(album -> songRepository.findByAlbumId(album.getId()).stream()
                        .map(song -> new ArtistResponse.ArtistDetailDTO.SongListDTO(song, album)))
                .collect(Collectors.toList());

        String artistGenre = removeDuplicates(artistRepository.findArtistGenres(artistId));
        boolean isArtistLike = likeRepository.findUserLikedArtist(userId, artistId).isPresent();
        boolean isAlbumLike = likeRepository.findUserLikedAlbum(userId, artistId).isPresent();
        boolean isLogin = userId != 0; // 로그인 되어있으면 true, 아니면 false

        return new ArtistResponse.ArtistDetailDTO(artist, albumList, songListDTO, artistGenre, isArtistLike, isAlbumLike, isLogin);
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
