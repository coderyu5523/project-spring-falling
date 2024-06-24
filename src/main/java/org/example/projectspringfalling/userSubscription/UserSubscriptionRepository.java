package org.example.projectspringfalling.userSubscription;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer> {

    // 프로필에 활성화된 이용권 이름 넣기
    Optional<UserSubscription> findByUserIdAndStatus(Integer userId, String status);
}
