package org.example.projectspringfalling.payment;

import lombok.Data;

public class PaymentRequest {
    // 결제 DTO
    @Data
    public static class PaymentDTO {
        private String impUid; // 결제 고유번호
        private String merchantUid; // 주문번호
        private String subscriptionPk; // 이용권 id
        private String name; // 상품 이름
        private String amount; // 결제 금액
        private String payMethod; // 결제 방법
    }

    @Data
    public static class PrepareDTO {
        private String merchant_uid;
        private Integer amount;
    }
}
