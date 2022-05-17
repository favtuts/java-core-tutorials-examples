package com.favtuts.io.howto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.favtuts.io.utils.TreeCopyFileVisitor;

public class CopyDirectory {
    
    public static void main(String[] args) {
        String fromDirectory = "/home/tvt/workspace/favtuts/test/";
        String toToDirectory = "/home/tvt/workspace/favtuts/test2/";

        try {

            copyDirectoryFileVisitor(fromDirectory, toToDirectory);
        
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }


    public static void copyDirectoryFileVisitor(String source, String target) throws IOException {

        TreeCopyFileVisitor fileVisitor = new TreeCopyFileVisitor(source, target);
        Files.walkFileTree(Paths.get(source), fileVisitor);
    }

}
