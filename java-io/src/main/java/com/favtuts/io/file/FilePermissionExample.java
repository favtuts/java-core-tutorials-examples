package com.favtuts.io.file;

import java.io.File;
import java.io.IOException;

public class FilePermissionExample {
    public static void main(String[] args) {
        try {
            File file = new File("/home/tvt/workspace/favtuts/shellscript.sh");

            if (file.exists()) {
                System.out.println("Is Execute allow : " + file.canExecute());
                System.out.println("Is Write allow : " + file.canWrite());
                System.out.println("Is Read allow : " + file.canRead());
            }

            file.setExecutable(true);
            file.setReadable(false);
            file.setWritable(false);

            System.out.println("Is Execute allow : " + file.canExecute());
            System.out.println("Is Write allow : " + file.canWrite());
            System.out.println("Is Read allow : " + file.canRead());

            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
