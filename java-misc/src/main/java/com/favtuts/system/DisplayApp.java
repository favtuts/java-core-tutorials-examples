package com.favtuts.system;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class DisplayApp {

    public static void main(String[] args) {
        
        //listSystemProperties();
        sortSystemProperties();
        
    }

    private static void sortSystemProperties () {
        Properties properties = System.getProperties();

        // Thanks Java 8
        LinkedHashMap<String, String> collect = properties.entrySet().stream()
                .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        
        collect.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    private static void listSystemProperties () {

        Properties properties = System.getProperties();

        // Java 8
        properties.forEach((k, v) -> System.out.println(k + ":" + v));

        // Classic way to loop a map
        // for (Map.Entry<Object, Object> entry : properties.entrySet()) {
        //     System.out.println(entry.getKey() + " : " + entry.getValue());
        // }

        // No good, output is truncated, long lines end with ...
        // properties.list(System.out);

    }
    
}
