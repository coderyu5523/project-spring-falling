package org.example.projectspringfalling.subscription;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final HttpSession session;

    // 이용권 목록
    @GetMapping("/subscription-list")
    public String subscriptionList() {
        return "subscription/subscription-list";
    }

    // 내가 구매한 이용권
    @GetMapping("/my-subscription")
    public String mySubscription() {
        return "subscription/my-subscription";
    }


}
