package com.favtuts.io.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileAppend {

    private static final String NEW_LINE = System.lineSeparator();

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/home/tvt/workspace/favtuts/abc.txt");        
        // appendToFile(path, "hello world" + NEW_LINE);

        List<String> list = Arrays.asList("hello", "world", "favtuts");
        appendToFileJava8(path, list);
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
}
