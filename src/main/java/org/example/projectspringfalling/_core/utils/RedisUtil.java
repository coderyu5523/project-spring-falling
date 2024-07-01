package org.example.projectspringfalling._core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.admin.SessionAdmin;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RedisUtil {
    private final RedisTemplate<String, Object> rt;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // sessionAdmin
    public SessionAdmin getSessionAdmin() {
        Object sessionAdminJson = rt.opsForValue().get("sessionAdmin");
        if (sessionAdminJson != null) {
            try {
                return objectMapper.readValue(sessionAdminJson.toString(), SessionAdmin.class);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
        return null;
    }

    public void setSessionAdmin(SessionAdmin sessionAdmin) {
        try {
            String sessionAdminJson = objectMapper.writeValueAsString(sessionAdmin);
            rt.opsForValue().set("sessionAdmin", sessionAdminJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    // sessionUser
    public SessionUser getSessionUser() {
        Object sessionUserJson = rt.opsForValue().get("sessionUser");
        if (sessionUserJson != null) {
            try {
                return objectMapper.readValue(sessionUserJson.toString(), SessionUser.class);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
        return null;
    }

    public void setSessionUser(SessionUser sessionUser) {
        try {
            String sessionUserJson = objectMapper.writeValueAsString(sessionUser);
            rt.opsForValue().set("sessionUser", sessionUserJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
