package org.example.projectspringfalling.artist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArtistService {
    private final ArtistRepository artistRepository;
}
