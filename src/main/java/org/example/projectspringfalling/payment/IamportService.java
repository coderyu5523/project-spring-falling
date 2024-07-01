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

    @Transactional
    public ResponseEntity<?> refundPayment(PaymentResponse.PaymentDetail.ResponseDTO reqDTO) {
        String accessToken = getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json;charset=utf-8");
        headers.add("Authorization", "Bearer " + accessToken);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode body = mapper.createObjectNode();
        body.put("imp_uid", reqDTO.getImp_uid());
        body.put("merchant_uid", reqDTO.getMerchant_uid());
        body.put("amount", reqDTO.getAmount());
        body.put("refund_account", 0);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<PaymentResponse.RefundDTO> response = rt.exchange(
                "https://api.iamport.kr/payments/cancel",
                HttpMethod.POST,
                request,
                PaymentResponse.RefundDTO.class
        );

        return response;
    }

    @Transactional
    public String getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode body = mapper.createObjectNode();
        body.put("imp_key", impKey);
        body.put("imp_secret", impSecret);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<PaymentResponse.TokenDTO> response = rt.exchange(
                "https://api.iamport.kr/users/getToken",
                HttpMethod.POST,
                request,
                PaymentResponse.TokenDTO.class
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody().getResponse().getAccessToken();
        }

        throw new RuntimeException("Failed to get access token from Iamport API");
    }

    @Transactional
    public ResponseEntity<PaymentResponse.PaymentDetail> paymentDetail(String impUid, String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json;charset=utf-8");
        headers.add("Authorization", "Bearer " + accessToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);

        ResponseEntity<PaymentResponse.PaymentDetail> response = rt.exchange(
                "https://api.iamport.kr/payments/" + impUid,
                HttpMethod.GET,
                request,
                PaymentResponse.PaymentDetail.class);

        System.out.println("response : " + response.getBody().toString());

        return response;
    }

    @Transactional
    public ResponseEntity<String> preparePayment(PaymentRequest.PrepareDTO paymentRequest) {
        RestTemplate rt = new RestTemplate();

        String accessToken = getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<PaymentRequest.PrepareDTO> request = new HttpEntity<>(paymentRequest, headers);

        ResponseEntity<String> response = rt.exchange(
                "https://api.iamport.kr/payments/prepare",
                HttpMethod.POST,
                request,
                String.class
        );

        return response;
    }
}
