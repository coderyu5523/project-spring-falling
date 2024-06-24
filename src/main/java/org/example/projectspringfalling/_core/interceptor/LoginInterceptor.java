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
        HttpSession session = request.getSession(); // 현재 요청의 세션 가져오기
        String redisKey = "sessionUser:" + session.getId(); // 세션 ID를 기반으로 Redis 키를 생성

        try {
            SessionUser sessionUser = (SessionUser) rt.opsForValue().get(redisKey); // Redis에서 세션 유저 정보 가져오기

            if (sessionUser == null) { // 유저 정보가 없으면 예외 처리
                System.err.println("Redis에서 세션 유저 정보를 가져올 수 없습니다: " + redisKey);
                throw new Exception401("로그인 해주세요");
            }
            
            rt.expire(redisKey, 30, TimeUnit.MINUTES); // Redis에서 세션 유저 정보 만료 시간을 30분으로 연장

            request.setAttribute("sessionUser", sessionUser); // 세션 유저 정보를 저장 -> 이후 컨트롤러에서 사용 가능하다.

        } catch (Exception e) { // Redis 연결 오류 처리
            System.err.println("Redis 연결 오류: " + e.getMessage());
            throw new RuntimeException("Redis 서버에 연결할 수 없습니다.", e);
        }

        return true;
    }
}