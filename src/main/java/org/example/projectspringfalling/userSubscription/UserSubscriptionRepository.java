package org.example.projectspringfalling.userSubscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer> {

    // 프로필에 활성화된 이용권 이름 넣기
    Optional<UserSubscription> findByUserIdAndStatus(Integer userId, String status);

    @Query("select us,sub from UserSubscription us join fetch us.subscription sub where us.user.id =:userId")
    Optional<List<UserSubscription>> findByUserId(@Param("userId") Integer userId);

    @Query("select us from UserSubscription us where us.user.id =:userId AND us.status = '사용중'")
    Optional<UserSubscription> findActiveSubscriptionByUserId(@Param("userId") Integer userId);
}
