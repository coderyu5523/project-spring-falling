package org.example.projectspringfalling.payment;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.subscription.Subscription;
import org.example.projectspringfalling.subscription.SubscriptionRepository;
import org.example.projectspringfalling.user.SessionUser;
import org.example.projectspringfalling.user.User;
import org.example.projectspringfalling.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final IamportService iamportService;

    @Transactional
    public void refundPayment(PaymentRequest.RefundInfoDTO req, SessionUser sessionUser) {
        userRepository.findById(sessionUser.getId())
                .orElseThrow(() -> new Exception404("존재하지 않는 회원입니다."));
        Payment payment = paymentRepository.findByTransactionId(req.getTransactionId())
                .orElseThrow(() -> new Exception404("존재하지 않는 결제내역입니다."));

        String accessToken = iamportService.getAccessToken();
        ResponseEntity<PaymentResponse.PaymentDetail> response = iamportService.paymentDetail(payment.getTransactionId(), accessToken);
        ResponseEntity<PaymentResponse.RefundDTO> response2 = iamportService.refundPayment(response.getBody().getResponse());

        payment.update(response2.getBody().getResponse().getStatus()); // 결제 state 변경

        System.out.println("결제 취소 완료 : " + response2);
    }

    @Transactional
    public void savePayment(PaymentRequest.PaymentDTO paymentDTO, Integer sessionUserId) {
        User user = userRepository.findById(sessionUserId)
                .orElseThrow(() -> new Exception404("존재하지 않는 회원입니다."));
        Subscription subscription = subscriptionRepository.findById(Integer.parseInt(paymentDTO.getSubscriptionPk()))
                .orElseThrow(() -> new Exception404("존재하지 않는 이용권입니다."));

        String accessToken = iamportService.getAccessToken();
        ResponseEntity<PaymentResponse.PaymentDetail> response = iamportService.paymentDetail(paymentDTO.getImpUid(), accessToken);

        Payment payment = Payment.builder()
                .amount(response.getBody().getResponse().getAmount())
                .means(response.getBody().getResponse().getCard_name())
                .user(user)
                .status(response.getBody().getResponse().getStatus())
                .subscription(subscription)
                .transactionId(response.getBody().getResponse().getImp_uid())
                .createdAt(response.getBody().getResponse().getPaid_at())
                .build();
        paymentRepository.save(payment);

        System.out.println("결제 완료");
    }

}
