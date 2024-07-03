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
        // 존재하는 회원인지 확인
        userRepository.findById(sessionUser.getId())
                .orElseThrow(() -> new Exception404("존재하지 않는 회원입니다."));

        // 해당 유저가 결제한 내역을 최신순으로 들고 온다.(환불된 결제 내역은 안 들고 온다.)
        List<Payment> paymentList = paymentRepository.findByUserIdForRefund(sessionUser.getId());
        Payment payment = null;
        if (!paymentList.isEmpty()) {
            payment = paymentList.getFirst(); // 젤 최근 결제 들고오기
        }

        String accessToken = iamportService.getAccessToken(); // access token 발급

        ResponseEntity<PaymentResponse.PaymentDetail> response = iamportService.paymentDetail(payment.getTransactionId(), accessToken); // 결제 내역 단건 조회(환불 request를 만들 때 필요한 정보를 가져오기 위해)
        ResponseEntity<PaymentResponse.RefundDTO> response2 = iamportService.refundPayment(response.getBody().getResponse()); // 환불 진행
        System.out.println("^ response2 : " + response2);

        payment.update(response2.getBody().getResponse().getStatus()); // 결제 state 변경

        // 사용자 이용권 조회 후 state 변경
        UserSubscription userSubscription = userSubscriptionRepository.findActiveSubscriptionByUserId(sessionUser.getId())
                .orElseThrow(() -> new Exception404("사용 중인 이용권이 없습니다."));
        userSubscription.update("사용취소"); // 사용 중인 이용권 state 변경

        System.out.println("결제 취소 완료 : " + response2);
    }

    @Transactional
    public void savePayment(PaymentRequest.PaymentDTO paymentDTO, SessionUser sessionUser) {
        // 존재하는 유저인지 확인
        User user = userRepository.findById(sessionUser.getId())
                .orElseThrow(() -> new Exception404("존재하지 않는 회원입니다."));
        // 존재하는 이용권인지 확인
        Subscription subscription = subscriptionRepository.findById(Integer.parseInt(paymentDTO.getSubscriptionPk()))
                .orElseThrow(() -> new Exception404("존재하지 않는 이용권입니다."));

        String accessToken = iamportService.getAccessToken(); // 결제 정보 조회를 위해 accessToken 발급
        ResponseEntity<PaymentResponse.PaymentDetail> response = iamportService.paymentDetail(paymentDTO.getImpUid(), accessToken); // impUid와 accessToken으로 결제 정보 (단건) 조회

        // 결제 정보를 저장하기 위해 Payment를 builder로 생성
        Payment payment = Payment.builder()
                .amount(response.getBody().getResponse().getAmount())
                .means(response.getBody().getResponse().getCard_name())
                .user(user)
                .status(response.getBody().getResponse().getStatus())
                .subscription(subscription)
                .transactionId(response.getBody().getResponse().getImp_uid())
                .createdAt(response.getBody().getResponse().getPaid_at())
                .build();
        paymentRepository.save(payment); // insert

        // 만약 이미 사용 중인 이용권이 있다 -> 이미 결제한걸 환불 처리
        Optional<UserSubscription> userSubscriptionOP = userSubscriptionRepository.findActiveSubscriptionByUserId(user.getId());
        if (userSubscriptionOP.isPresent()) {
            refundPayment(sessionUser);
            throw new Exception404("이미 사용 중인 이용권이 있어 환불 했습니다.");
        }

        Timestamp timestampNow = Timestamp.valueOf(LocalDate.now().atStartOfDay()); // 오늘의 날짜 (시간은 00:00:00)
        Timestamp timestampLater = Timestamp.valueOf(LocalDate.now().plusMonths(1).atStartOfDay()); // 한 달 뒤의 날짜 (시간은 00:00:00)

        // 사용자 이용권 정보를 저장하기 위해 Usersubscription을 builder로 생성
        UserSubscription userSubscription = UserSubscription.builder()
                .startDate(timestampNow)
                .endDate(timestampLater)
                .status("사용중")
                .createdAt(timestampNow)
                .user(user)
                .subscription(subscription)
                .build();
        userSubscriptionRepository.save(userSubscription); // insert


    }

}
