package com.favtuts.io.temp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.nio.file.attribute.PosixFilePermission;

public class CreateTempFile {

    public static void main(String[] args) {

        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println("Temp file path: " + tmpdir);

        try {

            // Create an temporary file
            // Path temp = Files.createTempFile("hello", ".file");
            // Path temp = Files.createTempFile("hello", null);
            // Path temp = Files.createTempFile(null, ".log");
            // Path temp = Files.createTempFile("hello", "");
            // Path temp = Files.createTempFile(null, null);

            // Create a temporary file in a specified folder
            /*
             * Path path = Paths.get("/home/tvt/workspace/favtuts/temp/");
             * Path temp = Files.createTempFile(path, null, ".log");
             */

            // file permission
            // Files.setPosixFilePermissions(tempFile,
            // PosixFilePermissions.fromString("rwxrwxrwx"));

            // Create a temporary file in a specified folder + file permission
            Path path = Paths.get("/home/tvt/workspace/favtuts/temp/");
            // 777
            Set<PosixFilePermission> fp = PosixFilePermissions.fromString("rwxrwxrwx");
            Path temp = Files.createTempFile(path, null, ".log", PosixFilePermissions.asFileAttribute(fp));

            System.out.println("Temp file : " + temp);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
