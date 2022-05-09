package com.favtuts.string;

public class StringAndSubstring {

    public static void main(String[] args) {
        
        String name = "favtuts is learning Java 123";

        System.out.println(name.contains("Java"));      // true
        System.out.println(name.contains("java"));      // false
        System.out.println(name.contains("FAVTUTS"));    // false
        System.out.println(name.contains("favtuts"));    // true

        if (name.contains("Java")) {
            System.out.println("Hello Java");
        } else {
            System.out.println("abc...");
        }

        System.out.println(containsIgnoreCase(name, "Java"));      // true
        System.out.println(containsIgnoreCase(name, "java"));      // true
        System.out.println(containsIgnoreCase(name, "FAVTUTS"));    // true
        System.out.println(containsIgnoreCase(name, "favtuts"));    // true

        if (name.indexOf("Java") != -1) {
            System.out.println("Hello Java"); // print this
        } else {
            System.out.println("abc...");
        }
    }

    public static boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }
    
}
