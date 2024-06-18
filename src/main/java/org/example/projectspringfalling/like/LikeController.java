package org.example.projectspringfalling.like;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class LikeController {
    private final LikeService likeService;
    private final HttpSession session;

}
