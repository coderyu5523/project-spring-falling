package org.example.projectspringfalling._core.utils;

public class DateUtil {
    public static String formatYear(String year) {
        // 문자열의 마지막 두 문자만 가져옴
        String lastTwoDigits = year.substring(year.length() - 2);
        return lastTwoDigits;
    }

    public static String formatDate(String birth) {
        // 하이픈 제거
        String dateWithoutHyphen = birth.replace("-", "");

        return dateWithoutHyphen;
    }
}
