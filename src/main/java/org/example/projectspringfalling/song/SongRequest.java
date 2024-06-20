package org.example.projectspringfalling.song;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

public class SongRequest {

    @Data
    public static class SaveDTO {
        private String title;
        private String lyrics;
        private String songWriter;
        private String lyricist;
        private String genre;
        private Boolean isTitle;
        private MultipartFile song;
        private MultipartFile musicVideo;
    }
}
