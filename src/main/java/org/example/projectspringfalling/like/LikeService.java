package org.example.projectspringfalling.like;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.springframework.stereotype.Service;

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
}
