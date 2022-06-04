package com.favtuts.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class StringToLocalDateExamples {
    
    public static void main(String[] args) {
        //parseStringISOLOCALDATEformat();
        //parseStringLocaleEnglish();
        //parseStringFailedWithLocaleFrance();
        //parseStringSuccessWithLocaleFrance();

        //parseStringDMMYYYYformat();
        //parseStringEMMMdyyyyFormat();
        //parseStringEEEEMMMdyyyyhhmmssa();
        //parseStringUTCwithInstantZonedDateTime();
        //parseStringISODATETIMEwithZonedDateTime();
        parseStringThrowDateTimeParseException();
    }

    static void parseStringThrowDateTimeParseException() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.US);
        try {
            LocalDate localDate = LocalDate.parse("16-ABC-2016", dtf);
            System.out.println(dtf.format(localDate));
        } catch (DateTimeParseException e) {
            System.err.println("Unable to parse the date!");
            //e.printStackTrace();
        }
    }

    static void parseStringISODATETIMEwithZonedDateTime() {
        String date = "2016-08-16T10:15:30+08:00";

        ZonedDateTime result = ZonedDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        System.out.println("ZonedDateTime : " + result);

        System.out.println("TimeZone : " + result.getZone());

        LocalDate localDate = result.toLocalDate();

        System.out.println("LocalDate : " + localDate);
    }

    static void parseStringUTCwithInstantZonedDateTime() {
        String dateInString = "2016-08-16T15:23:01Z";

        Instant instant = Instant.parse(dateInString);

        System.out.println("Instant : " + instant);

        //get date time only
        LocalDateTime result = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));

        //get localdate
        System.out.println("LocalDate : " + result.toLocalDate());

        //get date time + timezone
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime);

        //get date time + timezone
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
        System.out.println(zonedDateTime2);
    }

    static void parseStringEEEEMMMdyyyyhhmmssa() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a", Locale.US);

        String date = "Tuesday, Aug 16, 2016 12:10:56 PM";

        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);

        System.out.println(localDateTime);

        System.out.println(formatter.format(localDateTime));
    }

    static void parseStringEMMMdyyyyFormat() {
         // define a locale which understand English words, refer example 2 bug
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d yyyy", Locale.US);

         String date = "Tue, Aug 16 2016";
 
         LocalDate localDate = LocalDate.parse(date, formatter);
 
         System.out.println(localDate);
 
         System.out.println(formatter.format(localDate));
    }

    static void parseStringDMMYYYYformat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        String date = "16/08/2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(formatter.format(localDate));
    }

    static void parseStringSuccessWithLocaleFrance() {
        Locale.setDefault(Locale.FRANCE);

        // no problem now, DateTimeFormatter always uses Locale.US
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.US);

        String date = "16-Aug-2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);  //default, print ISO_LOCAL_DATE

        System.out.println(formatter.format(localDate)); // print formatted date
    }

    static void parseStringFailedWithLocaleFrance() {

        // not all default locale is Locale.US
        // simulate a France locale.
        Locale.setDefault(Locale.FRANCE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

        String date = "16-Aug-2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);  //default, print ISO_LOCAL_DATE

        System.out.println(formatter.format(localDate)); // print formatter date
    }

    static void parseStringLocaleEnglish() {
        //running fine only if the default locale understands English        
        System.out.println(Locale.getDefault()); // en_US

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

        String date = "16-Aug-2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);  //default, print ISO_LOCAL_DATE

        System.out.println(formatter.format(localDate)); // print formatter date
    }

    static void parseStringISOLOCALDATEformat() {
        String date = "2016-08-16";

        //default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);

        System.out.println(localDate);
    }
}
