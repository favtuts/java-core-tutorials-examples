package com.favtuts.time;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeToTimestamp {
    
    public static void main(String[] args) {
        //convertZonedDateTimeToSqlTimestamp();
        convertSqlTimestampToZonedDateTime();
    }

    static void convertSqlTimestampToZonedDateTime() {
        Timestamp timestamp = Timestamp.from(Instant.now());

        LocalDateTime localDateTimeNoTimeZone = timestamp.toLocalDateTime();

        ZonedDateTime zonedDateTime1 = localDateTimeNoTimeZone.atZone(ZoneId.of("+08:00"));

        ZonedDateTime zonedDateTime2 = localDateTimeNoTimeZone.atZone(ZoneId.of("Asia/Kuala_Lumpur"));

        ZonedDateTime zonedDateTime3 = localDateTimeNoTimeZone.atZone(ZoneId.systemDefault());

        ZonedDateTime zonedDateTime4 = localDateTimeNoTimeZone.atZone(ZoneId.of("-08:00"));

        System.out.println(timestamp);      // 2019-06-19 14:08:23.4458984

        System.out.println(zonedDateTime1); // 2019-06-19T14:08:23.445898400+08:00

        System.out.println(zonedDateTime2); // 2019-06-19T14:08:23.445898400+08:00[Asia/Kuala_Lumpur]

        System.out.println(zonedDateTime3); // 2019-06-19T14:08:23.445898400+08:00[Asia/Kuala_Lumpur]

        System.out.println(zonedDateTime4); // 2019-06-19T14:08:23.445898400-08:00
    }

    static void convertZonedDateTimeToSqlTimestamp() {
        ZonedDateTime now = ZonedDateTime.now();

        // 1. ZonedDateTime to TimeStamp
        Timestamp timestamp = Timestamp.valueOf(now.toLocalDateTime());

        // 2. ZonedDateTime to TimeStamp , no different
        Timestamp timestamp2 = Timestamp.from(now.toInstant());

        System.out.println(now);		// 2019-06-19T14:12:13.585294800+08:00[Asia/Kuala_Lumpur]

        System.out.println(timestamp);	// 2019-06-19 14:12:13.5852948

        System.out.println(timestamp2);	// 2019-06-19 14:12:13.5852948
    }
}
