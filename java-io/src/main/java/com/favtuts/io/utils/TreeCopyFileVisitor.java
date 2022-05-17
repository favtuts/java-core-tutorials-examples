package com.favtuts.io.utils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TreeCopyFileVisitor extends SimpleFileVisitor<Path> {

    private Path source;
    private final Path target;

    public TreeCopyFileVisitor(String source, String target) {
        this.source = Paths.get(source);
        this.target = Paths.get(target);
    }

    /**
     * source = /home/favtuts/test, dir = /home/favtuts/test/subtest , relativize = subtest
     * System.out.println(source.relativize(dir));
     *
     * target = /home/favtuts/test2, relativize = subtest , resolve = /home/favtuts/test2/subtest
     * System.out.println(target.resolve(source.relativize(dir)));
     */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        
        Path resolve = target.resolve(source.relativize(dir));
        if (Files.notExists(resolve)) {
            Files.createDirectories(resolve);
            System.out.println("Create directories : " + resolve);
        }
        return FileVisitResult.CONTINUE;

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        
        Path resolve = target.resolve(source.relativize(file));
        Files.copy(file, resolve, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(
            String.format("Copy File from \t'%s' to \t'%s'", file, resolve)
        );
        return FileVisitResult.CONTINUE;

    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.format("Unable to copy: %s: %s%n", file, exc);
        return FileVisitResult.CONTINUE;
    }
    
}
