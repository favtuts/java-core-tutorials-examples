package com.favtuts.io.howto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFileByExtension {
    
    public static void main(String[] args) {
        try {
            String folderName = "/home/tvt/workspace/favtuts";
            //List<String> files = findFiles(Paths.get(folderName), "png");

            String[] fileExtensions = {"png", "jpg", "gif"};
            List<String> files = findFiles(Paths.get(folderName), fileExtensions);

            files.forEach(x -> System.out.println(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> findFiles(Path path, String fileExtension) throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                .filter(p -> !Files.isDirectory(p))
                // this is a path, not string,
                // this only test if path end with a certain path
                //.filter(p -> p.endsWith(fileExtension))
                // convert path to string first
                .map(p -> p.toString().toLowerCase())
                .filter(f -> f.endsWith(fileExtension))
                .collect(Collectors.toList());
        }

        return result;        
    }

    public static List<String> findFiles(Path path, String[] fileExtensions) throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;
        //try (Stream<Path> walk = Files.walk(path, 1)) {
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    // convert path to string
                    .map(p -> p.toString().toLowerCase())
                    //.filter(f -> isEndWith(f, fileExtensions))

                    // lambda
                    //.filter(f -> Arrays.stream(fileExtensions).anyMatch(ext -> f.endsWith(ext)))

                    // method reference
                    .filter(f -> Arrays.stream(fileExtensions).anyMatch(f::endsWith))
                    .collect(Collectors.toList());
        }
        return result;

    }

    private static boolean isEndWith(String file, String[] fileExtensions) {
        // Java 8, try this
        boolean result = Arrays.stream(fileExtensions).anyMatch(file::endsWith);
        return result;

        // old school style
        /*
        boolean result = false;
        //System.out.println("Checking " + file + " ...");
        for (String fileExtension : fileExtensions) {            
            if (file.endsWith(fileExtension)) {
                result = true;
                break;
            }
        }
        return result;
        */
    }


    /*public static String[] findFiles(File dir, String fileExtension) {

        // one level only, need recursive loop for sub folders
        File[] files = dir.listFiles(new FileExtensionFilter(fileExtension));

        return null;

    }

    static class FileExtensionFilter implements FilenameFilter {

        private String fileExtension;

        public FileExtensionFilter(String fileExtension) {
            this.fileExtension = fileExtension;
        }

        public boolean accept(File dir, String fileName) {
            return (fileName.endsWith(fileExtension));
        }
    }*/
}
