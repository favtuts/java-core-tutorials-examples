package com.favtuts.io.howto.compress;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class GZipExample {
    public static void main(String[] args) {

        // compress a file
        Path source = Paths.get("/home/tvt/workspace/favtuts/sitemap.xml");
        Path target = Paths.get("/home/tvt/workspace/favtuts/sitemap.xml.gz");

        if (Files.notExists(source)) {
            System.err.printf("The path %s doesn't exist!", source);
            return;
        }

        try {

            GZipExample.compressGzip(source, target);

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
}
