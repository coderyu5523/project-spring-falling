package org.example.projectspringfalling.admin;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class AdminController {
    private final AdminService adminService;
    private final HttpSession session;

    // 관리자 앨범 상세보기
    @GetMapping("/admin/albums/{id}")
    public String albumDetail(@PathVariable Integer id) {
        return "admin/admin-album-detail";
    }

}
