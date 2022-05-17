package com.favtuts.io.howto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import com.favtuts.io.utils.TreeCopyFileVisitor;

import org.apache.commons.io.FileUtils;

public class CopyDirectory {

    public static void main(String[] args) {
        String fromDirectory = "/home/tvt/workspace/favtuts/test/";
        String toToDirectory = "/home/tvt/workspace/favtuts/test2/";

        try {

            //copyDirectoryFileVisitor(fromDirectory, toToDirectory);
            //copyFileCommonIO(fromDirectory, toToDirectory);
            copyDirectoryJavaNIO(Paths.get(fromDirectory),Paths.get(toToDirectory));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    public static void copyDirectoryFileVisitor(String source, String target) throws IOException {

        TreeCopyFileVisitor fileVisitor = new TreeCopyFileVisitor(source, target);
        Files.walkFileTree(Paths.get(source), fileVisitor);
    }

    public static void copyFileCommonIO(String from, String to) throws IOException {

        File fromDir = new File(from);
        File toDir = new File(to);

        FileUtils.copyDirectory(fromDir, toDir);

    }

    public static void copyDirectoryJavaNIO(Path source, Path target) throws IOException {

        // is this a directory?
        if (Files.isDirectory(source)) {

            //if target directory exist?
            if (Files.notExists(target)) {
                // create it
                Files.createDirectories(target);
                System.out.println("Directory created : " + target);
            }

            // list all files or folders from the source, Java 1.8, returns a stream
            // doc said need try-with-resources, auto-close stream
            try (Stream<Path> paths = Files.list(source)) {

                // recursive loop
                paths.forEach(p ->
                        copyDirectoryJavaNIOWrapper(
                            p, target.resolve(source.relativize(p)))
                );

            }

        } else {
            // if file exists, replace it
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(
                    String.format("Copy File from \t'%s' to \t'%s'", source, target)
            );
        }    
    }

    // extract method to handle exception in lambda
    public static void copyDirectoryJavaNIOWrapper(Path source, Path target) {

        try {
            copyDirectoryJavaNIO(source, target);
        } catch (IOException e) {
            System.err.println("IO errors : " + e.getMessage());
        }

    }
}
