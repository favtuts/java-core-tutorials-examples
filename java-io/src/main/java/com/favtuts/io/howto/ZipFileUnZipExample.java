package com.favtuts.io.howto;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.*;


public class ZipFileUnZipExample {

    public static void main(String[] args) {

        // Path source = Paths.get("/home/tvt/workspace/favtuts/test-files-only.zip");
        Path source = Paths.get("/home/tvt/workspace/favtuts/test-files-folders.zip");
        Path target = Paths.get("/home/tvt/workspace/favtuts/zip/");

        try {

            //unzipFolder(source, target);
            unzipFolderZip4j(source, target);
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unzipFolder(Path source, Path target) throws IOException {

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source.toFile()))) {

            // list files in zip
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {

                boolean isDirectory = false;
                // example 1.1
                // some zip stored files and folders separately
                // e.g data/
                // data/folder/
                // data/folder/file.txt
                if (zipEntry.getName().endsWith(File.separator)) {
                    isDirectory = true;
                }

                Path newPath = zipSlipProtect(zipEntry, target);

                if (isDirectory) {
                    Files.createDirectories(newPath);
                } else {

                    // example 1.2
                    // some zip stored file path only, need create parent directories
                    // e.g data/folder/file.txt
                    if (newPath.getParent() != null) {
                        if (Files.notExists(newPath.getParent())) {
                            Files.createDirectories(newPath.getParent());
                        }
                    }

                    // copy files, nio
                    Files.copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);

                    // copy files, classic
                    /*
                     * try (FileOutputStream fos = new FileOutputStream(newPath.toFile())) {
                     * byte[] buffer = new byte[1024];
                     * int len;
                     * while ((len = zis.read(buffer)) > 0) {
                     * fos.write(buffer, 0, len);
                     * }
                     * }
                     */
                }

                zipEntry = zis.getNextEntry();

            }
            zis.closeEntry();

        }

    }

    // protect zip slip attack
    public static Path zipSlipProtect(ZipEntry zipEntry, Path targetDir)
            throws IOException {

        // test zip slip vulnerability
        // Path targetDirResolved = targetDir.resolve("../../" + zipEntry.getName());

        Path targetDirResolved = targetDir.resolve(zipEntry.getName());

        // make sure normalized file still has targetDir as its prefix
        // else throws exception
        Path normalizePath = targetDirResolved.normalize();
        if (!normalizePath.startsWith(targetDir)) {
            throw new IOException("Bad zip entry: " + zipEntry.getName());
        }

        return normalizePath;
    }

    // it takes `File` as arguments
    public static void unzipFolderZip4j(Path source, Path target)
            throws IOException {

        new ZipFile(source.toFile())
                .extractAll(target.toString());

    }
}
