package org.example.projectspringfalling;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.ApiUtil;
import org.example.projectspringfalling.song.Song;
import org.example.projectspringfalling.song.SongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class SearchController {

    private final SongService songService;
    @GetMapping("/search/auto")
    public ApiUtil<List<SongAutoCompleteDTO>> searchAuto(@RequestParam("keyword") String keyword) {
        List<Song> songs = songService.searchKeywordAuto(keyword);
        List<SongAutoCompleteDTO> response = songs.stream()
                .map(song -> new SongAutoCompleteDTO(song.getId(), song.getTitle()))
                .collect(Collectors.toList());
        return new ApiUtil<>(response);
    }

    public static class SongAutoCompleteDTO {
        private Integer id;
        private String title;

        public SongAutoCompleteDTO(Integer id, String title) {
            this.id = id;
            this.title = title;
        }

        public Integer getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }
    }

}
