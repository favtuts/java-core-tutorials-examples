package com.favtuts.io.api.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {

    public static void main(String[] args) {
        String file = "/home/tvt/workspace/favtuts/test.txt";

        //readFileExample1(file);
        readFileExample2(file);
    }
    
    private static void readFileExample2(String fileName) {

        try (FileInputStream fis = new FileInputStream(new File(fileName))) {

            // remain bytes that can be read
            System.out.println("Remaining bytes that can be read : " + fis.available());

            int content;
            // reads a byte at a time, if it reached end of the file, returns -1
            while((content = fis.read()) != -1) {
                System.out.println((char)content);

                System.out.println("Remaining bytes that can be read : " + fis.available());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileExample1(String fileName) {

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
