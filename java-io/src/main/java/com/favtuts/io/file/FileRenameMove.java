package com.favtuts.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileRenameMove {

    public static void main(String[] args) {

        String fromFile = "/home/tvt/workspace/favtuts/hello.txt";
        String toFile = "/home/tvt/workspace/favtuts/newName.txt";

        Path source = Paths.get(fromFile);
        Path target = Paths.get(toFile);

        try {

            // rename or move a file to other path
            // if target exists, throws FileAlreadyExistsException
            Files.move(source, target);

            // if target exists, replace it.
            // Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);

            // rename a file in the same directory
            // Files.move(source, source.resolveSibling("newName.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
