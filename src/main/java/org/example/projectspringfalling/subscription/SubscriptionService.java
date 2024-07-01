package org.example.projectspringfalling.subscription;

import lombok.RequiredArgsConstructor;
import org.example.projectspringfalling.user.SessionUser;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

}
