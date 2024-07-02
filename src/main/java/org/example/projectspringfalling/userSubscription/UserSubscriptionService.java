package org.example.projectspringfalling.userSubscription;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling._core.errors.exception.Exception404;
import org.example.projectspringfalling.payment.PaymentRepository;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserSubscriptionService {
    private final UserSubscriptionRepository userSubscriptionRepository;
    private final PaymentRepository paymentRepository;

    public UserSubscriptionResponse.UserSubscriptionDTO mySubscription(SessionUser sessionUser) {


        List<UserSubscription> userSubscriptionList = userSubscriptionRepository.findByUserId(sessionUser.getId())
                .orElseThrow(() -> new Exception404("조회된 정보가 없습니다."));

        List<UserSubscriptionResponse.UserSubscriptionDTO.AvailableSubDTO> availableSubscriptions = userSubscriptionList.stream()
                .filter(userSubscription -> "사용중".equals(userSubscription.getStatus()))
                .map(UserSubscriptionResponse.UserSubscriptionDTO.AvailableSubDTO::new)
                .collect(Collectors.toList());


        List<UserSubscriptionResponse.UserSubscriptionDTO.EndSubDTO> endedSubscriptions = userSubscriptionList.stream()
                .filter(userSubscription -> "사용완료".equals(userSubscription.getStatus()))
                .map(UserSubscriptionResponse.UserSubscriptionDTO.EndSubDTO::new)
                .collect(Collectors.toList());


        return new UserSubscriptionResponse.UserSubscriptionDTO(availableSubscriptions, endedSubscriptions);
    }
}
