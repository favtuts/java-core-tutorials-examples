package com.favtuts.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CheckDateOlderThan {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {
        // useJava8isBeforeWithMinusMonth();
        // useJava8isBeforeWithMinusDay();
        // useJava8ChronoUnitMONTHS();
        // useJava8ChronoUnitDAYS();

        // explorerJava8PeriodBetween();
        // useJava8PeriodToCheckOlderThan();

        // useLegacyCalendarCheckMonth();
        useLegacyDateToChec30Days();
    }

    static void useLegacyDateToChec30Days() throws ParseException {
        Date today = new Date();
        System.out.println("now : " + sdf.format(today));         // 2021-03-26

        Calendar thirtyDaysAgo = Calendar.getInstance();
        thirtyDaysAgo.add(Calendar.DAY_OF_MONTH, -30);            // 2021-02-24

        // convert Calendar to Date
        Date thirtyDaysAgoDate = thirtyDaysAgo.getTime();
        System.out.println("thirtyDaysAgo : " + sdf.format(thirtyDaysAgoDate));

        Date date1 = sdf.parse("2019-12-31");
        if (date1.before(thirtyDaysAgoDate)) {
            System.out.println("30 days older than current date!");
        }

    }

    static void useLegacyCalendarCheckMonth() {
        Calendar sixMonthsAgo = Calendar.getInstance();
        // Current date
        // 2021-03-26
        System.out.println("now: " + sdf.format(sixMonthsAgo.getTime()));

        // old way to minus 6 months
        // 2020-09-26
        sixMonthsAgo.add(Calendar.MONTH, -6);
        System.out.println("sixMonthsAgo: " + sdf.format(sixMonthsAgo.getTime()));

        // 2019-06-10
        Calendar date1 = new GregorianCalendar(2020, Calendar.AUGUST, 10);
        System.out.println("date1: " + sdf.format(date1.getTime()));

        if (date1.before(sixMonthsAgo)) {
            System.out.println("6 months older than current date!");
        }
    }

    static void useJava8PeriodToCheckOlderThan() {
        LocalDate date1 = LocalDate.of(2020, 9, 25);
        System.out.println("Is 6 months older? " + isOlderThanMonths(date1, 6));

        LocalDate date2 = LocalDate.of(2020, 9, 26);
        System.out.println("Is 6 months older? " + isOlderThanMonths(date2, 6));

        LocalDate date3 = LocalDate.of(2021, 12, 26);
        System.out.println("Is 6 months older? " + isOlderThanMonths(date3, 6));

        LocalDate date4 = LocalDate.of(2001, 10, 26);
        System.out.println("Is 6 months older? " + isOlderThanMonths(date4, 6));
    }

    static boolean isOlderThanMonths(final LocalDate date, final int months) {

        boolean result = false;

        LocalDate now = LocalDate.now();
        // period from now to date
        Period period = Period.between(now, date);

        System.out.println("\nNow: " + now);
        System.out.println("Date: " + date);
        System.out.printf("%d years, %d months, %d days%n",
                period.getYears(), period.getMonths(), period.getDays());

        if (period.getYears() < 0) {
            // if year is negative, 100% older than 6 months
            result = true;
        } else if (period.getYears() == 0) {
            if (period.getMonths() <= -months) {
                result = true;
            }
        }

        return result;

    }

    static void explorerJava8PeriodBetween() {
        LocalDate date1 = LocalDate.of(2020, 2, 24);
        LocalDate date2 = LocalDate.of(2019, 8, 23);

        System.out.println(date1); // 2020-02-24
        System.out.println(date2); // 2019-08-23

        Period period = Period.between(date1, date2);
        String result = String.format("%d years, %d months, %d days",
                period.getYears(), period.getMonths(), period.getDays());

        System.out.println(result); // 0 years, -6 months, -1 days

        LocalDate date3 = LocalDate.of(2019, 1, 1);
        LocalDate date4 = LocalDate.of(2021, 3, 23);

        System.out.println(date3); // 2019-01-01
        System.out.println(date4); // 2021-03-23

        Period period2 = Period.between(date3, date4);
        String result2 = String.format("%d years, %d months, %d days",
                period2.getYears(), period2.getMonths(), period2.getDays());

        System.out.println(result2); // 2 years, 2 months, 22 days
    }

    static void useJava8ChronoUnitDAYS() {
        LocalDate now = LocalDate.now(); // 2021-03-26
        System.out.println("now: " + now);

        LocalDate date1 = LocalDate.of(2019, 9, 25);

        long day1 = ChronoUnit.DAYS.between(now, date1);
        System.out.println(date1);
        System.out.println(day1);

        if (day1 <= -30) {
            System.out.println("30 days older than current date!");
        }

        LocalDate date2 = LocalDate.of(2022, 05, 25);
        long day2 = ChronoUnit.DAYS.between(now, date2);
        System.out.println(date2);
        System.out.println(day2);
        if (day2 <= -30) {
            System.out.println("30 days older than current date!");
        }
    }

    static void useJava8ChronoUnitMONTHS() {
        LocalDate now = LocalDate.now(); // 2021-03-26
        System.out.println("now: " + now);

        LocalDate date1 = LocalDate.of(2019, 9, 25);

        long months = ChronoUnit.MONTHS.between(now, date1);
        System.out.println(date1);
        System.out.println(months);

        if (months <= -6) {
            System.out.println("6 months older than current date!");
        }

        LocalDate date2 = LocalDate.of(2020, 9, 26);
        long months2 = ChronoUnit.MONTHS.between(now, date2);
        System.out.println(date2);
        System.out.println(months2);
        if (months2 <= -6) {
            System.out.println("6 months older than current date!");
        }
    }

    static void useJava8isBeforeWithMinusDay() {
        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus30Days = currentDate.minusDays(30);

        // 2021-03-26
        System.out.println("currentDate: " + currentDate);

        // 2020-09-26
        System.out.println("currentDateMinus30Days : " + currentDateMinus30Days);

        // LocalDate date1 = LocalDate.of(2019, 8, 23);
        LocalDate date1 = LocalDate.of(2022, 05, 05);
        System.out.println("\ndate1 : " + date1);
        if (date1.isBefore(currentDateMinus30Days)) {
            System.out.println("30 days older than current date!");
        }
    }

    static void useJava8isBeforeWithMinusMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus6Months = currentDate.minusMonths(6);

        // 2021-03-26
        System.out.println("currentDate: " + currentDate);

        // 2020-09-26
        System.out.println("currentDateMinus6Months : " + currentDateMinus6Months);

        // LocalDate date1 = LocalDate.of(2019, 8, 23);
        LocalDate date1 = LocalDate.of(2021, 11, 23);
        System.out.println("\ndate1 : " + date1);
        if (date1.isBefore(currentDateMinus6Months)) {
            System.out.println("6 months older than current date!");
        }
    }
}
