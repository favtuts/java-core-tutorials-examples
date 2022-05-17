package com.favtuts.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteFile {

    public static void main(String[] args) {
        
        String fileName = "/home/tvt/workspace/favtuts/test.txt";
        // deleteFileHasException(fileName);
        // deleteFileNoException(fileName);
        deleteFileLegacyIO(fileName);
    }
    
    private static void deleteFileNoException(String fileName) {
        try {
            boolean result = Files.deleteIfExists(Paths.get(fileName));
            if (result) {
                System.out.println("File is deleted!");
            } else {
                System.out.println("Sorry, unable to delete the file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFileHasException(String fileName) {
        try {
            Files.delete(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFileLegacyIO (String fileName) {
        try {
            File file = new File(fileName);
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Sorry, unable to delete the file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
