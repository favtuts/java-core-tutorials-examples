package com.favtuts.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CurrentDateTime {

    private static final DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("uuuu/MM/dd");
    private static final DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter dtfDateTime = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");

    public static void main(String[] args) {
        // getCurrentDateTimeWithJavaTime();
        // getCurrentDateWithJavaTimeLocalDate();
        // getCurrentTimeWithJavaTimeLocalTime();
        // getCurrentDateTimeWithJavaTimeLocalDateTime();
        // getCurrentDateTimeWithJavaTimeZonedDateTime();
        // getCurrentDateTimeWithJavaTimeInstant();

        //getCurrentDateWithLegacyJavaUtilDate();
        getCurrentDateTimeWithJavaUtilCalendar();
    }    

    static void getCurrentDateTimeWithJavaTimeInstant() {

        // seconds passed since the Unix epoch time (midnight of January 1, 1970 UTC)
        Instant now = Instant.now();
        System.out.println(now.toEpochMilli());
        System.out.println(now.getEpochSecond());
        System.out.println(now);

        // convert Instant to LocalDate
        LocalDate localDate = LocalDate.ofInstant(now, ZoneId.systemDefault());
        System.out.println(dtfDate.format(localDate));

        // convert Instant to localTime
        LocalTime localTime = LocalTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(dtfTime.format(localTime));

        // convert Instant to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(dtfDateTime.format(localDateTime));

        // convert Instant to ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(dtfDateTime.format(zonedDateTime));

    }

    static void getCurrentDateTimeWithJavaTimeZonedDateTime() {

        // For java.time.ZonedDateTime, uses ZonedDateTime.now()

        // Get default time zone
        System.out.println(ZoneOffset.systemDefault()); // Asia/Kuala_Lumpur
        System.out.println(OffsetDateTime.now().getOffset()); // +08:00

        // get current date-time, with system default time zone
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(dtf.format(now)); // 2022/06/04 10:08:54
        System.out.println(now.getOffset()); // +07:00

        // get current date-time, with a specified time zone
        ZonedDateTime japanDateTime = now.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println(dtf.format(japanDateTime)); // 2022/06/04 12:08:54
        System.out.println(japanDateTime.getOffset()); // +09:00

        japanDateTime = now.withZoneSameInstant(ZoneId.of("Asia/Singapore"));
        System.out.println(dtf.format(japanDateTime)); // 2022/06/04 11:08:54
        System.out.println(japanDateTime.getOffset()); // +08:00

    }

    static void getCurrentDateTimeWithJavaTimeLocalDateTime() {

        // For java.time.LocalDateTime, uses LocalDateTime.now()
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now)); // 2022/06/04 10:04:09

    }

    static void getCurrentTimeWithJavaTimeLocalTime() {

        // For java.time.localTime, uses LocalTime.now()
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println(dtf.format(localTime)); // 16:37:15

    }

    static void getCurrentDateWithJavaTimeLocalDate() {

        // For java.time.LocalDate, uses LocalDate.now()
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        System.out.println(dtf.format(localDate)); // 2021/03/22

    }

    static void getCurrentDateWithLegacyJavaUtilDate() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date date = new Date();
        System.out.println(dateFormat.format(date)); // 2021/03/22 16:37:15

        // new Date() actually calls this new Date(long date)
        Date date2 = new Date(System.currentTimeMillis());
        System.out.println(dateFormat.format(date)); // 2021/03/22 16:37:15

    }

    static void getCurrentDateTimeWithJavaUtilCalendar() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));   // 2021/03/22 16:37:15

    }    
}
