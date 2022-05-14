package com.favtuts.io.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileExample {

    public static void main(String[] args) {
        // writeFileClassic();
        writeFileJava7();
    }

    private static void writeFileJava7() {

        File file = new File("/home/tvt/workspace/favtuts/writefile.txt");
        String content = "This is the text content";

        try (FileOutputStream fop = new FileOutputStream(file)) {
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFileClassic() {

        FileOutputStream fop = null;
        File file;
        String content = "This is the text content";

        try {

            file = new File("/home/tvt/workspace/favtuts/writefile.txt");
            fop = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
