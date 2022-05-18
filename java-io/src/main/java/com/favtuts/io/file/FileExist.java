package com.favtuts.io.file;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExist {

    public static void main(String[] args) {
        
        //Path path = Paths.get("/home/tvt/workspace/favtuts/test/test.log");
        Path path = Paths.get("/home/tvt/workspace/favtuts/test/soft-link");

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
    }
    
}
