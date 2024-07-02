package org.example.projectspringfalling._core.config;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.RedisUtil;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@RequiredArgsConstructor
@ControllerAdvice
public class GlobalModelAttribute {
    private final RedisUtil redisUtil;

    @ModelAttribute("sessionUser")
    public SessionUser addSessionUserToModel() {
        return redisUtil.getSessionUser();
    }
}
