package com.favtuts.crypto.bytes;

import java.nio.charset.StandardCharsets;

public class ByteToHexExample2 {

    public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            // bytes widen to int, need mask, prevent sign extension
            // get last 8 bits
            int decimal = (int) aByte & 0xff; 

            String hex = Integer.toHexString(decimal);
            // if half hex, pad with zero, e.g \t
            if (hex.length() % 2 == 1) {
                hex = "0" + hex;
            }
            result.append(hex);
        }
        return result.toString();        
    }

    public static void main(String[] args) {

        String input = "favtuts.com";

        // 666176747574732e636f6d
        System.out.println(hex(input.getBytes(StandardCharsets.UTF_8)));

    }
}
