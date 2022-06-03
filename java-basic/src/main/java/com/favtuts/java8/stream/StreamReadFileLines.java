package com.favtuts.java8.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamReadFileLines {

    public static void main(String[] args) {
        // useFileLinesMethodWithStream();
        // readFileLinesWithFilterExtra();
        // readFileLinesWithBufferedReader();
        // readFileLinesBufferedReaderClassic();
        readFileLinesWithScanner();
    }

    static void readFileLinesWithScanner() {
        String fileName = "c://lines.txt";

        try (Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readFileLinesBufferedReaderClassic() {
        String fileName = "/home/tvt/workspace/favtuts/lines.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readFileLinesWithBufferedReader() {
        String fileName = "/home/tvt/workspace/favtuts/lines.txt";
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            // br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
    }

    static void readFileLinesWithFilterExtra() {
        String fileName = "/home/tvt/workspace/favtuts/lines.txt";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            // 1. filter line 3
            // 2. convert all content to upper case
            // 3. convert it into a List
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
    }

    static void useFileLinesMethodWithStream() {
        String fileName = "/home/tvt/workspace/favtuts/lines.txt";

        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
