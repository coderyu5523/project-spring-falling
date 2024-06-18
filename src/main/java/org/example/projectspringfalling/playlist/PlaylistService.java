package org.example.projectspringfalling.playlist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
}
