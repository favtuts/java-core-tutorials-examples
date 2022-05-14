package com.favtuts.system;

import java.util.Optional;

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
        String JAVA_HOME = Optional.ofNullable(System.getenv("JAVA_HOME1"))
            .orElseThrow(
                () -> new IllegalArgumentException("Please defined JAVA_HOME environment variable."));
        System.out.println(JAVA_HOME);
    }
    
}
