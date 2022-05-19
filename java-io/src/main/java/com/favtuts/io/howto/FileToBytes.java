package com.favtuts.io.howto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class FileToBytes {
    
    public static void main(String[] args) {
        try {
            String filePath = "/home/tvt/workspace/favtuts/phone.png";

            // file to bytes[]
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));

            // bytes[] to file
            Path path = Paths.get("/home/tvt/workspace/favtuts/phone2.png");
            Files.write(path, bytes);

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Apache Commons IO, try FileUtils.
    private static void readFileToBytesCommonsIO(String filePath) throws IOException {
        //...
        File file = new File("/path/file");
        byte[] bytes = FileUtils.readFileToByteArray(file);
    }


    // try-with-resources version
    private static void readFileToBytesJava7(String filePath) throws IOException {

        File file = new File(filePath);
        byte[] bytes = new byte[(int) file.length()];
    
        // funny, if can use Java 7, please uses Files.readAllBytes(path)
        try(FileInputStream fis = new FileInputStream(file)){
            fis.read(bytes);
        }
    
    }

    // file to byte[], old and classic way, before Java 7
    private static void readFileToBytesClassic(String filePath) throws IOException {

        File file = new File(filePath);
        byte[] bytes = new byte[(int) file.length()];
  
        FileInputStream fis = null;
        try {
  
            fis = new FileInputStream(file);
  
            //read file into bytes[]
            fis.read(bytes);
  
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
  
    }
}
