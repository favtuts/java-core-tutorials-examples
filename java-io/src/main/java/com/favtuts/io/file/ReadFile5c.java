package com.favtuts.io.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.favtuts.io.utils.ResourceHelper;

public class ReadFile5c {
    
    public static void main(String[] args) throws IOException {
        
        String fileName = ResourceHelper.getAbsoluteFilePath("app.log");
        
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
