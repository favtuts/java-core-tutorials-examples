package com.favtuts.io.console;

import java.util.Scanner;

public class JavaScanner {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = "";
        while (!"q".equalsIgnoreCase(input)) {

            System.out.print("Enter something (q to quite): ");

            input = scanner.nextLine();
            System.out.println("input : " + input);
        }

        System.out.println("bye bye!");
    }
    
}
