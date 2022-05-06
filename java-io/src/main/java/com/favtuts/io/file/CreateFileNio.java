package com.favtuts.io.file;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CreateFileNio {

    public static void main(String[] args) {
        
        String fileName = "/home/tvt/workspace/favtuts/newFile.txt";
        String content = "Hello World";

        try {
            
            // Java 1.7
            // default, create and write to it.
            Files.write(Paths.get(fileName), content.getBytes(StandardCharsets.UTF_8));

            // Append content
            // Files.write(Paths.get(fileName), content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
