package com.favtuts.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatExamples {

    // date format 1
    private static final DateTimeFormatter dateFormatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    // date format 2
    private static final DateTimeFormatter dateFormatterNew = 
        DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");

    
    private static final SimpleDateFormat sdf = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    private static final SimpleDateFormat sdfNew = 
		new SimpleDateFormat("EEEE, MMM d, yyyy HH:mm:ss a");

    public static void main(String[] args) {
        // changeDateFormatWithDateTimeFormatter();
        changeDateFormatWithSimpleDateFormat();
    }

    static void changeDateFormatWithSimpleDateFormat() {
        String dateString = "2019-05-23 00:00:00.0";

        try {

			// string to date
            Date date = sdf.parse(dateString);

            System.out.println(sdf.format(date));
			
            System.out.println(sdfNew.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static void changeDateFormatWithDateTimeFormatter() {
        String date = "2019-05-23 00:00:00.0";

		// string to LocalDateTime
        LocalDateTime ldateTime = LocalDateTime.parse(date, dateFormatter);

        System.out.println(dateFormatter.format(ldateTime));

        // change date format
        System.out.println(dateFormatterNew.format(ldateTime));
    }
}
