package org.example.projectspringfalling.payment;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.subscription.Subscription;
import org.example.projectspringfalling.subscription.SubscriptionRepository;
import org.example.projectspringfalling.user.SessionUser;
import org.example.projectspringfalling.user.User;
import org.example.projectspringfalling.user.UserRepository;
import org.example.projectspringfalling.userSubscription.UserSubscription;
import org.example.projectspringfalling.userSubscription.UserSubscriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final UserSubscriptionRepository userSubscriptionRepository;
    private final IamportService iamportService;

    @Transactional
    public void refundPayment(SessionUser sessionUser) {
        userRepository.findById(sessionUser.getId())
                .orElseThrow(() -> new Exception404("존재하지 않는 회원입니다."));
        List<Payment> paymentList = paymentRepository.findByUserIdForRefund(sessionUser.getId());
        Payment payment = null;
        if (!paymentList.isEmpty()) {
            payment = paymentList.getFirst();
        }// 젤 최근 결제 들고오기

        String accessToken = iamportService.getAccessToken();
        ResponseEntity<PaymentResponse.PaymentDetail> response = iamportService.paymentDetail(payment.getTransactionId(), accessToken);
        ResponseEntity<PaymentResponse.RefundDTO> response2 = iamportService.refundPayment(response.getBody().getResponse());
        System.out.println("^ response2 : " + response2);
        payment.update(response2.getBody().getResponse().getStatus()); // 결제 state 변경
        UserSubscription userSubscription = userSubscriptionRepository.findActiveSubscriptionByUserId(sessionUser.getId())
                .orElseThrow(() -> new Exception404("사용 중인 이용권이 없습니다."));
        userSubscription.update("사용취소"); // 사용 중인 이용권 state 변경

        System.out.println("결제 취소 완료 : " + response2);
    }

    @Transactional
    public void savePayment(PaymentRequest.PaymentDTO paymentDTO, SessionUser sessionUser) {
        User user = userRepository.findById(sessionUser.getId())
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

        Optional<UserSubscription> userSubscriptionOP = userSubscriptionRepository.findActiveSubscriptionByUserId(user.getId());
        if (userSubscriptionOP.isPresent()) {
            refundPayment(sessionUser);
            throw new Exception404("이미 사용 중인 이용권이 있어 환불 했습니다.");
        }

        Timestamp timestampNow = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        Timestamp timestampLater = Timestamp.valueOf(LocalDate.now().plusMonths(1).atStartOfDay());

        UserSubscription userSubscription = UserSubscription.builder()
                .startDate(timestampNow)
                .endDate(timestampLater)
                .status("사용중")
                .createdAt(timestampNow)
                .user(user)
                .subscription(subscription)
                .build();
        userSubscriptionRepository.save(userSubscription);


    }

}
