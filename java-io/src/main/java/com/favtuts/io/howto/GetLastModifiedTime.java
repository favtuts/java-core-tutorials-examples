package com.favtuts.io.howto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class GetLastModifiedTime {
    
    private static final DateTimeFormatter DATE_FORMATTER = 
        DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    
    public static void main(String[] args) {
        
        String fileName = "/home/tvt/workspace/favtuts/sample.csv";

        try {
            
            Path file = Paths.get(fileName);
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

            // default YYYY-MM-DDThh:mm:ss[.s+]Z
            System.out.println("lastModifiedTime: " + attr.lastModifiedTime());     // 2022-05-08T16:56:58.214937Z

            FileTime lastModifiedTime = (FileTime) Files.getAttribute(file, "lastModifiedTime");
            System.out.println("lastModifiedTime: " + lastModifiedTime);

            System.out.println("creationTime: " + attr.creationTime());
            System.out.println("lastAccessTime: " + attr.lastAccessTime());
            System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

            System.out.println("isDirectory: " + attr.isDirectory());
            System.out.println("isOther: " + attr.isOther());
            System.out.println("isRegularFile: " + attr.isRegularFile());
            System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
            System.out.println("size: " + attr.size());

            FileTime fileTime = attr.lastModifiedTime();
            System.out.println("lastModifiedTime: " + formatDateTime(fileTime));

            javaIO(fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String formatDateTime(FileTime fileTime) {

        LocalDateTime localDateTime = fileTime
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
        
        return localDateTime.format(DATE_FORMATTER);
    }

    public static void javaIO(String fileName) {
        File file = new File(fileName);
        System.out.println("Before format : " + file.lastModified());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println("After Format : " + sdf.format(file.lastModified()));
    }
}
