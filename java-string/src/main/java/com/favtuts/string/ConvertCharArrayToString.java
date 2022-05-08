package com.favtuts.string;

public class ConvertCharArrayToString {

    public static void main(String[] args) {

        char[] charArrays = new char[]{'1', '2', '3', 'A', 'B', 'C'};

        String str = new String(charArrays);
        System.out.println(str);    // 123ABC

        String str2 = String.valueOf(charArrays);
        System.out.println(str2);   // 123ABC

    }
    
}
