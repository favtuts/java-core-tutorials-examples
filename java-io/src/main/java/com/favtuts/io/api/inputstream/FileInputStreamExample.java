package com.favtuts.io.api.inputstream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileInputStreamExample {

    public static void main(String[] args) {
        String fileName = "/home/tvt/workspace/favtuts/test.txt";
        String fileUnicode = "/home/tvt/workspace/favtuts/file-unicode.txt";
        // readFileExample1(fileName);
        // readFileExample2(fileName);
        // readFileBetterPerformance(fileName);
        // readFileBetterPerformance2(fileName);
        // readFileBetterInputStreamReader(fileName);


        List<String> lines = Arrays.asList("你好", "我好", "大家好");
        writeUnicodeClassic(fileUnicode, lines);
        readFileBetterPerformance(fileUnicode);
    }

    private static void readFileBetterInputStreamReader(String fileName) {

        try (BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(new File(fileName))))) {
    
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    
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

    // Java 7
    public static void writeUnicodeJava7(String fileName, List<String> lines) {

        Path path = Paths.get(fileName);
        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // in the old days
    public static void writeUnicodeClassic(String fileName, List<String> lines) {

        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(osw)
        ) {
            Integer idx = 0;
            for (String line : lines) {
                idx += 1;
                writer.append(line);
                                
                //No append new Line with the last item
                if (idx < lines.size())
                    writer.newLine();                                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
