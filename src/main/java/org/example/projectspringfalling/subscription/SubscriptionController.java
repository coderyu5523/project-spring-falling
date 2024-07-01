package org.example.projectspringfalling.subscription;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.user.SessionUser;
import org.example.projectspringfalling.userSubscription.UserSubscriptionResponse;
import org.example.projectspringfalling.userSubscription.UserSubscriptionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final UserSubscriptionService userSubscriptionService;
    private final HttpSession session;

    // 이용권 목록
    @GetMapping("/subscription-list")
    public String subscriptionList() {
        return "subscription/subscription-list";
    }

    // 내가 구매한 이용권
    @GetMapping("/my-subscription")
    public String mySubscription(HttpServletRequest request) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        UserSubscriptionResponse.UserSubscriptionDTO responseDTO = userSubscriptionService.mySubscription(sessionUser);
        request.setAttribute("responseDTO",responseDTO);
        System.out.println("데이터 있나?" +responseDTO.getEndedSubscriptions());
        return "subscription/my-subscription";
    }


}
