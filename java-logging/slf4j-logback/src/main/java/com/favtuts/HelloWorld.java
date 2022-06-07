package com.favtuts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        
        logger.debug("Hello from Logback");

        logger.debug("getNumber() : {}", getNumber());
        
    }
    
    static int getNumber() {
        return 5;
    }
}
