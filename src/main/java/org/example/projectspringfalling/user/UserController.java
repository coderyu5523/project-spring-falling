package org.example.projectspringfalling.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.ApiUtil;
import org.example.projectspringfalling.userSubscription.UserSubscription;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;
    private final RedisTemplate<String, Object> rt;

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        System.out.println("로그아웃 사용자: " + session.getId());
        switch (sessionUser.getProvider()) {
            case "Kakao":
                userService.logoutKakao(sessionUser);
                break;
            case "Naver":
                userService.logoutNaver(sessionUser);
                break;
            default:
                break;
        }
        rt.delete("sessionUser:" + session.getId());
        session.invalidate();
        return "redirect:/";
    }

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
    public String login(UserRequest.LoginDTO reqDTO, HttpServletRequest request) {
        SessionUser sessionUser = userService.login(reqDTO);
        rt.opsForValue().set("sessionUser:" + session.getId(), sessionUser);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/";
    }

    // OAuth Redirect URI(kakao)
    @GetMapping("/oauth/callback/kakao")
    public String oauthCallbackKakao(String code, HttpServletRequest request) {
        SessionUser sessionUser = userService.kakaoLogin(code);
        rt.opsForValue().set("sessionUser:" + session.getId(), sessionUser);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/";
    }

    // OAuth Redirect URI(naver)
    @GetMapping("/oauth/callback/naver")
    public String oauthCallbackNaver(String code, HttpServletRequest request) {
        SessionUser sessionUser = userService.naverLogin(code);
        rt.opsForValue().set("sessionUser:" + session.getId(), sessionUser);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/";
    }

    // 마이페이지
    @GetMapping("/profile")
    public String profile(HttpServletRequest request) {

        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");

        // 회원 정보 (계정, 이메일, 이용권)
        String provider = sessionUser.getProvider();
        String email = sessionUser.getEmail();
        Optional<UserSubscription> userSubscriptionOpt = userService.getActiveUserSubscription(sessionUser.getId());

        String subscriptionName = userSubscriptionOpt.map(us -> us.getSubscription().getName())
                .orElse("사용중인 이용권이 없습니다.");

        UserRequest.ProfileDTO profile = new UserRequest.ProfileDTO(provider, email, subscriptionName);
        request.setAttribute("profile", profile);

        return "user/profile-password";
//        return "user/profile-phone";
    }

    // 현재 비밀번호 일치 확인
    @GetMapping("/api/password-same-check")
    public @ResponseBody ApiUtil<Boolean> passwordSameCheck(@RequestParam String inputPassword, HttpServletRequest request) {

        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        System.out.println("세션값 없나?" + sessionUser.getId());
        try {
            if (sessionUser == null) {
                throw new IllegalStateException("로그인이 되지 않았습니다.");
            }
            boolean isValid = userService.passwordCheck(sessionUser.getEmail(), inputPassword);
            return new ApiUtil<>(isValid);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiUtil<>(false);
        }
    }

    @PutMapping("/users")
    public String update(String password, String phone) {
        System.out.println("1111111111111111111111111");
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.UpdateDTO responseDTO = userService.update(sessionUser, password,phone);
        return "user/profile-password";
    }
}
