package com.favtuts.io.howto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileToBytes {
    
    public static void main(String[] args) {
        try {
            String filePath = "/home/tvt/workspace/favtuts/phone.png";

            // file to bytes[]
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));

            // bytes[] to file
            Path path = Paths.get("/home/tvt/workspace/favtuts/phone2.png");
            Files.write(path, bytes);

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
