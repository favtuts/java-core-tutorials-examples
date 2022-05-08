package com.favtuts.io.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.favtuts.io.utils.ResourceHelper;

public class FileExample2 {

    public static void main(String[] args) {
        
        String fileName = ResourceHelper.getAbsoluteFilePath("filename.txt");

        try (FileReader reader = new FileReader(fileName); 
            BufferedReader br = new BufferedReader(reader)) {
            
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
}
