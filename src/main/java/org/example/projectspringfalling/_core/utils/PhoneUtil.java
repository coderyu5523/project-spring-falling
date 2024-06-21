package org.example.projectspringfalling._core.utils;

public class PhoneUtil {
    public static String formatPhoneNumber(String phoneNumber) {
        // 전화번호를 세 부분으로 분할
        String part1 = phoneNumber.substring(0, 3);
        String part2 = phoneNumber.substring(3, 7);
        String part3 = phoneNumber.substring(7);

        // 분할된 부분들을 하이픈으로 연결하여 반환
        return part1 + "-" + part2 + "-" + part3;
    }
}
