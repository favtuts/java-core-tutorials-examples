package com.favtuts.time;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeExamples {

    public static void main(String[] args) {
        // convertLocalDateTimetoZonedDateTime();
        // flightDetailFromMalaysiaToTokyo();
        flightDetailFromFranceParisToNewYork();
    }

    static void flightDetailFromFranceParisToNewYork() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM uuuu");

        // Convert String to LocalDateTime
        String date = "2016-08-22 14:30";
        LocalDateTime ldt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm"));
        System.out.println("LocalDateTime : " + format.format(ldt));

        // Paris, 2016 Apr-Oct = DST, UTC+2, other months UTC+1
        // UTC+2
        ZonedDateTime parisDateTime = ldt.atZone(ZoneId.of("Europe/Paris"));
        System.out.println("Depart : " + format.format(parisDateTime));

        // hard code a zoneoffset like this, UTC-5
        ZoneOffset nyOffSet = ZoneOffset.of("-05:00");
        ZonedDateTime nyDateTime = parisDateTime.withZoneSameInstant(nyOffSet).plusHours(8).plusMinutes(10);
        System.out.println("Arrive : " + format.format(nyDateTime));

        System.out.println("\n---Detail---");
        System.out.println("Depart : " + parisDateTime);
        System.out.println("Arrive : " + nyDateTime);
    }

    static void flightDetailFromMalaysiaToTokyo() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM uuuu");

        LocalDateTime ldt = LocalDateTime.of(2016, Month.AUGUST, 22, 14, 30);
        System.out.println("LocalDateTime : " + format.format(ldt));

        // UTC+8
        ZonedDateTime klDateTime = ldt.atZone(ZoneId.of("Asia/Kuala_Lumpur"));
        System.out.println("Depart : " + format.format(klDateTime));

        // UTC+9 and flight duration = 7 hours
        ZonedDateTime japanDateTime = klDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plusHours(7);
        System.out.println("Arrive : " + format.format(japanDateTime));

        System.out.println("\n---Detail---");
        System.out.println("Depart : " + klDateTime);
        System.out.println("Arrive : " + japanDateTime);
    }

    static void convertLocalDateTimetoZonedDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("ZoneId.systemDefault(): " + ZoneId.systemDefault());

        // convert LocalDateTime to ZonedDateTime, with default system zone id
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());

        // convert LocalDateTime to ZonedDateTime, with specified zoneId
        ZonedDateTime europeDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Kaliningrad"));
        System.out.println(europeDateTime);

        // convert LocalDateTime to ZonedDateTime, with specified off set
        ZonedDateTime offSetNegative5 = now.atOffset(ZoneOffset.of("-05:00")).toZonedDateTime();
        System.out.println(offSetNegative5);

        // display all zone ids
        // ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
