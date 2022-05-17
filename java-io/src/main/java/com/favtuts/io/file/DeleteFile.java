package com.favtuts.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteFile {

    public static void main(String[] args) {
        
        String fileName = "/home/tvt/workspace/favtuts/test.txt";
        try {
            Files.delete(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
