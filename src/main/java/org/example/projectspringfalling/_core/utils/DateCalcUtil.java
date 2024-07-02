package org.example.projectspringfalling._core.utils;

import java.time.LocalDateTime;
import java.sql.Timestamp;

public class DateCalcUtil {

    public static Timestamp calculateEndDate(Timestamp startDate, int duration) {
        LocalDateTime startDateTime = startDate.toLocalDateTime();
        LocalDateTime endDateTime = startDateTime.plusDays(duration);
        return Timestamp.valueOf(endDateTime);
    }
}
