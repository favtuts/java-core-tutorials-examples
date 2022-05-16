package com.favtuts.io.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWrite {

    private static final String NEW_LINE = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/tvt/workspace/favtuts/aaa.txt");
        writeFile(path, "Hello World 1" + NEW_LINE);
    }
    
    // Java 7
    private static void writeFile(Path path, String content) throws IOException {

        // If file does not exist, create and write it
        // if the file exists, override the content
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));

        // Append mode
        // if the file exists, append string to the end of file.
        // Files.write(path, content.getBytes(StandardCharsets.UTF_8),
		// 			StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        
        // if file does not exist, throws NoSuchFileException
        // if the file exists, append it
        // Files.write(path, content.getBytes(StandardCharsets.UTF_8),
		// 			StandardOpenOption.APPEND);
    }
}
