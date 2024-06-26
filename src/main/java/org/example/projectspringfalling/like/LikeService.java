package org.example.projectspringfalling.like;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;

    public List<RestResponse.StorageLikeSong> getLikedSongs(Integer userId) {
        return likeRepository.findAllLikedSongs(userId);
    }
}
