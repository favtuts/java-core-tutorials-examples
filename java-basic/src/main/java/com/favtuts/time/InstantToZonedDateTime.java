package com.favtuts.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantToZonedDateTime {

    public static void main(String[] args) {
        // convertInstantToZonedDateTime();
        convertZonedDateTimeToInstant();
    }

    static void convertZonedDateTimeToInstant() {
        LocalDateTime dateTime = LocalDateTime.of(2016, Month.AUGUST, 18, 6, 57, 38);

        // UTC+9
        ZonedDateTime jpTime = dateTime.atZone(ZoneId.of("Asia/Tokyo"));

        System.out.println("ZonedDateTime : " + jpTime);

        // Convert to instant UTC+0/Z , java.time helps to reduce 9 hours
        Instant instant = jpTime.toInstant();

        System.out.println("Instant : " + instant);
    }

    static void convertInstantToZonedDateTime() {
        // Z = UTC+0
        Instant instant = Instant.now();

        System.out.println("Instant : " + instant);

        // Japan = UTC+9
        ZonedDateTime jpTime = instant.atZone(ZoneId.of("Asia/Tokyo"));

        System.out.println("ZonedDateTime JP: " + jpTime);

        System.out.println("OffSet JP: " + jpTime.getOffset());

        // Vietnam = UTC+7
        ZonedDateTime vnTime = instant.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));

        System.out.println("ZonedDateTime VN: " + vnTime);

        System.out.println("OffSet VN: " + vnTime.getOffset());

    }
}
