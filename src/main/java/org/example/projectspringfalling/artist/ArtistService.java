package org.example.projectspringfalling.artist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public Artist getImage(int id) {
       Artist artist = artistRepository.findById(id).get();
       return artist;

    }
}
