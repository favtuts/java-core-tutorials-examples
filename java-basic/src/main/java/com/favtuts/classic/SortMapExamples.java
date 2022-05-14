package com.favtuts.classic;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapExamples {
    
    public static void main(String[] args) {
        
        //sortByKeyAscWithTreeMap();
        sortByKeyDescWithTreeMap();

    }

    private static void sortByKeyDescWithTreeMap() {

        Map<Integer, String> unsortMap = new HashMap<Integer, String>();
        unsortMap.put(10, "z");
        unsortMap.put(5, "b");
        unsortMap.put(6, "a");
        unsortMap.put(20, "c");
        unsortMap.put(1, "d");
        unsortMap.put(7, "e");
        unsortMap.put(8, "y");
        unsortMap.put(99, "n");
        unsortMap.put(50, "j");
        unsortMap.put(2, "m");
        unsortMap.put(9, "f");

        System.out.println("Unsort Map......");
        printMap(unsortMap);

        System.out.println("\nSorted Map......By Key");
        Map<Integer, String> treeMap = new TreeMap<Integer, String>(
            new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            }
        );

        /*
        // For Java 8, try this lambda        
        Map<Integer, String> treeMap = new TreeMap<>(
            (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1)
        );
        */

        treeMap.putAll(unsortMap);
        printMap(treeMap);
    }


    private static void sortByKeyAscWithTreeMap() {

        Map<String, String> unsortMap = new HashMap<String, String>();
        unsortMap.put("Z", "z");
        unsortMap.put("B", "b");
        unsortMap.put("A", "a");
        unsortMap.put("C", "c");
        unsortMap.put("D", "d");
        unsortMap.put("E", "e");
        unsortMap.put("Y", "y");
        unsortMap.put("N", "n");
        unsortMap.put("J", "j");
        unsortMap.put("M", "m");
        unsortMap.put("F", "f");

        System.out.println("Unsort Map......");
        printMap(unsortMap);

        System.out.println("\nSorted Map......By Key");
        Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
        printMap(treeMap);

    }


    // prety print a map
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                                + " Value : " + entry.getValue());
        }
    }

}
