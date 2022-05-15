package com.favtuts.io.api.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {

    public static void main(String[] args) {
        String file = "/home/tvt/workspace/favtuts/writefile.txt";

        readFile(file);
    }
    
    private static void readFile(String fileName) {

        try (FileInputStream fis = new FileInputStream(new File(fileName))) {
            int content;
            // reads a byte at a time, if it reached end of the file, returns -1
            while((content = fis.read()) != -1) {
                System.out.println((char)content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
