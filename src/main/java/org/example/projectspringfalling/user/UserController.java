package org.example.projectspringfalling.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    // 회원가입 선택 페이지
    @GetMapping("/join-section")
    public String joinSection() {
        return "user/join-section";
    }

    // 회원가입 페이지
    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    // 로그인 페이지
    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    // 마이페이지
    @GetMapping("/profile")
    public String profile() {
        return "user/profile-password";
//        return "user/profile-phone";
    }

    @GetMapping("/redis/test")
    public @ResponseBody String redisTest() {
        User sessionUser = (User) session.getAttribute("sessionUser");
        System.out.println("username : " + sessionUser.getEmail());
        return "redis test";
    }

}
