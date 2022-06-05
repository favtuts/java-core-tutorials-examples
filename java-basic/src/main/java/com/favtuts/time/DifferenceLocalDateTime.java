package com.favtuts.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DifferenceLocalDateTime {

    public static void main(String[] args) {
        // diffTwoLocalDate();
        // diffTwoLocalDateTime();
        useChronoUnitForDifference();
    }

    static void useChronoUnitForDifference() {
        LocalDateTime from = LocalDateTime.of(2020, 10, 4, 10, 20, 55);
        LocalDateTime to = LocalDateTime.of(2020, 11, 10, 10, 21, 1);

        long years = ChronoUnit.YEARS.between(from, to);
        long months = ChronoUnit.MONTHS.between(from, to);
        long weeks = ChronoUnit.WEEKS.between(from, to);
        long days = ChronoUnit.DAYS.between(from, to);
        long hours = ChronoUnit.HOURS.between(from, to);
        long minutes = ChronoUnit.MINUTES.between(from, to);
        long seconds = ChronoUnit.SECONDS.between(from, to);
        long milliseconds = ChronoUnit.MILLIS.between(from, to);
        long nano = ChronoUnit.NANOS.between(from, to);

        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(weeks + " weeks");
        System.out.println(days + " days");
        System.out.println(hours + " hours");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");
        System.out.println(milliseconds + " milliseconds");
        System.out.println(nano + " nano");
    }

    static void diffTwoLocalDateTime() {
        LocalDateTime from = LocalDateTime.of(2020, 10, 4, 10, 20, 55);
        LocalDateTime to = LocalDateTime.of(2020, 10, 10, 10, 21, 1);

        Duration duration = Duration.between(from, to);

        // days between from and to
        System.out.println(duration.toDays() + " days");

        // hours between from and to
        System.out.println(duration.toHours() + " hours");

        // minutes between from and to
        System.out.println(duration.toMinutes() + " minutes");

        // seconds between from and to
        System.out.println(duration.toSeconds() + " seconds");
        System.out.println(duration.getSeconds() + " seconds");
    }

    static void diffTwoLocalDate() {
        LocalDate from = LocalDate.of(2020, 5, 4);
        LocalDate to = LocalDate.of(2020, 10, 10);

        Period period = Period.between(from, to);

        System.out.print(period.getYears() + " years,");
        System.out.print(period.getMonths() + " months,");
        System.out.print(period.getDays() + " days");
    }
}
