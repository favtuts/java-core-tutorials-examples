package com.favtuts.io.howto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputStreamToReaderExample {

    public static void main(String[] args) throws IOException {
        
        // loads a file from a resources folder
        InputStream is = InputStreamToReaderExample.class
            .getClassLoader()
            .getResourceAsStream("csv/country.csv");
        
        // BufferedReader -> InputStreamReader -> InputStream

        // try-with-resources, auto close
        String line;
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(is, StandardCharsets.UTF_8)
        )) {
            
            // read line by line
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

    }
    
}
