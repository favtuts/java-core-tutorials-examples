package com.favtuts.io.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileBufferedWriter {

    public static void main(String[] args) {
        
        //writeFileBufferedWriterJava7();
        writeFileBufferedWriterClassic();
    }

    private static void writeFileBufferedWriterClassic() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = "This is the content to write into file\n";

            fw = new FileWriter("app.log");
            //fw = new FileWriter("app.log", true);  Append mode
            bw = new BufferedWriter(fw);
            bw.write(content);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
    }
    

    private static void writeFileBufferedWriterJava7(){
        String content = "This is the content to write into file\n";

        // If the file doesn't exists, create and write to it
        // If the file exists, truncate (remove all content) and write to it
        try (FileWriter writer = new FileWriter("app.log");
            BufferedWriter bw = new BufferedWriter(writer)
        ) {

            bw.write(content);
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
