package com.favtuts.io.console;

import java.io.Console;

public class JavaConsole {
    public static void main(String[] args) {

        // jdk 1.6
        Console console = System.console();

        String input = "";
        while (!"q".equalsIgnoreCase(input)) {

            System.out.print("Enter something (q to quite): ");

            input = console.readLine();
            System.out.println("input : " + input);
        }

        System.out.println("bye bye!");

      
        System.out.print("Enter your name: ");
        String name = console.readLine();
        System.out.println("Name is: " + name);

        System.out.print("Enter your password: ");

        // Reads a password from the console with echoing disabled
        char[] password = console.readPassword();
        String passwordStr = String.valueOf(password); // char[] to String;
        System.out.println("Password is: " + passwordStr);
    }
}
