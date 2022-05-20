package com.favtuts.io.temp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateTempFile {

    public static void main(String[] args) {

        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println("Temp file path: " + tmpdir);

        try {

            // Create an temporary file
            // Path temp = Files.createTempFile("hello", ".file");
            // Path temp = Files.createTempFile("hello", null);
            // Path temp = Files.createTempFile(null, ".log");
            // Path temp = Files.createTempFile("hello", "");
            Path temp = Files.createTempFile(null, null);
            System.out.println("Temp file : " + temp);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
