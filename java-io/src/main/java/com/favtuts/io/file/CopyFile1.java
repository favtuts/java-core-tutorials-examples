package com.favtuts.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class CopyFile1 {

    public static void main(String[] args) {
        
        String fromFile = "/home/tvt/workspace/favtuts/sample.csv";
        String toFile = "/home/tvt/workspace/favtuts/backup/sample_bk_20220512.csv";

        try {
            //copyFileNIO(fromFile, toFile);
            //copyFileCommonIO(fromFile, toFile);
            //copyFileGuava(fromFile, toFile);
            copyFilePlainJava(fromFile, toFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Copy file is done.");

    }
    
    public static void copyFileNIO(String from, String to) throws IOException {

        Path fromFile = Paths.get(from);
        Path toFile = Paths.get(to);

        // if fromFile does't exist, Files.copy throws NoSuchFileException
        if (Files.notExists(fromFile)) {
            System.out.println("File doesn't exist? " + fromFile);
            return;
        }

        // if toFile folder doesn't exist, Files.copy throws NoSuchFileException
        // if toFile parent folder doesn't exist, create it.
        Path parent = toFile.getParent();
        if (parent!=null) {
            if (Files.notExists(parent)) {
                Files.createDirectories(parent);
            }
        }

        // default - if toFile exist, throws FileAlreadyExistsException
        Files.copy(fromFile, toFile);

        // if toFile exist, replace it.
        // Files.copy(fromFile, toFile, StandardCopyOption.REPLACE_EXISTING);

        // multiple StandardCopyOption
        /*CopyOption[] options = { StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES,
                LinkOption.NOFOLLOW_LINKS };

        Files.copy(fromFile, toFile, options);*/
    }
 
    
    public static void copyFileCommonIO(String from, String to) throws IOException {

        File fromFile = new File(from);
        File toFile = new File(to);

        FileUtils.copyFile(fromFile, toFile);
    }

    public static void copyFileGuava(String from, String to) throws IOException {

        File fromFile = new File(from);
        File toFile = new File(to);
  
        // @Beta?
        com.google.common.io.Files.copy(fromFile, toFile);
  
    }

    public static void copyFilePlainJava(String from, String to) throws IOException {

        InputStream inStream = null;
        OutputStream outStream = null;
  
        try {
  
            File fromFile = new File(from);
            File toFile = new File(to);
  
            inStream = new FileInputStream(fromFile);
            outStream = new FileOutputStream(toFile);
  
            byte[] buffer = new byte[1024];
  
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
                outStream.flush();
            }
  
        } finally {
            if (inStream != null)
                inStream.close();
  
            if (outStream != null)
                outStream.close();
        }
  
    }
}
