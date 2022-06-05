package com.favtuts.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDateWithoutTime {
    
    public static void main(String[] args) {
        //parseDateFailed();
        parseDateSuccess();
    }

    static void parseDateSuccess() {
        String str = "31-Aug-2020";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.US);
      
        LocalDateTime localDateTime = LocalDate.parse(str, dtf).atStartOfDay();

        System.out.println(localDateTime);
    }

    static void parseDateFailed() {
        String str = "31-Aug-2020";

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.US);

        LocalDateTime localDateTime = LocalDateTime.parse(str, dtf);

        System.out.println(localDateTime);
    }
}
