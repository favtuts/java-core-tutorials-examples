package com.favtuts.io.file;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExist {

    public static void main(String[] args) {
        
        //String fileName = "/home/tvt/workspace/favtuts/test/test.log";
        String fileName = "/home/tvt/workspace/favtuts/test/soft-link";        
        Path path = Paths.get(fileName);

        // check exists for file and directory
        if (Files.exists(path)) {

            if (Files.isRegularFile(path)) {
                System.out.println("File exists!");
            }

            if (Files.isDirectory(path)) {
                System.out.println("File exists, but it is a directory.");
            }

        } else {
            System.out.println("File doesn't exist");
        }

        if(Files.exists(path) && !Files.isDirectory(path)) {
            System.out.println("File exists!");
        }

         // If file is a symbolic links, it follows by default.
        if(Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("File exists. No follow the symbolic link");
        }

        if(Files.notExists(path)){
            System.out.println("File doesn't exist");
        }

        fileExists(fileName);
    }

    // legacy io, no support for symbolic links
    private static void fileExists(String fileName){

        File file = new File(fileName);
        if(file.exists() && !file.isDirectory()){
            System.out.println("File exists!");
        }else{
            System.out.println("File doesn't exist");
        }

    }
    
}
