package com.favtuts.io.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.favtuts.io.utils.ResourceHelper;

public class FileExample1 {

    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();

        String fileName = ResourceHelper.getAbsoluteFilePath("filename.txt");

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            
            // read line by line
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        System.out.println(sb);
    }
    
}
