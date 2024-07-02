package org.example.projectspringfalling.userSubscription;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.subscription.Subscription;
import org.example.projectspringfalling.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "user_subscription_tb")
public class UserSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp startDate; // 시작 날짜
    private Timestamp endDate; // 종료 날짜
    private String status; // 이용권 상태

    @CreationTimestamp
    private Timestamp createdAt; // 생성날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;  // 회원

    @ManyToOne(fetch = FetchType.LAZY)
    private Subscription subscription; // 이용권


    @Builder
    public UserSubscription(Integer id, Timestamp startDate, Timestamp endDate, String status, Timestamp createdAt, User user, Subscription subscription) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdAt = createdAt;
        this.user = user;
        this.subscription = subscription;
    }

    public void update(String status) {
        this.status = status;
    }

}
