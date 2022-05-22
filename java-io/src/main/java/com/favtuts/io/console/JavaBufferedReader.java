package com.favtuts.io.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaBufferedReader {
    public static void main(String[] args) {

        // jdk 1.7
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String input = "";
            while (!"q".equalsIgnoreCase(input)) {

                System.out.print("Enter something (q to quite): ");

                input = br.readLine();
                System.out.println("input : " + input);
            }

            System.out.println("bye bye!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
