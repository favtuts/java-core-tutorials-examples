package com.favtuts.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CompareDateExamples {

    public static void main(String[] args) throws ParseException {
        // compareLegacyDateWithCompareTo();
        // compareDateWithFriendlyMethods();
        // compareDateWithinRange();
        // compareTwoCalendar();
        // compareTwoLocalDate();
        // compareTwoLocalDateTime();
        // compareTwoInstant();
        // compareLocalDateWithinRange();
        checkLocalDateOlderThan6Months();
    }

    static void checkLocalDateOlderThan6Months() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");

        LocalDate now = LocalDate.parse("2020-01-01", dtf);
        LocalDate date1 = LocalDate.parse("2020-07-01", dtf);

        System.out.println("now: " + now);
        System.out.println("date1: " + date1);

        // add 6 months
        LocalDate nowPlus6Months = now.plusMonths(6);
        System.out.println("nowPlus6Months: " + nowPlus6Months);

        System.out.println("If date1 older than 6 months?");

        // if want to exclude the 2020-07-01, remove the isEqual
        if (date1.isAfter(nowPlus6Months) || date1.isEqual(nowPlus6Months)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static void compareLocalDateWithinRange() throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");

        LocalDate startDate = LocalDate.parse("2020-01-01", dtf);
        LocalDate endDate = LocalDate.parse("2020-01-31", dtf);

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);

        LocalDateRangeValidator checker = new LocalDateRangeValidator(startDate, endDate);

        LocalDate testDate = LocalDate.parse("2020-01-01", dtf);
        System.out.println("\ntestDate : " + testDate);

        if (checker.isWithinRange(testDate)) {
            System.out.println("testDate is within the date range.");
        } else {
            System.out.println("testDate is NOT within the date range.");
        }
    }

    static void compareTwoInstant() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

        LocalDateTime date1 = LocalDateTime.parse("2020-01-31 11:44:44", dtf);
        LocalDateTime date2 = LocalDateTime.parse("2020-01-31 11:44:44", dtf);

        // convert LocalDateTime to Instant
        Instant instant1 = date1.toInstant(ZoneOffset.UTC);
        Instant instant2 = date2.toInstant(ZoneOffset.UTC);

        // compare getEpochSecond
        if (instant1.getEpochSecond() == instant2.getEpochSecond()) {
            System.out.println("instant1 is equal instant2");
        }

        if (instant1.getEpochSecond() < instant2.getEpochSecond()) {
            System.out.println("instant1 is before instant2");
        }

        if (instant1.getEpochSecond() > instant2.getEpochSecond()) {
            System.out.println("instant1 is after instant2");
        }

        // compare with APIs
        if (instant1.equals(instant2)) {
            System.out.println("instant1 is equal instant2");
        }

        if (instant1.isBefore(instant2)) {
            System.out.println("instant1 is before instant2");
        }

        if (instant1.isAfter(instant2)) {
            System.out.println("instant1 is after instant2");
        }
    }

    static void compareTwoLocalDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

        LocalDateTime date1 = LocalDateTime.parse("2020-01-31 11:44:43", dtf);
        LocalDateTime date2 = LocalDateTime.parse("2020-01-31 11:44:44", dtf);

        System.out.println("date1 : " + date1);
        System.out.println("date2 : " + date2);

        if (date1.isEqual(date2)) {
            System.out.println("Date1 is equal Date2");
        }

        if (date1.isBefore(date2)) {
            System.out.println("Date1 is before Date2");
        }

        if (date1.isAfter(date2)) {
            System.out.println("Date1 is after Date2");
        }
    }

    static void compareTwoLocalDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");

        LocalDate date1 = LocalDate.parse("2020-02-01", dtf);
        LocalDate date2 = LocalDate.parse("2020-01-31", dtf);

        System.out.println("date1 : " + date1);
        System.out.println("date2 : " + date2);

        if (date1.isEqual(date2)) {
            System.out.println("Date1 is equal Date2");
        }

        if (date1.isBefore(date2)) {
            System.out.println("Date1 is before Date2");
        }

        if (date1.isAfter(date2)) {
            System.out.println("Date1 is after Date2");
        }

        // test compareTo
        if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 is after Date2");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 is before Date2");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 is equal to Date2");
        } else {
            System.out.println("How to get here?");
        }
    }

    static void compareTwoCalendar() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2020-02-01");
        Date date2 = sdf.parse("2020-01-31");

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (cal1.after(cal2)) {
            System.out.println("Date1 is after Date2");
        }

        if (cal1.before(cal2)) {
            System.out.println("Date1 is before Date2");
        }

        if (cal1.equals(cal2)) {
            System.out.println("Date1 is equal Date2");
        }
    }

    static void compareDateWithinRange() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate = sdf.parse("2020-01-01");
        Date endDate = sdf.parse("2020-01-31");

        System.out.println("startDate : " + sdf.format(startDate));
        System.out.println("endDate : " + sdf.format(endDate));

        DateRangeValidator checker = new DateRangeValidator(startDate, endDate);

        Date testDate = sdf.parse("2020-01-01");
        System.out.println("testDate : " + sdf.format(testDate));

        if (checker.isWithinRange(testDate)) {
            System.out.println("testDate is within the date range.");
        } else {
            System.out.println("testDate is NOT within the date range.");
        }
    }

    static void compareDateWithFriendlyMethods() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Date date1 = sdf.parse("2009-12-31");
        Date date1 = sdf.parse("2020-02-01");
        Date date2 = sdf.parse("2020-01-31");

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.equals(date2)) {
            System.out.println("Date1 is equal Date2");
        }

        if (date1.after(date2)) {
            System.out.println("Date1 is after Date2");
        }

        if (date1.before(date2)) {
            System.out.println("Date1 is before Date2");
        }
    }

    static void compareLegacyDateWithCompareTo() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2020-01-30");
        Date date2 = sdf.parse("2020-01-31");

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        int result = date1.compareTo(date2);
        System.out.println("result: " + result);

        if (result == 0) {
            System.out.println("Date1 is equal to Date2");
        } else if (result > 0) {
            System.out.println("Date1 is after Date2");
        } else if (result < 0) {
            System.out.println("Date1 is before Date2");
        } else {
            System.out.println("How to get here?");
        }
    }
}
