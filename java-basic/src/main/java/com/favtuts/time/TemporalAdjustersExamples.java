package com.favtuts.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersExamples {
    
    public static void main(String[] args) {
        //demoTemporalAdjusters();
        demoCustomTemporalAdjuster();
    }

    static void demoCustomTemporalAdjuster() {
        LocalDate localDate = LocalDate.now();
        System.out.println("current date : " + localDate);

        localDate = localDate.with(new NextChristmasAdjuster());
        System.out.println("Next Christmas : " + localDate);
    }

    static void demoTemporalAdjusters() {
        LocalDate localDate = LocalDate.now();
        System.out.println("current date : " + localDate);

        LocalDate with = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfMonth : " + with);

        LocalDate with1 = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfMonth : " + with1);

        LocalDate with2 = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("next monday : " + with2);

        LocalDate with3 = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("firstDayOfNextMonth : " + with3);
    }
}
