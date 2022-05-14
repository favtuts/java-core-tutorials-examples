package com.favtuts.system;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SystemEnv {

    public static void main(String[] args) {
        
        // get a environment variable
        String java_home = System.getenv("JAVA_HOME");
        System.out.println(java_home);
        
        // check null to see if environment variable is not defined
        if (java_home == null) {
            System.err.println("JAVA_HOME environment variable is not defined!");
        } else {
            System.out.println(java_home);
        }

        // Java 8, Optional example to handle the null
        // String JAVA_HOME = Optional.ofNullable(System.getenv("JAVA_HOME1"))
        String JAVA_HOME = Optional.ofNullable(System.getenv("JAVA_HOME"))
            .orElseThrow(
                () -> new IllegalArgumentException("Please defined JAVA_HOME environment variable."));
        System.out.println(JAVA_HOME);

        // Unmodifiable the map of environment variables        
        Map<String, String> env = System.getenv();
        //env.put("CUSTOM_JAVA_HOME", "/opt/java99/"); // throws UnsupportedOperationException

        // Display all environment variables 
        // Java 8
        env.forEach((k, v) -> System.out.println(k + ":" + v));

        // Classic way to loop a map        
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // sort and display the environment variables in alphabetical order
        LinkedHashMap<String, String> collect =
                env.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (oldValue, newValue) -> oldValue,
                                        LinkedHashMap::new)
                        );

        collect.forEach((k, v) -> System.out.println(k + ":" + v));
    }    
}
