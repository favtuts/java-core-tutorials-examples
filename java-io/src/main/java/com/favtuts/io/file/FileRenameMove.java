package com.favtuts.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;

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

            // move file to another directory, using the same file name
            /*
            Path newDir = Paths.get("/home/tvt/workspace/favtuts/newfolder/");
            // create the directories, if directory exits, no effect
            Files.createDirectories(newDir);

            Files.move(source, newDir.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            */

            // apache commons-io
            //FileUtils.moveFile(new File("/source"), new File("/target"));

            /*CopyOption[] options = { StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES,
                    LinkOption.NOFOLLOW_LINKS };

            Files.move(source, target, options);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
