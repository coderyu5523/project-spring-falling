package org.example.projectspringfalling.album;

import lombok.Data;
import org.example.projectspringfalling.song.SongRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class AlbumRequest {

    @Data
    public static class SaveDTO {
        private String title;
        private String intro;
        private String agency;
        private String distributor;
        private String category;
        private String nationality;
        private MultipartFile albumImg;
        private List<SongRequest.SaveDTO> songList;

    }
}
