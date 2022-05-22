package com.favtuts.io.directory;

import java.io.File;

public class DirectoryCheckEmpty {
    public static void main(String[] args) {

        File file = new File("/home/tvt/workspace/favtuts/test");

        if (file.isDirectory()) {

            if (file.list().length > 0) {

                System.out.println("Directory is not empty!");

            } else {

                System.out.println("Directory is empty!");

            }

        } else {

            System.out.println("This is not a directory");

        }
    }
}
