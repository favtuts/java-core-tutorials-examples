package com.favtuts.time;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ElapsedTimeExecutionTime {

    public static void main(String[] args) throws InterruptedException {
        // measuredElapsedTimeWithSystemNanoTime();
        // measuredElapsedTimeWithSystemCurrentTimeMillis();
        // measuredElapsedTimeWithInstantNowToEpochMilli();
        measuredElapsedTimeWithDateGetTime();
    }
    
    static void measuredElapsedTimeWithDateGetTime() throws InterruptedException {
        long lStartTime = new Date().getTime();

        calculation();

        long lEndTime = new Date().getTime();

        long output = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds: " + output);
    }

    static void measuredElapsedTimeWithInstantNowToEpochMilli() throws InterruptedException {
        long lStartTime = Instant.now().toEpochMilli();

        calculation();

        long lEndTime = Instant.now().toEpochMilli();

        long output = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds: " + output);
    }

    static void measuredElapsedTimeWithSystemCurrentTimeMillis() throws InterruptedException {
        long lStartTime = System.currentTimeMillis();

        calculation();

        long lEndTime = System.currentTimeMillis();

        long output = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds: " + output);
    }

    static void measuredElapsedTimeWithSystemNanoTime() throws InterruptedException {
        // start
        long lStartTime = System.nanoTime();

        // task
        calculation();

        // end
        long lEndTime = System.nanoTime();

        // time elapsed
        long output = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
    }

    private static void calculation() throws InterruptedException {

        // Sleep 2 seconds
        TimeUnit.SECONDS.sleep(2);

    }
}
