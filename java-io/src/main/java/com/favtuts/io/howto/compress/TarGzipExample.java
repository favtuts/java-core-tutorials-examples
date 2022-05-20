package com.favtuts.io.howto.compress;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TarGzipExample {

    public static void main(String[] args) {

        try {

            Path path1 = Paths.get("/home/tvt/workspace/favtuts/sitemap.xml");
            Path path2 = Paths.get("/home/tvt/workspace/favtuts/file.txt");
            Path output = Paths.get("/home/tvt/workspace/favtuts/output.tar.gz");

            List<Path> paths = Arrays.asList(path1, path2);
            createTarGzipFiles(paths, output);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }

    // tar.gz few files
    public static void createTarGzipFiles(List<Path> paths, Path output)
        throws IOException {

        try (OutputStream fOut = Files.newOutputStream(output);
             BufferedOutputStream buffOut = new BufferedOutputStream(fOut);
             GzipCompressorOutputStream gzOut = new GzipCompressorOutputStream(buffOut);
             TarArchiveOutputStream tOut = new TarArchiveOutputStream(gzOut)) {

            for (Path path : paths) {

                if (!Files.isRegularFile(path)) {
                    throw new IOException("Support only file!");
                }

                TarArchiveEntry tarEntry = new TarArchiveEntry(
                                                  path.toFile(),
                                                  path.getFileName().toString());

                tOut.putArchiveEntry(tarEntry);

                // copy file to TarArchiveOutputStream
                Files.copy(path, tOut);

                tOut.closeArchiveEntry();

            }

            tOut.finish();

        }

    }

}