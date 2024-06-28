package org.example.projectspringfalling.like;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.example.projectspringfalling._core.errors.exception.Exception400;
import org.example.projectspringfalling.album.Album;
import org.example.projectspringfalling.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;

    // 좋아요 - 곡
    public List<RestResponse.StorageLikeSongs> getLikedSongs(Integer userId) {
        return likeRepository.findAllLikedSongs(userId);
    }

    // 좋아요 - 앨범
    public List<RestResponse.StorageLikeAlbums> getLikedAlbums(Integer userId) {
        return likeRepository.findAllLikedAlbums(userId);
    }

    // 좋아요 - 아티스트
    public List<RestResponse.StorageLikeArtists> getLikedArtists(Integer userId) {
        return likeRepository.findAllLikedArtists(userId);
    }

    // 앨범 좋아요 하기
    @Transactional
    public void saveLikeAlbum(Integer userId, Integer albumId) {
        likeRepository.findLikeByUserIdAndAlbumId(userId, albumId).ifPresent(like -> {
            throw new Exception400("이미 좋아요한 앨범입니다.");
        });
        Like like = Like.builder()
                .user(User.builder().id(userId).build())
                .album(Album.builder().id(albumId).build())
                .build();
        likeRepository.save(like);
    }

    // 앨범 좋아요 삭제하기
    @Transactional
    public void deleteLikeAlbum(Integer userId, Integer albumId) {
        Like like = likeRepository.findLikeByUserIdAndAlbumId(userId, albumId).orElseThrow(() -> new Exception400("좋아요 되어있지 않은 앨범입니다."));

        likeRepository.delete(like);
    }
}
