package org.example.projectspringfalling.artist;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.enums.FilePathEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import static org.example.projectspringfalling._core.utils.FileUtil.fileSave;

@RequiredArgsConstructor
@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

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
