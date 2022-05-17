package com.favtuts.io.howto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
            //copyDirectoryJavaNIO(Paths.get(fromDirectory),Paths.get(toToDirectory));
            copyDirectoryLegacyIO(new File(fromDirectory), new File(toToDirectory));

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


    public static void copyDirectoryLegacyIO(File source, File target) throws IOException {

        if (source.isDirectory()) {

            //if directory not exists, create it
            if (!target.exists()) {
                if (target.mkdir()) {
                    System.out.println("Directory copied from "
                            + source + "  to " + target);
                } else {
                    System.err.println("Unable to create directory : " + target);
                }
            }

            // list all the directory contents, file walker
            String[] files = source.list();
            if (files == null) {
                return;
            }

            for (String file : files) {
                //construct the src and dest file structure
                File srcFile = new File(source, file);
                File destFile = new File(target, file);
                //recursive copy
                copyDirectoryLegacyIO(srcFile, destFile);
            }

        } else {

            //if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = null;
            OutputStream out = null;

            try {

                in = new FileInputStream(source);
                out = new FileOutputStream(target);

                byte[] buffer = new byte[1024];

                int length;
                //copy the file content in bytes
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }

                System.out.println("File copied from " + source + " to " + target);

            } catch (IOException e) {

                System.err.println("IO errors : " + e.getMessage());

            } finally {
                if (in != null) {
                    in.close();
                }

                if (out != null) {
                    out.close();
                }
            }
        }

    }
}
