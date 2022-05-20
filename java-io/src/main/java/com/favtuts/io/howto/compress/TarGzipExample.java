package com.favtuts.io.howto.compress;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class TarGzipExample {

    public static void main(String[] args) {

        try {

            /*
            Path path1 = Paths.get("/home/tvt/workspace/favtuts/sitemap.xml");
            Path path2 = Paths.get("/home/tvt/workspace/favtuts/file.txt");
            Path output = Paths.get("/home/tvt/workspace/favtuts/output.tar.gz");

            List<Path> paths = Arrays.asList(path1, path2);
            createTarGzipFiles(paths, output);
            */

            // tar.gz a folder
            Path source = Paths.get("/home/tvt/workspace/favtuts/test");
            createTarGzipFolder(source);

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

    // generate .tar.gz file at the current working directory
    // tar.gz a folder
    public static void createTarGzipFolder(Path source) throws IOException {

        if (!Files.isDirectory(source)) {
            throw new IOException("Please provide a directory.");
        }

        // get folder name as zip file name
        String tarFileName = source.getFileName().toString() + ".tar.gz";

        try (OutputStream fOut = Files.newOutputStream(Paths.get(tarFileName));
             BufferedOutputStream buffOut = new BufferedOutputStream(fOut);
             GzipCompressorOutputStream gzOut = new GzipCompressorOutputStream(buffOut);
             TarArchiveOutputStream tOut = new TarArchiveOutputStream(gzOut)) {

            Files.walkFileTree(source, new SimpleFileVisitor<>() {

                @Override
                public FileVisitResult visitFile(Path file,
                                            BasicFileAttributes attributes) {

                    // only copy files, no symbolic links
                    if (attributes.isSymbolicLink()) {
                        return FileVisitResult.CONTINUE;
                    }

                    // get filename
                    Path targetFile = source.relativize(file);

                    try {
                        TarArchiveEntry tarEntry = new TarArchiveEntry(
                                file.toFile(), targetFile.toString());

                        tOut.putArchiveEntry(tarEntry);

                        Files.copy(file, tOut);

                        tOut.closeArchiveEntry();

                        System.out.printf("file : %s%n", file);

                    } catch (IOException e) {
                        System.err.printf("Unable to tar.gz : %s%n%s%n", file, e);
                    }

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    System.err.printf("Unable to tar.gz : %s%n%s%n", file, exc);
                    return FileVisitResult.CONTINUE;
                }

            });

            tOut.finish();
        }

    }

}