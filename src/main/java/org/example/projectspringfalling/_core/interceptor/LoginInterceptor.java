package org.example.projectspringfalling._core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.errors.exception.Exception401;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final RedisTemplate<String, Object> rt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        String redisKey = "sessionUser:" + sessionId;

        try {
            // Redis에서 세션 유저 정보 가져오기
            SessionUser sessionUser = (SessionUser) rt.opsForValue().get(redisKey);

            if (sessionUser == null) {
                System.err.println("Redis에서 세션 유저 정보를 가져올 수 없습니다: " + redisKey);
                throw new Exception401("로그인 해주세요");
            }

            // 세션 만료 시간 연장 (30분)
            rt.expire(redisKey, 30, TimeUnit.MINUTES);

            // 세션 유저 정보를 request attribute에 저장하여 이후 컨트롤러에서 사용 가능하게 함
            request.setAttribute("sessionUser", sessionUser);

        } catch (Exception e) {
            // Redis 연결 오류 처리
            System.err.println("Redis 연결 오류: " + e.getMessage());
            throw new RuntimeException("Redis 서버에 연결할 수 없습니다.", e);
        }

        return true;
    }
}