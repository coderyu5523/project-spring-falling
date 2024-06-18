package org.example.projectspringfalling.subscription;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubscriptionController {

    @GetMapping("/subscription-list")
    public String subscriptionList() {
        return "subscription/subscription-list";
    }

    @GetMapping("/my-subscription")
    public String mySubscription() {
        return "subscription/my-subscription";
    }


}
