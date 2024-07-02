package org.example.projectspringfalling.song;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.RedisUtil;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SongController {
    private final SongService songService;
    private final HttpSession session;
    private final RedisTemplate<String, Object> rt;
    private final RedisUtil redisUtil;

    // 곡 상세보기
    @GetMapping("/songs/{songId}")

    public String songDetail(Model model, @PathVariable Integer songId) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        SongResponse.DetailDTO resp = songService.songDetail(songId, sessionUser.getId());
        System.out.println("음악없나?" + resp.getMusicFile());
        model.addAttribute("song", resp);
        return "song/song-detail";
    }

    // 메인 페이지
    @GetMapping("/")
    public String index(Model model) {
        SongResponse.MainDTO resp = songService.main();
        model.addAttribute("main", resp);
        return "index";
    }

    // 검색 페이지
    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        SongResponse.SearchDTO reponseDTO = songService.searchKeyword(keyword);
        model.addAttribute("reponseDTO", reponseDTO);
        return "search";
    }

    // 차트별 페이지
    @GetMapping("/song-chart")
    public String songChart(Model model) {
        boolean isLogin = redisUtil.getSessionUser() != null; // 로그인 되어있으면 true, 아니면 false
        List<SongResponse.ChartDTO> MainChartDTOs = songService.mainChart(); // 메인 차트
        List<SongResponse.ChartDTO> globalChartDTOs = songService.globalChart(); // 해외 소셜 차트
        List<SongResponse.ChartDTO> domesticChartDTOs = songService.domesticBalladChart(); // 국내 발라드 차트
        List<SongResponse.ChartDTO> globalPopChartDTOs = songService.globalPopChart(); // 해외 팝 차트
        List<SongResponse.ChartDTO> globalHipHopChartDTOs = songService.globalHipHopChart(); // 해외 힙합 차트
        List<SongResponse.ChartDTO> domesticRBChartDTOs = songService.domesticRBChart(); // 국내 알앤비 차트
        List<SongResponse.ChartDTO> domesticDanceAndElectronicChartDTOs = songService.domesticDanceAndElectronicChart(); // 국내 댄스,일렉 차트

        SongResponse.AllChartDTO resp = new SongResponse.AllChartDTO(
                isLogin, MainChartDTOs, globalChartDTOs, domesticChartDTOs,
                globalPopChartDTOs, globalHipHopChartDTOs, domesticRBChartDTOs, domesticDanceAndElectronicChartDTOs);
        model.addAttribute("all", resp);
        return "song/song-chart";
    }

    // 장르별 페이지
    @GetMapping("/song-genre")
    public String songGenre() {
        return "song/song-genre";
    }


}
