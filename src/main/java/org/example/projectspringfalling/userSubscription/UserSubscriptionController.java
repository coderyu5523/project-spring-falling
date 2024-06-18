package org.example.projectspringfalling.userSubscription;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class UserSubscriptionController {
    private final UserSubscriptionService userSubscriptionService;
    private final HttpSession session;

}
