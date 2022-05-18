package com.favtuts.io.howto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.StringTokenizer;

public class GetCreationDate {
    
    public static void main(String[] args) {
        String fileName = "/home/tvt/workspace/favtuts/test.txt";

        try {

            Path file = Paths.get(fileName);

            // Example 1
            /*
            BasicFileAttributes attr =
                Files.readAttributes(file, BasicFileAttributes.class);

            System.out.println("creationTime: " + attr.creationTime());
            */

            // Example 2
            FileTime creationTime =
                (FileTime) Files.getAttribute(file, "creationTime");
            
            System.out.println("creationTime: " + creationTime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileCreationDateClassic() {
        Process proc;
        BufferedReader br = null;

        try {

            proc = Runtime.getRuntime()
                  .exec("cmd /c dir c:\\logfile.log /tc");
                  
            br = new BufferedReader(
                  new InputStreamReader(proc.getInputStream()));

            String data = "";
            //it's quite stupid but work, ignore first 5 lines
            for (int i = 0; i < 6; i++) {
                data = br.readLine();
            }

            System.out.println("Extracted value : " + data);

            //split by space
            StringTokenizer st = new StringTokenizer(data);
            String date = st.nextToken(); //Get date
            String time = st.nextToken(); //Get time

            System.out.println("Creation Date  : " + date);
            System.out.println("Creation Time  : " + time);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
