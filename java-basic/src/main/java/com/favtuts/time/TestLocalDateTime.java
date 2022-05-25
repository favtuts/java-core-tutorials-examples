package com.favtuts.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLocalDateTime {

    public static void main(String[] args) {
        
        //testLocalDateTimeToString();
        testStringToLocalDateTime();
    }
    

    private static void testLocalDateTimeToString() {
        // Get current date time
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Before : " + now);          // 2022-05-25T15:57:20.601431

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = now.format(formatter);  // 2022-05-25 15:57:20

        System.out.println("After  : " + formatDateTime);
    }


    private static void testStringToLocalDateTime() {

        String now = "2016-11-09 10:30";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);

        System.out.println("Before : " + now);

        System.out.println("After : " + formatDateTime);

        System.out.println("After : " + formatDateTime.format(formatter));

    }
}
