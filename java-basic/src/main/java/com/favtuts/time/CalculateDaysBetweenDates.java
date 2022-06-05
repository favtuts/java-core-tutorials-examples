package com.favtuts.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateDaysBetweenDates {
    
    public static void main(String[] args) {
        // calculateDaysBetweenLocalDate();
        calculateDaysBetweenLocalDateTime();
    }

    static void calculateDaysBetweenLocalDateTime() {
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusDays(10);

        long result = ChronoUnit.DAYS.between(from, to);
        System.out.println(result);     // 10

        LocalDateTime to2 = from.minusDays(10);
        long result2 = ChronoUnit.DAYS.between(from, to2);
        System.out.println(result2);    // -10
    }

    static void calculateDaysBetweenLocalDate() {
        LocalDate from = LocalDate.now();
        LocalDate to = from.plusDays(10);

        long result = ChronoUnit.DAYS.between(from, to);
        System.out.println(result);    // 10
    }
}
