package com.favtuts.io.file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CreateFileJava8 {
    
    public static void main(String[] args) {
        
        String fileName = "/home/tvt/workspace/favtuts/newFile.txt";

        Path path = Paths.get(fileName);
        
        // default, create, truncate and write to it.
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            
            writer.write("Hello World !!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Append mode.
        /*
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {

            writer.write("Hello World !!");
            
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
