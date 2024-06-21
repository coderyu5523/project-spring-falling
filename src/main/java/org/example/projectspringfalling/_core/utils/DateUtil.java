package org.example.projectspringfalling._core.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {
    public static String timestampToString(Timestamp timestamp) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(timestamp);
    }

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
