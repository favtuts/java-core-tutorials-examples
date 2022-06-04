package com.favtuts.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class StringToDateExamples {
    
    public static void main(String[] args) {
        // formatMonthWith3M(); 
        // formatMonthWith2M();
        // formatDateWithWeekDay();
        // formatDatetimeWithWeekDay();

        //formatDatetimeUTC();
        formatDatetimeUTCWithInstant();
    }

    static void formatDatetimeUTCWithInstant() {
        String dateInString = "2014-10-05T15:23:01Z";

        Instant instant = Instant.parse(dateInString);

        System.out.println(instant);

        //get date time only
        LocalDateTime result = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));

        System.out.println(result);

        //get date time + timezone
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Africa/Tripoli"));
        System.out.println(zonedDateTime);

        //get date time + timezone
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
        System.out.println(zonedDateTime2);

    }

    static void formatDatetimeUTC() {
        // Z suffix means UTC, java.util.SimpleDateFormat doesn’t parse it correctly, 
        // you need to replace the suffix Z with ‘+0000’.
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        //String dateInString = "2014-10-05T23:23:01Z";  // -> 2014-10-06T06:23:01+0700
        String dateInString = "2014-10-05T15:23:01Z";  // -> 2014-10-05T22:23:01+0700

        try {

            Date date = formatter.parse(dateInString.replaceAll("Z$", "+0000"));
            System.out.println(date);

            System.out.println("time zone : " + TimeZone.getDefault().getID());
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static void formatDatetimeWithWeekDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
        String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static void formatDateWithWeekDay() {
        SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
        String dateInString = "Fri, June 7 2013";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static void formatMonthWith2M() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "07/06/2013";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static void formatMonthWith3M() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2013";

        try {
            Date date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
