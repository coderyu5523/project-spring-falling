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

    @GetMapping("/subscription-list")
    public String subscriptionList() {
        return "subscription/subscription-list";
    }

    @GetMapping("/my-subscription")
    public String mySubscription() {
        return "subscription/my-subscription";
    }


}
