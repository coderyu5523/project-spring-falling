package org.example.projectspringfalling.album;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.enums.FilePathEnum;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.like.LikeRepository;
import org.example.projectspringfalling.song.Song;
import org.example.projectspringfalling.song.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.example.projectspringfalling._core.utils.ArrayUtil.removeDuplicates;
import static org.example.projectspringfalling._core.utils.FileUtil.fileSave;

@RequiredArgsConstructor
@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final LikeRepository likeRepository;

    // 앨범 상세보기
    public AlbumResponse.DetailDTO albumDetail(Integer albumId, Integer userId) {
        Album album = albumRepository.findAlbumAndArtistById(albumId)
                .orElseThrow(() -> new Exception404("존재하지 않는 앨범입니다."));
        List<Song> songList = songRepository.findByAlbumId(albumId);
        String albumGenre = removeDuplicates(albumRepository.findAlbumGenres(albumId));

        boolean isLike = likeRepository.findUserLikedAlbum(userId, albumId).isPresent();

        return new AlbumResponse.DetailDTO(album, songList, albumGenre, isLike);
    }

    public Album getImage(int id) {
        Album album = albumRepository.findById(id).get();
        return album;
    }

    // 앨범 등록(곡 등록 포함)
    @Transactional
    public void addAlbum(AlbumRequest.SaveDTO requestDTO) {
        String albumImg = fileSave(requestDTO.getAlbumImg(), FilePathEnum.IMAGE); // 앨범 이미지
        List<String> songList = new ArrayList<>(); // 노래 데이터베이스 저장용
        List<String> videos = new ArrayList<>(); // 뮤직비디오 데이터베이스 저장용

        List<Song> songs = new ArrayList<>(); // 앨범 인서트용

        // 음악, 비디오 저장 및 데이터베이스 저장용 String 값
        requestDTO.getSongList().forEach(saveDTO -> {
            songList.add(fileSave(saveDTO.getSong(), FilePathEnum.MUSIC));
            videos.add(fileSave(saveDTO.getMusicVideo(), FilePathEnum.VIDEO));
        });

        // DTO 엔티티화 및 songs에 추가
        for (int i = 0; i < requestDTO.getSongList().size(); i++) {
            songs.add(new Song(requestDTO.getSongList().get(i), videos.get(i), songList.get(i)));
        }

        // 앨범 및 노래 인서트
        albumRepository.save(new Album(requestDTO, albumImg, songs));
    }
}
