package com.favtuts.io.directory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectoryDelete {
    
    public static void createDummyFiles() throws IOException {
        Files.createDirectories(Paths.get("/home/tvt/workspace/favtuts/test2/test3/test4/test5/"));
        Files.write(Paths.get("/home/tvt/workspace/favtuts/test2/test2.log"), "hello".getBytes());
        Files.write(Paths.get("/home/tvt/workspace/favtuts/test2/test3/test3.log"), "hello".getBytes());
    }

    public static void main(String[] args) {

        String dir = "/home/tvt/workspace/favtuts/test2/";

        try {

            //createDummyFiles();

            deleteDirectoryJava7(dir);

            System.out.println("Done");

        } catch (IOException e) {
            System.err.printf("Failed to delete the directory %n%s%n", e);
        }

    }

    public static void deleteDirectoryJava7(String filePath)
        throws IOException {

        Path path = Paths.get(filePath);

        Files.walkFileTree(path,
            new SimpleFileVisitor<>() {

                // delete directories or folders
                @Override
                public FileVisitResult postVisitDirectory(Path dir,
                                                          IOException exc)
                                                          throws IOException {
                    Files.delete(dir);
                    System.out.printf("Directory is deleted : %s%n", dir);
                    return FileVisitResult.CONTINUE;
                }

                // delete files
                @Override
                public FileVisitResult visitFile(Path file,
                                                 BasicFileAttributes attrs)
                                                 throws IOException {
                    Files.delete(file);
                    System.out.printf("File is deleted : %s%n", file);
                    return FileVisitResult.CONTINUE;
                }
            }
        );

    }
    
}
