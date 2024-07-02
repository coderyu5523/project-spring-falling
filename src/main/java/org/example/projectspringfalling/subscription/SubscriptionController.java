package org.example.projectspringfalling.subscription;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.user.SessionUser;
import org.example.projectspringfalling.userSubscription.UserSubscriptionResponse;
import org.example.projectspringfalling.userSubscription.UserSubscriptionService;
import org.example.projectspringfalling.payment.Payment;
import org.example.projectspringfalling.payment.PaymentRepository;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final UserSubscriptionService userSubscriptionService;
    private final PaymentRepository paymentRepository; //test
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
//         Optional<Payment> paymentOP = paymentRepository.findByUserId(sessionUser.getId()); //test
//         request.setAttribute("payment", paymentOP.get()); //test
        return "subscription/my-subscription";
    }


}
