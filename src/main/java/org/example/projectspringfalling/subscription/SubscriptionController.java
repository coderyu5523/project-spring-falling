package org.example.projectspringfalling.subscription;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.utils.RedisUtil;
import org.example.projectspringfalling.payment.PaymentRepository;
import org.example.projectspringfalling.user.SessionUser;
import org.example.projectspringfalling.userSubscription.UserSubscriptionResponse;
import org.example.projectspringfalling.userSubscription.UserSubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final UserSubscriptionService userSubscriptionService;
    private final PaymentRepository paymentRepository; //test
    private final HttpSession session;
    private final RedisUtil redisUtil;

    // 이용권 목록
    @GetMapping("/subscription-list")
    public String subscriptionList() {
        return "subscription/subscription-list";
    }

    // 내가 구매한 이용권
    @GetMapping("/my-subscription")
    public String mySubscription(Model model) {
        SessionUser sessionUser = redisUtil.getSessionUser();
        UserSubscriptionResponse.UserSubscriptionDTO responseDTO = userSubscriptionService.mySubscription(sessionUser);
        model.addAttribute("responseDTO", responseDTO);

        return "subscription/my-subscription";
    }


}
