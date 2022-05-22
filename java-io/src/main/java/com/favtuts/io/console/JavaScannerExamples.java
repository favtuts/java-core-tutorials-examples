package com.favtuts.io.console;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaScannerExamples {

    public static void main(String[] args) {

        // Example 1
        /*
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter your name: ");
            String input = scanner.nextLine();
            System.out.println("name : " + input);

            System.out.print("Please enter your age: ");
            int age = scanner.nextInt();
            System.out.println("age : " + age);
        }
        */

        // Example 2
        /*
        String input = "1,2,3,4,5";
        try (Scanner s = new Scanner(input).useDelimiter(",")) {
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        }
        */

        // Example 3
        try (Scanner sc = new Scanner(new File("/home/tvt/workspace/favtuts/pom.xml"))) {
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
