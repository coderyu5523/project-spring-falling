package org.example.projectspringfalling.payment;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class PaymentController {
    private final PaymentService paymentService;
    private final HttpSession session;

}
