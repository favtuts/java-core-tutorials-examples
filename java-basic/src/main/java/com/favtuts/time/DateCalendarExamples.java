package com.favtuts.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCalendarExamples {
    
    public static void main(String[] args) throws ParseException {
        //javaDateConvertDateToString();
        //javaDateConvertStringToDate();
        //javaDateGetCurrentDateTime();
        //javaDateConvertCalendarToDate();

        //javaCalendarGetCurrentDateTime();
        //javaCalendarSimpleCalendarExample();
        //javaCalendarSetDateManually();
        //javaCalendarAddOrSubstractDate();
        javaCalendarConvertDateToCalendar();
    }

    static void javaCalendarConvertDateToCalendar() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "22-01-2015 10:20:56";
        Date date = sdf.parse(dateInString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    static void javaCalendarAddOrSubstractDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
        Calendar calendar = new GregorianCalendar(2013,10,28);
        System.out.println("Date : " + sdf.format(calendar.getTime()));
        //add one month
        calendar.add(Calendar.MONTH, 1);
        System.out.println("Date : " + sdf.format(calendar.getTime()));
        //subtract 10 days
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        System.out.println("Date : " + sdf.format(calendar.getTime()));
    }

    static void javaCalendarSetDateManually() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
        System.out.println("#1. " + sdf.format(calendar.getTime()));
        //update a date
        calendar.set(Calendar.YEAR, 2014);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.MINUTE, 33);
        System.out.println("#2. " + sdf.format(calendar.getTime()));
    }

    static void javaCalendarSimpleCalendarExample() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
        int year       = calendar.get(Calendar.YEAR);
        int month      = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);
        int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute     = calendar.get(Calendar.MINUTE);
        int second     = calendar.get(Calendar.SECOND);
        int millisecond= calendar.get(Calendar.MILLISECOND);
        System.out.println(sdf.format(calendar.getTime()));
        System.out.println("year \t\t: " + year);
        System.out.println("month \t\t: " + month);
        System.out.println("dayOfMonth \t: " + dayOfMonth);
        System.out.println("dayOfWeek \t: " + dayOfWeek);
        System.out.println("weekOfYear \t: " + weekOfYear);
        System.out.println("weekOfMonth \t: " + weekOfMonth);
        System.out.println("hour \t\t: " + hour);
        System.out.println("hourOfDay \t: " + hourOfDay);
        System.out.println("minute \t\t: " + minute);
        System.out.println("second \t\t: " + second);
        System.out.println("millisecond \t: " + millisecond);
    }

    static void javaCalendarGetCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar(2013,0,31);
        System.out.println(sdf.format(calendar.getTime()));
    }

    static void javaDateConvertCalendarToDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date date =  calendar.getTime();
        System.out.println(dateFormat.format(date));
    }

    static void javaDateConvertDateToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());
        System.out.println(date); //15/10/2013
    }

    static void javaDateConvertStringToDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date = sdf.parse(dateInString);
        System.out.println(date); //Tue Aug 31 10:20:56 SGT 1982
    }

    static void javaDateGetCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2013/10/15 16:16:39
    }    
}
