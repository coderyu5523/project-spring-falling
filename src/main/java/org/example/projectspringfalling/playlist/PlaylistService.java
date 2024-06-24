package org.example.projectspringfalling.playlist;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.RestAPI.RestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    // 보관함 플레이리스트 - Rest
    public List<RestResponse.StoragePlaylist> getMyList(Integer userId) {
        return playlistRepository.findAllPlaylistById(userId);
    }
}
