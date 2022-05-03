package com.favtuts.crypto.bytes;

public class ReverseString2 {

    public static void main(String[] args) {

        String str = "Hello World";
        System.out.println(reverse(str));         //  dlroW olleH

    }

    public static String reverse(String input) {
        if (input == null || input.length() < 0)
            throw new IllegalArgumentException("Please provide an input");
        
        char[] result = input.toCharArray();

        int startIndex = 0;
        int endIndex = result.length - 1;
        char temp;
        
        for (; endIndex > startIndex; startIndex++, endIndex--) {
            temp = result[startIndex];
            result[startIndex] = result[endIndex];
            result[endIndex] = temp;
        }

        return new String(result);
    }
    
}
