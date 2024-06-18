package org.example.projectspringfalling.album;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
}
