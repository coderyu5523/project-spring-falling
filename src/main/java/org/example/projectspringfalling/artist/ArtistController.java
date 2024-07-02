package org.example.projectspringfalling.artist;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.RedisUtil;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ArtistController {
    private final ArtistService artistService;
    private final HttpSession session;
    private final RedisUtil redisUtil;

    // 가수 상세보기 (앨범)
    @GetMapping("/artists/{artistId}")
    public String artistDetailAlbumList(Model model, @PathVariable Integer artistId) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        Integer userId = (sessionUser != null) ? sessionUser.getId() : 0;

        ArtistResponse.ArtistDetailDTO resp = artistService.artistDetail(artistId, userId);
        model.addAttribute("artist", resp);

//        return "artist/artist-song-list";
        return "artist/artist-album-list";

    }

    // 가수 등록하기
    @PostMapping("/artists/register")
    public String artistRegister(ArtistRequest.AddArtistDTO requestDTO) {
        artistService.addArtist(requestDTO);

        return "redirect:/admin/artists";
    }

    // todo : 더미 테스트용 , 삭제 예정
    @GetMapping("/artist-test")
    public String test(Model model) {
        int id = 5;
        Artist artist = artistService.getImage(id);
        model.addAttribute("artist", artist);
        return "artst-test";
    }

}
