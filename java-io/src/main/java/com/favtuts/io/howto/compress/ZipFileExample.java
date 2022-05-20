package com.favtuts.io.howto.compress;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;

import net.lingala.zip4j.ZipFile;


public class ZipFileExample {

    public static void main(String[] args) {
        
        Path source = Paths.get("/home/tvt/workspace/favtuts/Test.java");
        String zipFileName = "example.zip";

        try {
            // zipSingleFile(source, zipFileName);
            // zipSingleFileNio(source, zipFileName);
            zipFileWithoutSaveLocal(zipFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
    
    // Zip a single file
    public static void zipSingleFile(Path source, String zipFileName) throws IOException {

        if (!Files.isRegularFile(source)) {
            System.err.println("Please provide a file.");
            return;
        }

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName));
            FileInputStream fis = new FileInputStream(source.toFile())
        ) {
            
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();
        } 

    }

    // Zip a single file
    public static void zipSingleFileNio (Path source, String zipFileName) throws IOException {

        if (!Files.isRegularFile(source)) {
            System.err.println("Please provide a file.");
            return;
        }

        Map<String, String> env = new HashMap<>();
        // Create the zip file if it doesn't exist
        env.put("create", "true");

        URI uri = URI.create("jar:file:/home/tvt/workspace/favtuts/"+zipFileName);
        try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
            Path pathInZipfile = zipfs.getPath(source.getFileName().toString());

            // Copy a file into the zip file path
            Files.copy(source, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    // create a file on demand (without save locally) and add to zip
    public static void zipFileWithoutSaveLocal(String zipFileName) throws IOException {

        String data = "Test data \n123\n456";
        String fileNameInZip = "abc.txt";

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName))) {

            ZipEntry zipEntry = new ZipEntry(fileNameInZip);
            zos.putNextEntry(zipEntry);

            ByteArrayInputStream bais = new ByteArrayInputStream(data.getBytes());
            // one line, able to handle large size?
            //zos.write(bais.readAllBytes());

            // play safe
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bais.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            zos.closeEntry();
        }

    }


    public static void zip4j() throws IOException {

        // zip file with a single file
        new ZipFile("filename.zip").addFile("file.txt");

        // zip file with multiple files
        List<File> files = Arrays.asList(
                new File("file1.txt"), new File("file2.txt"));
        new ZipFile("filename.zip").addFiles(files);

        // zip file with a folder
        new ZipFile("filename.zip").addFolder(new File("/home/favtuts/folder"));

    }
}
