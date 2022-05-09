package com.favtuts.io.howto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class UpdateLastModifiedTime {

    public static void main(String[] args) throws IOException {
        
        String fileName = "/home/tvt/workspace/favtuts/google.png";
        Path file = Paths.get(fileName);
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        FileTime lastModifiedTime = attr.lastModifiedTime();

        // print original last modified time
        System.out.println("[original] lastModifiedTime: " + lastModifiedTime);

        LocalDate newLocalDate = LocalDate.of(1998, 9, 30);
        // convert LocalDate to instant, need time zone
        Instant instant = newLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

        // convert instant to filetime
        // update last modified time
        Files.setLastModifiedTime(file, FileTime.from(instant));

        // read last modified time again
        FileTime newLastModifiedTime = Files.readAttributes(file, BasicFileAttributes.class).lastModifiedTime();
        System.out.println("[updated] lastModifiedTime : " + newLastModifiedTime);
    }
    
}
