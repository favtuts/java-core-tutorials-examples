package com.favtuts.string;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class ConvertInputStreamToString {
    
    public static final int DEFAULT_BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        
        URI uri = URI.create("https://www.google.com/");

        try (InputStream inputStream = uri.toURL().openStream()) {
            
            // Convert InputStream -> String
            String result = convertInputStreamToString(inputStream);

            System.out.println(result);
        }
    }

    // Plain Java
    private static String convertInputStreamToString(InputStream is) throws IOException {

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int length;
        while ((length = is.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }

        // Java 1.1
        //return result.toString(StandardCharsets.UTF_8.name());

        return result.toString("UTF-8");

        // Java 10
        //return result.toString(StandardCharsets.UTF_8);

    }
}
