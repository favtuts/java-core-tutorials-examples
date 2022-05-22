package com.favtuts.classic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {

    public static void main(String[] args) {
        

        // Example 1:  close the BufferedReader manually
        /*
        BufferedReader br = null;
        String line;

        try {

            br = new BufferedReader(new FileReader("C:\\testing.txt"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        */

        // Example 2: try-with-resources block
        String line;

        try (BufferedReader br = new BufferedReader(
                new FileReader("C:\\testing.txt"))) {

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

		// br will be closed automatically
    }
    
}
