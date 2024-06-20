package org.example.projectspringfalling.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;
    private final RedisTemplate<String, Object> rt;


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

    // 회원가입
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO reqDTO) {
        userService.join(reqDTO);
        return "redirect:/login-form";
    }

    // 로그인 페이지
    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    // 로그인
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO reqDTO) {
        UserResponse.LoginDTO sessionUser = userService.login(reqDTO);
        rt.opsForValue().set("sessionUser", sessionUser); // redis에 저장
        return "redirect:/";
    }

    // OAuth Redirect URI(kakao)
    @GetMapping("/oauth/callback/kakao")
    public String oauthCallbackKakao(String code) {
        UserResponse.LoginDTO sessionUser = userService.kakaoLogin(code);
        rt.opsForValue().set("sessionUser", sessionUser); // redis에 저장
        return "redirect:/";
    }

    // OAuth Redirect URI(naver)
    @GetMapping("/oauth/callback/naver")
    public String oauthCallbackNaver(String code) {
        UserResponse.LoginDTO sessionUser = userService.naverLogin(code);
        rt.opsForValue().set("sessionUser", sessionUser); // redis에 저장
        return "redirect:/";
    }

    // 마이페이지
    @GetMapping("/profile")
    public String profile() {
        return "user/profile-password";
//        return "user/profile-phone";
    }

}
