package org.example.projectspringfalling.payment;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.projectspringfalling.subscription.Subscription;
import org.example.projectspringfalling.user.User;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "payment_tb")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer amount; // 결제 금액
    private String means; // 결제 수단
    private String status; // 결제 상태
    private String transactionId; // 결제서비스 제공자가 주는 거래 id
    private Integer createdAt; // 생성날짜

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // 회원

    @ManyToOne(fetch = FetchType.LAZY)
    private Subscription subscription; // 이용권

    @Builder
    public Payment(Integer id, Integer amount, String means, String status, String transactionId, Integer createdAt, User user, Subscription subscription) {
        this.id = id;
        this.amount = amount;
        this.means = means;
        this.status = status;
        this.transactionId = transactionId;
        this.createdAt = createdAt;
        this.user = user;
        this.subscription = subscription;
    }
}
