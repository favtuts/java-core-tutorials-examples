package com.favtuts.io.howto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class ByteToFile {

    public static void main(String[] args) {

        try {

            // tested with character data
            String filePath = "/home/tvt/workspace/favtuts/file.txt";

            // file to bytes[]
            // byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            // byte[] bytes = readFileToBytesClassic(filePath);
            // byte[] bytes = readFileToBytesJava7(filePath);
            // byte[] bytes = readFileToBytesJavaNio(filePath);            
            byte[] bytes = readFileToBytesCommonsIO(filePath);

            // save byte[] to a file
            writeBytesToFile("/home/tvt/workspace/favtuts/file2.txt", bytes);
            writeBytesToFileNio("/home/tvt/workspace/favtuts/file3.txt", bytes);
            writeBytesToFileApache("/home/tvt/workspace/favtuts/file4.txt", bytes);

            System.out.println("Done");


            // tested with binary data
            filePath = "/home/tvt/workspace/favtuts/phone.png";
            bytes = readFileToBytesJavaNio(filePath);

            // save byte[] to a file
            writeBytesToFile("/home/tvt/workspace/favtuts/phone2.png", bytes);
            writeBytesToFileNio("/home/tvt/workspace/favtuts/phone3.png", bytes);
            writeBytesToFileApache("/home/tvt/workspace/favtuts/phone4.png", bytes);
            
        } catch (IOException e) {
            e.printStackTrace();
        }    

    }

    private static byte[] readFileToBytesJavaNio(String filePath) throws IOException {       
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        return bytes;
    }


     // Apache Commons IO, try FileUtils.
     private static byte[] readFileToBytesCommonsIO(String filePath) throws IOException {
        //...
        File file = new File(filePath);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        return bytes;
    }


    // try-with-resources version
    private static byte[] readFileToBytesJava7(String filePath) throws IOException {

        File file = new File(filePath);
        byte[] bytes = new byte[(int) file.length()];
    
        // funny, if can use Java 7, please uses Files.readAllBytes(path)
        try(FileInputStream fis = new FileInputStream(file)){
            fis.read(bytes);
        }

        return bytes;
    }


    // file to byte[], old and classic way, before Java 7
    private static byte[] readFileToBytesClassic(String filePath) throws IOException {

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

        return bytes;

    }


    //JDK 7 - FileOutputStream + try-with-resources
    private static void writeBytesToFile(String fileOutput, byte[] bytes)
        throws IOException {

        try (FileOutputStream fos = new FileOutputStream(fileOutput)) {
            fos.write(bytes);
        }

    }

    //JDK 7, NIO, Files.write
    private static void writeBytesToFileNio(String fileOutput, byte[] bytes)
        throws IOException {

        Path path = Paths.get(fileOutput);
        Files.write(path, bytes);

    }

    // Apache Commons IO
    private static void writeBytesToFileApache(String fileOutput, byte[] bytes)
        throws IOException {

        FileUtils.writeByteArrayToFile(new File(fileOutput), bytes);

    }
    
}
