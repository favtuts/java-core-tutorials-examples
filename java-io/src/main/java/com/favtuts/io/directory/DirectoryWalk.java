package com.favtuts.io.directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryWalk {    

    public static void main(String[] args) {

        String folderName = "/home/tvt/workspace/favtuts/test";

        //listAllFilesJava8(folderName);
        //listAllFoldersJava8(folderName);
        //listAllLogFilesJava8(folderName);
        findSpecificFileJava8(folderName);

        // Classic search
        /*
        final File folder = new File(folderName);
        List<String> result = new ArrayList<>();

        search(".*\\.log", folder, result);

        for (String s : result) {
            System.out.println(s);
        }
        */      
    }

    // Java 8
    public static void listAllFilesJava8(final String folderName) {
        try (Stream<Path> walk = Files.walk(Paths.get(folderName))) {

            List<String> result = walk.filter(Files::isRegularFile)
                .map(x -> x.toString())
                .collect(Collectors.toList());
            
            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Java 8
    public static void listAllFoldersJava8(final String folderName) {
        try (Stream<Path> walk = Files.walk(Paths.get(folderName))) {

            List<String> result = walk.filter(Files::isDirectory)
                .map(x -> x.toString())
                .collect(Collectors.toList());
            
            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Java 8
    public static void listAllLogFilesJava8(final String folderName) {
        try (Stream<Path> walk = Files.walk(Paths.get(folderName))) {

            List<String> result = walk.map(x -> x.toString())
                .filter(f -> f.endsWith(".log"))
                .collect(Collectors.toList());
            
            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Java 8
    public static void findSpecificFileJava8(final String folderName) {
        try (Stream<Path> walk = Files.walk(Paths.get(folderName))) {

            List<String> result = walk.map(x -> x.toString())
                .filter(f -> f.contains("test-c2.log"))
                .collect(Collectors.toList());
            
            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Classic
    public static void search(final String pattern, final File folder, List<String> result) {
        for (final File f : folder.listFiles()) {

            if (f.isDirectory()) {
                search(pattern, f, result);
            }

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                }
            }
        }
    }

}
