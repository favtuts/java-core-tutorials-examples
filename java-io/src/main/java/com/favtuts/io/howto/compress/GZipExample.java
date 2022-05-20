package com.favtuts.io.howto.compress;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.zip.*;

public class GZipExample {
    public static void main(String[] args) {

        // compress a file
        // Path source = Paths.get("/home/tvt/workspace/favtuts/sitemap.xml");
        // Path target = Paths.get("/home/tvt/workspace/favtuts/sitemap.xml.gz");

        // decompress
        Path source = Paths.get("/home/tvt/workspace/favtuts/sitemap.xml.gz");
        Path target = Paths.get("/home/tvt/workspace/favtuts/sitemap3.xml");

        if (Files.notExists(source)) {
            System.err.printf("The path %s doesn't exist!", source);
            return;
        }

        try {

            //GZipExample.compressGzip(source, target);
            //GZipExample.compressGzipNio(source, target);

            // Compress String Data to Gzip
            /*
            target = Paths.get("/home/tvt/workspace/favtuts/string_data.gz");
            GZipExample.compressStringToGzip("hello world", target);
            */

            GZipExample.decompressGzip(source, target);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // copy file (FileInputStream) to GZIPOutputStream
    public static void compressGzip(Path source, Path target) throws IOException {

        try (GZIPOutputStream gos = new GZIPOutputStream(
                                      new FileOutputStream(target.toFile()));
             FileInputStream fis = new FileInputStream(source.toFile())) {

            // copy file
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                gos.write(buffer, 0, len);
            }

        }

    }

    public static void compressGzipNio(Path source, Path target) throws IOException {

        try (GZIPOutputStream gos = new GZIPOutputStream(
                                      new FileOutputStream(target.toFile()))) {
  
            Files.copy(source, gos);
  
        }
  
    }

    public static void compressStringToGzip(String data, Path target) throws IOException {

        try (GZIPOutputStream gos = new GZIPOutputStream(
                                      new FileOutputStream(target.toFile()))) {
  
            gos.write(data.getBytes(StandardCharsets.UTF_8));
  
        }
  
    }


    public static void decompressGzip(Path source, Path target) throws IOException {

        try (GZIPInputStream gis = new GZIPInputStream(
                                      new FileInputStream(source.toFile()));
             FileOutputStream fos = new FileOutputStream(target.toFile())) {

            // copy GZIPInputStream to FileOutputStream
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }

        }

    }
}
