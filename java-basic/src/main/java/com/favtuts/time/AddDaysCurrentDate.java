package com.favtuts.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class AddDaysCurrentDate {

    // private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd
    // HH:mm:ss");

    private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static void main(String[] args) {
        //useLegacyCalendarToAddDays();
        useJava8PlusAndMinusMethods();
    }

    static void useJava8PlusAndMinusMethods() {
        // Get current date
        Date currentDate = new Date();
        System.out.println("date : " + dateFormat.format(currentDate));

        // convert date to localdatetime
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("localDateTime : " + dateFormat8.format(localDateTime));

        // plus one
        localDateTime = localDateTime.plusYears(1).plusMonths(1).plusDays(1);
        localDateTime = localDateTime.plusHours(1).plusMinutes(2).minusMinutes(1).plusSeconds(1);

        // convert LocalDateTime to date
        Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println("\nOutput : " + dateFormat.format(currentDatePlusOneDay));
    }

    static void useLegacyCalendarToAddDays() {
        Date currentDate = new Date();
        System.out.println(dateFormat.format(currentDate));

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, 1); // same with c.add(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.HOUR, 1);
        c.add(Calendar.MINUTE, 1);
        c.add(Calendar.SECOND, 1);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();

        System.out.println(dateFormat.format(currentDatePlusOne));
    }
}
