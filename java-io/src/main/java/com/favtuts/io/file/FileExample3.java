package com.favtuts.io.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.favtuts.io.utils.ResourceHelper;

public class FileExample3 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = null;
        FileReader fr = null;

        String fileName = ResourceHelper.getAbsoluteFilePath("filename.txt");

        try {

            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
    }
    
}
