package com.favtuts.time;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class DisplayTimeZoneList {

    private static Map<String, List> timeZones = new TreeMap();

    public static void main(String[] args) {
        //displayTimeZoneList();
        displayTimeZoneList2();
    }

    static void displayTimeZoneList2() {
        fulfillTimeZoneMap();
        timeZones.keySet().stream().sorted().forEach(k -> System.out.println(k + " " + timeZones.get(k)));
    }

    private static void fulfillTimeZoneMap() {
        for (var id : TimeZone.getAvailableIDs()) {
            var tz = TimeZone.getTimeZone(id);
            var hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
            var minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset()) - TimeUnit.HOURS.toMinutes(hours);
            minutes = Math.abs(minutes);
            if (hours > 0) {
                var zoneKey = String.format("GMT+%d:%02d", hours, minutes);
                var zoneList = Optional.ofNullable(timeZones.get(zoneKey)).orElse(new ArrayList());
                zoneList.add(tz.getID());
                timeZones.put(zoneKey, zoneList);
            } else {
                var zoneKey = String.format("GMT%d:%02d", hours, minutes);
                var zoneList = Optional.ofNullable(timeZones.get(zoneKey)).orElse(new ArrayList());
                zoneList.add(tz.getID());
                timeZones.put(zoneKey, zoneList);
            }
        }
    }

    static void displayTimeZoneList() {

        String[] ids = TimeZone.getAvailableIDs();
        for (String id : ids) {
            System.out.println(displayTimeZone(TimeZone.getTimeZone(id)));
        }

        System.out.println("\nTotal TimeZone ID " + ids.length);

    }

    private static String displayTimeZone(TimeZone tz) {

        long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
        long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
                - TimeUnit.HOURS.toMinutes(hours);
        // avoid -4:-30 issue
        minutes = Math.abs(minutes);

        String result = "";
        if (hours > 0) {
            result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
        } else {
            result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
        }

        return result;

    }
}
