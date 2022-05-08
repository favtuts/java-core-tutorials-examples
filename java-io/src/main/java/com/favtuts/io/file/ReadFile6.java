package com.favtuts.io.file;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.favtuts.io.utils.ResourceHelper;

public class ReadFile6 {
    
    public static void main(String[] args) throws IOException {
        
        String fileName = ResourceHelper.getAbsoluteFilePath("app.log");
        
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        }
        
    }
}
