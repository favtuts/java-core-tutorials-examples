package com.favtuts.io.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TempFileWrite {

    public static void main(String[] args) {

        try {

            File file = File.createTempFile("abc", ".tmp");
            System.out.println(file);

            // writes few lines
            List<String> content = Arrays.asList("Line 1", "Line 2", "Line 3");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (String s : content) {
                    bw.write(s);
                    bw.write(System.lineSeparator()); // new line
                }
            }

            // read from a temporary file
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*
        try {

            // create a temporary file
            Path tempFile = Files.createTempFile(null, null);
            System.out.println(tempFile);

            // write a line
            Files.write(tempFile, "Hello World\n".getBytes(StandardCharsets.UTF_8));

            // append a list of lines, add new lines automatically
            List<String> content = Arrays.asList("Line 1", "Line 2", "Line 3");
            Files.write(tempFile, content, StandardOpenOption.APPEND);

            // read a temp file, Java 11
            //String tempFileContent = Files.readString(tempFile);
            //System.out.println(tempFileContent);

            // Java 8
            String tempFileContent = Files
                    .lines(tempFile, StandardCharsets.UTF_8)
                    .collect(Collectors.joining(System.lineSeparator()));
            System.out.println(tempFileContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        
    }
    
}
