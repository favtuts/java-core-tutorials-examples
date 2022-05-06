package com.favtuts.io.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile2 {
    
    public static void main(String[] args) throws IOException {
        
        String fileName = "/home/tvt/workspace/favtuts/large.txt";

        // default UTF_8
        String s = Files.readString(Paths.get(fileName));
        System.out.println(s);

        //String s = Files.readString(Paths.get(fileName), StandardCharsets.UTF_8);
    }
}
