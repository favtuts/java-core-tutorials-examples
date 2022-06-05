package com.favtuts.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

public class DisplayZoneAndOffSet {

    public static final boolean SORT_BY_REGION = false;

    public static void main(String[] args) {
        // displayZoneIdandOffset();
        // displayZoneIdandOffsetReducedVersion();
        displayZoneIdandOffsetReducedVersion2();
    }

    static void displayZoneIdandOffsetReducedVersion2() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Map<String, String> result = ZoneId.getAvailableZoneIds()
                .stream()
                .map(ZoneId::of)
                .map(zoneId -> new SimpleEntry<>(zoneId.toString(), localDateTime.atZone(zoneId)
                        .getOffset()
                        .getId()
                        .replaceAll("Z", "+00:00")))
                .sorted(SORT_BY_REGION
                        ? Map.Entry.comparingByKey()
                        : Map.Entry.<String, String>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        SimpleEntry::getKey,
                        SimpleEntry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        result.forEach((k, v) -> System.out.printf(String.format("%35s (UTC%s) %n", k, v)));

        System.out.println("\nTotal Zone IDs " + result.size());
    }

    static void displayZoneIdandOffsetReducedVersion() {
        LocalDateTime localDateTime = LocalDateTime.now();

        long total = ZoneId.getAvailableZoneIds()
                .stream()
                .map(ZoneId::of)
                .map(zoneId -> new SimpleEntry<>(zoneId.toString(), localDateTime.atZone(zoneId)
                        .getOffset()
                        .getId()
                        .replaceAll("Z", "+00:00")))
                .sorted(SORT_BY_REGION
                        ? Map.Entry.comparingByKey()
                        : Map.Entry.<String, String>comparingByValue().reversed())
                .peek(e -> System.out.printf(String.format("%35s (UTC%s) %n", e.getKey(), e.getValue())))
                .count();

        System.out.println("\nTotal Zone IDs " + total);
    }

    static void displayZoneIdandOffset() {

        Map<String, String> sortedMap = new LinkedHashMap<>();

        Map<String, String> allZoneIdsAndItsOffSet = getAllZoneIdsAndItsOffSet();

        // sort map by key
        if (SORT_BY_REGION) {
            allZoneIdsAndItsOffSet.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
        } else {
            // sort by value, descending order
            allZoneIdsAndItsOffSet.entrySet().stream()
                    .sorted(Map.Entry.<String, String>comparingByValue().reversed())
                    .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
        }

        // print map
        sortedMap.forEach((k, v) -> {
            String out = String.format("%35s (UTC%s) %n", k, v);
            System.out.printf(out);
        });

        System.out.println("\nTotal Zone IDs " + sortedMap.size());
    }

    private static Map<String, String> getAllZoneIdsAndItsOffSet() {

        Map<String, String> result = new HashMap<>();

        LocalDateTime localDateTime = LocalDateTime.now();

        for (String zoneId : ZoneId.getAvailableZoneIds()) {

            ZoneId id = ZoneId.of(zoneId);

            // LocalDateTime -> ZonedDateTime
            ZonedDateTime zonedDateTime = localDateTime.atZone(id);

            // ZonedDateTime -> ZoneOffset
            ZoneOffset zoneOffset = zonedDateTime.getOffset();

            // replace Z to +00:00
            String offset = zoneOffset.getId().replaceAll("Z", "+00:00");

            result.put(id.toString(), offset);

        }

        return result;

    }
}
