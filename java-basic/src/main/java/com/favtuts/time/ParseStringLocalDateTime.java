package com.favtuts.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseStringLocalDateTime {

    public static void main(String[] args) {
        // parseStringyyyyMMddHHmmss();
        // parseDateDefaultLocaleUS();
        // parseDateFailedWithLocaleChina();
        parseDateSuccessWithLocaleChina();
    }

    static void parseDateSuccessWithLocaleChina() {
        Locale.setDefault(Locale.CHINA);

        String str = "31-Aug-2020";

        // don't care about the JVM default locale, we use Locale.US to parse date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.US);

        // String -> LocalDateTime
        LocalDateTime localDateTime = LocalDate.parse(str, dtf).atStartOfDay();

        // LocalDateTime -> String
        String result = localDateTime.format(dtf);

        System.out.println(result);
    }

    static void parseDateFailedWithLocaleChina() {
        Locale.setDefault(Locale.CHINA);
        String str = "31-Aug-2020";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        LocalDateTime localDateTime = LocalDate.parse(str, dtf).atStartOfDay();
    }

    static void parseDateDefaultLocaleUS() {
        // default jvm locale
        System.out.println(Locale.getDefault()); // en_US

        String str = "31-Aug-2020";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-MMM-yyyy");

        // String -> LocalDateTime
        LocalDateTime localDateTime = LocalDate.parse(str, dtf).atStartOfDay();

        // LocalDateTime -> String
        String result = localDateTime.format(dtf);

        System.out.println(result);
    }

    static void parseStringyyyyMMddHHmmss() {
        String str = "2020-01-30 12:30:41";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // String -> LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(str, dtf);

        // LocalDateTime -> String
        String result = localDateTime.format(dtf);

        System.out.println(result);
    }
}
