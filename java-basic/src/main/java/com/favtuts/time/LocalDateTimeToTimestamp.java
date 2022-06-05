package com.favtuts.time;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeToTimestamp {

    public static void main(String[] args) {
        // convertLocalDateTimeFromToTimestamp();
        convertLocalDateFromToTimestamp();
    }

    static void convertLocalDateFromToTimestamp() {
        // LocalDate to Timestamp
        LocalDate now = LocalDate.now();
        Timestamp timestamp = Timestamp.valueOf(now.atStartOfDay());

        System.out.println(now); // 2019-06-14
        System.out.println(timestamp); // 2019-06-14 00:00:00.0

        // Timestamp to LocalDate
        LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
        System.out.println(localDate); // 2019-06-14
    }

    static void convertLocalDateTimeFromToTimestamp() {
        // LocalDateTime to Timestamp
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        System.out.println(now); // 2019-06-14T15:50:36.068076300
        System.out.println(timestamp); // 2019-06-14 15:50:36.0680763

        // Timestamp to LocalDateTime
        LocalDateTime localDateTime = timestamp.toLocalDateTime();

        System.out.println(localDateTime); // 2019-06-14T15:50:36.068076300
    }
}
