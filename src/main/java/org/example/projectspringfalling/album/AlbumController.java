package org.example.projectspringfalling.album;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.user.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AlbumController {
    private static final Logger logger = LoggerFactory.getLogger(AlbumController.class);

    private final AlbumService albumService;
    private final HttpSession session;

    // 앨범 상세보기
    @GetMapping("/albums/{albumId}/list")
    public String songList(Model model, @PathVariable Integer albumId) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        Integer userId = (sessionUser != null) ? sessionUser.getId() : 0;

        AlbumResponse.DetailDTO resp = albumService.albumDetail(albumId, userId);
        model.addAttribute("album", resp);

        return "album/album-list";
//        return "album/album-detail";
    }


    // 앨범 추가하기
    @PostMapping("/albums/register")
    public String albumRegister(AlbumRequest.SaveDTO requestDTO) {
        albumService.addAlbum(requestDTO);
        logger.info("Request DTO: {}", requestDTO);
        return "redirect:/admin/albums";
    }

    // 앨범 더미 테스트
    @GetMapping("/album-test")
    public String test(HttpServletRequest request) {
        int id = 4;
        Album album = albumService.getImage(id);
        request.setAttribute("album", album);
        return "album-test";
    }
}
