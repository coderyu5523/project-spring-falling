package org.example.projectspringfalling._core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.errors.exception.Exception401;
import org.example.projectspringfalling._core.utils.RedisUtil;
import org.example.projectspringfalling.admin.SessionAdmin;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle............");
        HttpSession session = request.getSession();

//        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
//        if (sessionUser == null) {
//            throw new Exception401("로그인 하셔야 해요");
//        }
//        return true;
//    }
        // 일반 사용자 세션 검사
        SessionUser sessionUser = redisUtil.getSessionUser();
        // 관리자 세션 검사
        SessionAdmin sessionAdmin = (SessionAdmin) session.getAttribute("sessionAdmin");

        if (sessionUser == null && sessionAdmin == null) {
            throw new Exception401("로그인 하셔야 해요");
        }
        return true;
    }
}