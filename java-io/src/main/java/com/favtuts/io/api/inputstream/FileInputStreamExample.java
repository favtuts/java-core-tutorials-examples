package com.favtuts.io.api.inputstream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileInputStreamExample {

    public static void main(String[] args) {
        String fileName = "/home/tvt/workspace/favtuts/test.txt";

        // readFileExample1(fileName);
        // readFileExample2(fileName);
        // readFileBetterPerformance(fileName);
        readFileBetterPerformance2(fileName);
    }

    private static void readFileBetterPerformance2(String fileName) {
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(new File(fileName)))) {

            // remaining bytes that can be read
            System.out.println("Remaining bytes that can be read : " + bis.available());

            int content;
            // reads 8192 bytes at a time and buffers them until they are needed,
            // if end of the file, returns -1
            while ((content = bis.read()) != -1) {

                // convert bytes to string for demo
                System.out.println((char) content);

                System.out.println("Remaining bytes that can be read : " + bis.available());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileBetterPerformance(String fileName) {
        try (FileInputStream fis = new FileInputStream(new File(fileName))) {

            // remaining bytes that can be read
            System.out.println("Remaining bytes that can be read : " + fis.available());

            // 8k a time
            byte[] bytes = new byte[8192];

            // reads 8192 bytes at a time, if end of the file, returns -1
            while (fis.read(bytes) != -1) {

                // convert bytes to string for demo
                System.out.println(new String(bytes, StandardCharsets.UTF_8));

                System.out.println("Remaining bytes that can be read : " + fis.available());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFileExample2(String fileName) {

        try (FileInputStream fis = new FileInputStream(new File(fileName))) {

            // remain bytes that can be read
            System.out.println("Remaining bytes that can be read : " + fis.available());

            int content;
            // reads a byte at a time, if it reached end of the file, returns -1
            while ((content = fis.read()) != -1) {
                System.out.println((char) content);

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
            while ((content = fis.read()) != -1) {
                System.out.println((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
