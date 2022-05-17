package com.favtuts.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteFile {

    private static final String FILE_DIR = "/home/tvt/workspace/favtuts/folder";
    private static final String FILE_TEXT_EXT = ".txt";

    public static void main(String[] args) {
        
        String fileName = "/home/tvt/workspace/favtuts/test.txt";
        // deleteFileHasException(fileName);
        // deleteFileNoException(fileName);
        // deleteFileLegacyIO(fileName);

        new DeleteFile().deleteFile(FILE_DIR, FILE_TEXT_EXT);
    }    
    
    // Java 7 NIO IfExists
    private static void deleteFileNoException(String fileName) {
        try {
            boolean result = Files.deleteIfExists(Paths.get(fileName));
            if (result) {
                System.out.println("File is deleted!");
            } else {
                System.out.println("Sorry, unable to delete the file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Java 7 NIO
    private static void deleteFileHasException(String fileName) {
        try {
            Files.delete(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Java classic
    private static void deleteFileLegacyIO (String fileName) {
        try {
            File file = new File(fileName);
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Sorry, unable to delete the file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String folder, String ext) {

        GenericExtFilter filter = new GenericExtFilter(ext);
        File dir = new File(folder);

        // list out all the file name with .txt extension
        String[] list = dir.list(filter);
        if (list.length == 0) return;
        
        File fileDelete;
        for(String file : list) {
            String temp = new StringBuffer(FILE_DIR)
                .append(File.separator)
                .append(file).toString();
            fileDelete = new File(temp);
            boolean isdeleted = fileDelete.delete();
            System.out.println("file : " + temp + " is deleted : " + isdeleted);
        }
    }


    // inner class, generic extension filter
    public class GenericExtFilter implements FilenameFilter {

        private String ext;

        public GenericExtFilter(String ext) {
            this.ext = ext;
        }

        public boolean accept(File dir, String name) {
            return (name.endsWith(ext));
        }
    }
}
