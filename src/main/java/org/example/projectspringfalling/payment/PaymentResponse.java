package org.example.projectspringfalling.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class PaymentResponse {
    @Data
    public static class TokenDTO {
        @JsonProperty("code") // 이렇게 해주면 access_token으로 파싱된 값이 accessToken에 들어간다.(jackson 라이브러리)
        private Integer code;

        @JsonProperty("message")
        private String message;

        @JsonProperty("response")
        private ResponseDTO response;

        @Data
        public static class ResponseDTO { // 선택적으로 가져올 수 있다.
            @JsonProperty("access_token")
            private String accessToken;

            @JsonProperty("now")
            private Long now;

            @JsonProperty("expired_at")
            private Long expiredAt;
        }
    }

    @Data
    public static class PaymentDetail {
        @JsonProperty("code") // 이렇게 해주면 access_token으로 파싱된 값이 accessToken에 들어간다.(jackson 라이브러리)
        private Integer code;

        @JsonProperty("message")
        private String message;

        @JsonProperty("response")
        private ResponseDTO response;

        @Data
        public static class ResponseDTO { // 선택적으로 가져올 수 있다.
            @JsonProperty("amount")
            private Integer amount;

            @JsonProperty("card_name")
            private String card_name;

            @JsonProperty("imp_uid")
            private String imp_uid;

            @JsonProperty("merchant_uid")
            private String merchant_uid;

            @JsonProperty("name")
            private String name;

            @JsonProperty("status")
            private String status; // 결제 상태

            @JsonProperty("paid_at")
            private Integer paid_at; // 결제 시각(결제완료가 안 된 경우 0으로 표시)
        }
    }

    @Data
    public static class RefundDTO {
        @JsonProperty("code") // 이렇게 해주면 access_token으로 파싱된 값이 accessToken에 들어간다.(jackson 라이브러리)
        private Integer code;

        @JsonProperty("message")
        private String message;

        @JsonProperty("response")
        private ResponseDTO response;

        @Data
        public static class ResponseDTO { // 선택적으로 가져올 수 있다.
            @JsonProperty("imp_uid")
            private String imp_uid;

            @JsonProperty("merchant_uid")
            private String merchant_uid;

            @JsonProperty("pay_method")
            private String pay_method;

            @JsonProperty("card_name")
            private String card_name;

            @JsonProperty("name")
            private String name;

            @JsonProperty("amount")
            private Integer amount;

            @JsonProperty("cancel_amount")
            private Integer cancel_amount;

            @JsonProperty("status")
            private String status; // 결제 상태

            @JsonProperty("paid_at")
            private Integer paid_at; // 결제 시각(결제완료가 안 된 경우 0으로 표시)
        }
    }

}
