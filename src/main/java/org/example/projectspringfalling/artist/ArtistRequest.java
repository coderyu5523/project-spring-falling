package org.example.projectspringfalling.artist;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

public class ArtistRequest {
    @Data
    public static class AddArtistDTO {
        private String name;
        private String artistType;
        private MultipartFile artistImg;
    }
}
