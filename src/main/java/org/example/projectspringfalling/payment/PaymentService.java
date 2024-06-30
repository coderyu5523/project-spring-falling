package org.example.projectspringfalling.payment;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.subscription.Subscription;
import org.example.projectspringfalling.subscription.SubscriptionRepository;
import org.example.projectspringfalling.user.User;
import org.example.projectspringfalling.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Transactional
    public void savePayment(PaymentRequest.PaymentDTO paymentDTO, Integer sessionUserId) {
        System.out.println("^test : " + paymentDTO);
        User user = userRepository.findById(sessionUserId)
                .orElseThrow(() -> new Exception404("존재하지 않는 회원입니다."));
        Subscription subscription = subscriptionRepository.findById(Integer.parseInt(paymentDTO.getSubscriptionPk()))
                .orElseThrow(() -> new Exception404("존재하지 않는 이용권입니다."));

        Payment payment = Payment.builder()
                .amount(Integer.parseInt(paymentDTO.getAmount()))
                .means(paymentDTO.getPayMethod())
                .user(user)
                .status("결제 완료")
                .subscription(subscription)
                .transaction_id(paymentDTO.getImpUid())
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .build();
        paymentRepository.save(payment);

        System.out.println("결제 완료");
    }

}
