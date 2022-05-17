package com.favtuts.io.howto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.favtuts.io.utils.TreeCopyFileVisitor;

import org.apache.commons.io.FileUtils;

public class CopyDirectory {

    public static void main(String[] args) {
        String fromDirectory = "/home/tvt/workspace/favtuts/test/";
        String toToDirectory = "/home/tvt/workspace/favtuts/test2/";

        try {

            //copyDirectoryFileVisitor(fromDirectory, toToDirectory);
            copyFileCommonIO(fromDirectory, toToDirectory);

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
}
