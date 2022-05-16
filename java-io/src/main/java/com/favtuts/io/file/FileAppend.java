package com.favtuts.io.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileAppend {

    private static final String NEW_LINE = System.lineSeparator();

    public static void main(String[] args) throws IOException {

        // Path path = Paths.get("/home/tvt/workspace/favtuts/abc.txt");
        // String content = "hello world" + NEW_LINE;
        // appendToFile(path, content);

        // List<String> list = Arrays.asList("hello", "world", "favtuts");
        // appendToFileJava8(path, list);

        // appendToFileJava11(path, content);

        File file = new File("/home/tvt/workspace/favtuts/abc.txt");
        // String content = "hello world" + NEW_LINE;
        // appendToFileFileWriter(file, content);

        List<String> lines = Arrays.asList("hello", "world", "favtuts");
        appendToFileFileWriter(file, lines);
    }

    // Java 7
    private static void appendToFile(Path path, String content) throws IOException {
        // if file not exists throws java.nio.file.NoSuchFileException
        /*
         * Files.write(path, content.getBytes(StandardCharsets.UTF_8),
         * StandardOpenOption.APPEND);
         */

        // if file not exists, create and write to it
        // otherwise append to the end of the file

        Files.write(path, content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    // apend lines of text
    private static void appendToFileJava8(Path path, List<String> list) throws IOException {
        // Java 7?
        /*
         * Files.write(path, list, StandardCharsets.UTF_8,
         * StandardOpenOption.CREATE,
         * StandardOpenOption.APPEND);
         */

        // Java 8, default utf_8
        Files.write(path, list,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    // Java 11, writeString, append mode
    private static void appendToFileJava11(Path path, String content)
            throws IOException {

        // utf_8
        /*
         * Files.writeString(path, content, StandardCharsets.UTF_8,
         * StandardOpenOption.CREATE,
         * StandardOpenOption.APPEND);
         */

        // default StandardCharsets.UTF_8
        Files.writeString(path, content,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    private static void appendToFileFileWriter(File file, String content)
            throws IOException {

        // default - create and write
        // if file not exists, create and write
        // if file exists, truncate and write
        /*
         * try (FileWriter fw = new FileWriter(file);
         * BufferedWriter bw = new BufferedWriter(fw)) {
         * bw.write(content);
         * bw.newLine();
         * }
         */

        // append mode
        // if file not exists, create and write
        // if file exists, append to the end of the file
        try (FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(content);
            bw.newLine(); // add new line, System.lineSeparator()

        }

    }

    private static void appendToFileFileWriter(
            File file, List<String> lines) throws IOException {

        try (FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw)) {

            for (String s : lines) {
                bw.write(s);
                bw.newLine();
            }
        }

    }

    private static void appendToFileFileOutputStream(File file, String content)
            throws IOException {

        // append mode
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        }

    }

    private static void appendToFileFileUtils(File file, String content)
            throws IOException {

        // append mode
        FileUtils.writeStringToFile(
                file, content, StandardCharsets.UTF_8, true);

    }

    private static void appendToFileClassic(String fileName, String content) throws IOException {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fileName, true);
            bw = new BufferedWriter(fw);
            bw.write(content);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
    }
}
