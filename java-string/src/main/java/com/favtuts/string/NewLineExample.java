package com.favtuts.string;

public class NewLineExample {

    public static void main(String[] args) {

        // Example 1: use  line separator string 
        // UNIX, Linux or Mac OSX = \n
        // Windows = \r\n
        /*
        String original = "Hello World Java";

        System.out.println(original);

		// add new line
        String originalNewLine = "Hello\nWorld\nJava";

        System.out.println(originalNewLine);
        */

        // Example 2: 
        // use the Java 1.7 System.lineSeparator to return the system-dependent new line
        String original = "Hello World Java";

        System.out.println(original);

        String originalNewLine = "Hello"
                + System.lineSeparator() + "World"
                + System.lineSeparator() + "Java";

        System.out.println(originalNewLine);
    }
    
}
