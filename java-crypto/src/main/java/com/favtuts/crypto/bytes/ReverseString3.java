package com.favtuts.crypto.bytes;

import java.nio.charset.StandardCharsets;

public class ReverseString3 {

    public static void main(String[] args) {

        String str = "Hello World";
        System.out.println(reverse(str));

    }

    public static String reverse(String input) {

        if (input == null || input.length() < 0)
            throw new IllegalArgumentException("Please provide an input!");

        byte[] val = input.getBytes(StandardCharsets.UTF_8);
        int length = val.length - 1;

        for (int start = (length - 1) >> 1; start >= 0; start--) {
            int end = length - start;
            byte temp = val[start];
            val[start] = val[end];
            val[end] = temp;

            // debugging
            //System.out.println(String.format("start=%s, end=%s", start, end));
        }

        return new String(val);
    }
}
