package com.favtuts.io.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesWalkExample {

    public static void main(String[] args) throws IOException {
        
        //Path path = Paths.get("C:\\test\\");
        Path path = Paths.get("/home/tvt/workspace/favtuts/");        
        //List<Path> paths = listFiles(path);        
        //List<Path> paths = listDirectories(path);
        //List<Path> paths = findByFileExtension(path, ".txt");
        List<Path> paths = findByFileName(path, "readme.txt");

        paths.forEach(x -> System.out.println(x));
    }
    
    // list all files from this path
    public static List<Path> listFiles(Path path) throws IOException {

        List<Path> result;
        //try (Stream<Path> walk = Files.walk(path, 1)) {
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                .collect(Collectors.toList());
        }
        return result;
    }

    // list all directories from this path
    public static List<Path> listDirectories(Path path) throws IOException {
        List<Path> result;
        //try (Stream<Path> walk = Files.walk(path, 1)) {
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isDirectory)
                .collect(Collectors.toList());
        }
        return result;
    }

    public static List<Path> findByFileExtension(Path path, String fileExtension) throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory");
        }

        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                .filter(Files::isRegularFile) // is a file
                .filter(p -> p.getFileName().toString().endsWith(fileExtension))
                .collect(Collectors.toList());
        }

        return result;
    }

    public static List<Path> findByFileName(Path path, String fileName) throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory");
        }

        List<Path> result;
        // walk file tree, no more recursive loop
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                .filter(Files::isReadable)      // read permission
                .filter(Files::isRegularFile)   // is a file
                .filter(p -> p.getFileName().toString().equalsIgnoreCase(fileName))
                .collect(Collectors.toList());
        }

        return result;
    }
}
