package com.favtuts.io.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.favtuts.io.utils.ResourceHelper;

public class ReadFile5a {
    
    public static void main(String[] args) throws IOException {
        
        String fileName = ResourceHelper.getAbsoluteFilePath("app.log");

        // defaultCharBufferSize = 8192; or 8k
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
