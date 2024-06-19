package org.example.projectspringfalling.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/join-section")
    public String joinSection() {
        return "user/join-section";
    }
    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }
    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }
    @GetMapping("/profile")
    public String profile() {
        return "user/profile-password";
//        return "user/profile-phone";
    }
}
