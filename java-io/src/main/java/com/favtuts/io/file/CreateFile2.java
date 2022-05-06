package com.favtuts.io.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile2 {

    public static void main(String[] args) {
        
        String fileName = "/home/tvt/workspace/favtuts/newFile.txt";

        try {

            File file = new File(fileName);

            // true if file does no exist and was created successfully.
            // false if file is already exists
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            // Write to file
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Hello World!");
            }

            // Append mode
            // try (FileWriter writer = new FileWriter(file, true)) {
            //     writer.write("Hello World!");
            // }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
