package org.example.projectspringfalling.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class IamportService {
    private final RestTemplate rt = new RestTemplate();

    @Value("${iamport.imp_key}")
    private String impKey;

    @Value("${iamport.imp_secret}")
    private String impSecret;

    // 환불
    @Transactional
    public ResponseEntity<PaymentResponse.RefundDTO> refundPayment(PaymentResponse.PaymentDetail.ResponseDTO reqDTO) {
        String accessToken = getAccessToken();

        // 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json;charset=utf-8");
        headers.add("Authorization", "Bearer " + accessToken); // 인증 및 권한 부여

        // 바디
        ObjectMapper mapper = new ObjectMapper(); // JSON과 Java 객체간의 변환을 처리하는 역할
        ObjectNode body = mapper.createObjectNode(); // ObjectNode : JSON 객체를 표현하는 Jackson의 클래스
        body.put("imp_uid", reqDTO.getImp_uid()); // 포트원 거래고유번호
        body.put("merchant_uid", reqDTO.getMerchant_uid()); // falling의 주문번호
        body.put("amount", reqDTO.getAmount()); // 취소 요청 금액(전액 취소 요청)
        body.put("refund_account", 0); // 지금은 결제 방법이 전부 카드나 페이라서 임의로 0 넣음

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<PaymentResponse.RefundDTO> response = rt.exchange(
                "https://api.iamport.kr/payments/cancel",
                HttpMethod.POST,
                request,
                PaymentResponse.RefundDTO.class
        );

        return response;
    }

    // access 토큰 발급
    @Transactional
    public String getAccessToken() {
        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 바디 설정
        ObjectMapper mapper = new ObjectMapper(); // JSON과 Java 객체간의 변환을 처리하는 역할
        ObjectNode body = mapper.createObjectNode(); // ObjectNode : JSON 객체를 표현하는 Jackson의 클래스
        body.put("imp_key", impKey);
        body.put("imp_secret", impSecret);

        // 헤더 + 바디
        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers); // HttpEntity : 요청 본문과 헤더를 함께 보낼 수 있는 객체


        // API 요청
        ResponseEntity<PaymentResponse.TokenDTO> response = rt.exchange( // ResponseEntity는 HTTP 응답을 나타내며 HTTP 상태코드, 헤더, 바디를 담을 수 있다.
                "https://api.iamport.kr/users/getToken",
                HttpMethod.POST,
                request,
                PaymentResponse.TokenDTO.class // 응답 타입 설정
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) { // HTTP 응답 상태 코드가 200번대 + 응답 본문이 비어있지 않다면
            return response.getBody().getResponse().getAccessToken(); // response에 있는 accessToken을 return
        }

        throw new RuntimeException("Failed to get access token from Iamport API");
    }

    // 결제 상세 정보
    public ResponseEntity<PaymentResponse.PaymentDetail> paymentDetail(String impUid, String accessToken) {
        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json;charset=utf-8");
        headers.add("Authorization", "Bearer " + accessToken); // 인증 및 권한 부여

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers); // GET이라서 바디가 필요 없다.

        // API 요청
        ResponseEntity<PaymentResponse.PaymentDetail> response = rt.exchange(
                "https://api.iamport.kr/payments/" + impUid,
                HttpMethod.GET,
                request,
                PaymentResponse.PaymentDetail.class);

        System.out.println("response : " + response.getBody().toString());

        return response;
    }

    // 결제 사전 검증 (금액 위조 방지)
    @Transactional
    public ResponseEntity<String> preparePayment(PaymentRequest.PrepareDTO paymentRequest) {
        String accessToken = getAccessToken();

        // 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<PaymentRequest.PrepareDTO> request = new HttpEntity<>(paymentRequest, headers);

        // API 요청
        ResponseEntity<String> response = rt.exchange(
                "https://api.iamport.kr/payments/prepare",
                HttpMethod.POST,
                request,
                String.class
        );

        return response;
    }
}
