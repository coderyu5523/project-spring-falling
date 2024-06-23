package org.example.projectspringfalling.RestAPI;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.ApiUtil;
import org.example.projectspringfalling.song.SongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final SongService songService;

    // 검색 자동완성 기능
    @GetMapping("/search/auto")
    public ApiUtil<List<RestResponse.SearchAutoCompleteDTO>> searchAuto(@RequestParam("keyword") String keyword) {
        List<RestResponse.SearchAutoCompleteDTO> responseDTO = songService.searchKeywordAuto(keyword);
        return new ApiUtil<>(responseDTO);
    }



}
