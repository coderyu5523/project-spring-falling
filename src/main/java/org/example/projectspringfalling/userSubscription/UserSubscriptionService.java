package org.example.projectspringfalling.userSubscription;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSubscriptionService {
    private final UserSubscriptionRepository userSubscriptionRepository;
}
