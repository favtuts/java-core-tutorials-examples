package com.favtuts.io.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileFindExample {

    public static void main(String[] args) throws IOException {
                
        Path path = Paths.get("/home/tvt/workspace/favtuts");
        /*
        List<Path> result = findByFileName(path, "newFile.txt");
        result.forEach(x -> System.out.println(x));
        */

        long fileSize = 1024 * 1024 * 100; // 100M

        List<Path> result = findByFileSize(path, fileSize);
        for (Path p : result) {
            System.out.println(String.format("%-40s [fileSize]: %,d", p, Files.size(p)));
        }
    }

    public static List<Path> findByFileName(Path path, String fileName) throws IOException {

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(
            path, 
            Integer.MAX_VALUE, 
            (p, basicFileAttributes) -> p.getFileName().toString().equalsIgnoreCase(fileName)
        )) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;
    }

    public static List<Path> findByFileSize(Path path, Long fileSize) throws IOException {

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(
            path, 
            Integer.MAX_VALUE, 
            (p, basicFileAttributes) -> {
                try {
                    if (Files.isDirectory(p)) {   // ignore directory
                        return false;
                    }
                    return Files.size(p) >= fileSize;
                } catch (IOException e) {
                    System.err.println("Unable to get the file size of path : " + path);
                }
                return false;
            }
        )) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;
    }
    
}
