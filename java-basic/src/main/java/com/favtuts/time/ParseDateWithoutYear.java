package com.favtuts.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class ParseDateWithoutYear {

    public static void main(String[] args) {
        //parseDateFailed();
        parseDateSuccess();
    }

    static void parseDateSuccess() {
        //DateTimeFormatterBuilder to provide a default year for the date parsing
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd MMM")
                .parseDefaulting(ChronoField.YEAR, 2020)
                .toFormatter(Locale.US);

        String date = "02 Jan";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(formatter.format(localDate));
    }

    static void parseDateFailed() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM", Locale.US);

        String date = "02 Jan";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(formatter.format(localDate));
    }
}