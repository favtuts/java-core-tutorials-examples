package com.favtuts.display;

import java.util.Map;
import java.util.Properties;

public class DisplayApp {

    public static void main(String[] args) {
        
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
