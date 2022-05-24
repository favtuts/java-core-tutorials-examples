package com.favtuts.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8TestListMap {

    public static void main(String[] args) {
        //testListToMap();
        //testListToMapDuplicatedKey();
        sortListToMap();
    }

    private static void testListToMap() {
        List<HostingSite> list = new ArrayList<>();
        list.add(new HostingSite(1, "liquidweb.com", 80000));
        list.add(new HostingSite(2, "linode.com", 90000));
        list.add(new HostingSite(3, "digitalocean.com", 120000));
        list.add(new HostingSite(4, "aws.amazon.com", 200000));
        list.add(new HostingSite(5, "favtuts.com", 1));

        // key = id, value - websites
        Map<Integer, String> result1 = list.stream().collect(
                Collectors.toMap(HostingSite::getId, HostingSite::getName));

        System.out.println("Result 1 : " + result1);

        // key = name, value - websites
        Map<String, Long> result2 = list.stream().collect(
                Collectors.toMap(HostingSite::getName, HostingSite::getWebsites));

        System.out.println("Result 2 : " + result2);

        // Same with result1, just different syntax
        // key = id, value = name
        Map<Integer, String> result3 = list.stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println("Result 3 : " + result3);
    }

    private static void testListToMapDuplicatedKey() {
        List<HostingSite> list = new ArrayList<>();
        list.add(new HostingSite(1, "liquidweb.com", 80000));
        list.add(new HostingSite(2, "linode.com", 90000));
        list.add(new HostingSite(3, "digitalocean.com", 120000));
        list.add(new HostingSite(4, "aws.amazon.com", 200000));
        list.add(new HostingSite(5, "favtuts.com", 1));
		
        list.add(new HostingSite(6, "linode.com", 100000)); // new line

        // key = name, value - websites , but the key 'linode' is duplicated!?
        /*
        Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(HostingSite::getName, HostingSite::getWebsites));
        */

        // To solve the duplicated key issue above, 
        // pass in the third mergeFunction argument
        Map<String, Long> result1 = list.stream().collect(
            Collectors.toMap(HostingSite::getName, HostingSite::getWebsites,
                    //(oldValue, newValue) -> oldValue
                    (oldValue, newValue) -> newValue
            )
        );

        System.out.println("Result 1 : " + result1);
    }


    private static void sortListToMap() {
        List<HostingSite> list = new ArrayList<>();
        list.add(new HostingSite(1, "liquidweb.com", 80000));
        list.add(new HostingSite(2, "linode.com", 90000));
        list.add(new HostingSite(3, "digitalocean.com", 120000));
        list.add(new HostingSite(4, "aws.amazon.com", 200000));
        list.add(new HostingSite(5, "favtuts.com", 1));
        list.add(new HostingSite(6, "linode.com", 100000));

        //example 1
        Map result1 = list.stream()
                .sorted(Comparator.comparingLong(HostingSite::getWebsites).reversed())
                .collect(
                        Collectors.toMap(
                            HostingSite::getName, HostingSite::getWebsites, // key = name, value = websites
                            (oldValue, newValue) -> oldValue,               // if same key, take the old key
                            LinkedHashMap::new                              // returns a LinkedHashMap, keep order
                        ));

        System.out.println("Result 1 : " + result1);
    }
}