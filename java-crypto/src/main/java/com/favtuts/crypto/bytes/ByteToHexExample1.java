package com.favtuts.crypto.bytes;

import java.nio.charset.StandardCharsets;

public class ByteToHexExample1 {
    
    public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
            // upper case
            // result.append(String.format("%02X", aByte));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "favtuts.com";

        // 666176747574732e636f6d
        System.out.println(hex(input.getBytes(StandardCharsets.UTF_8)));
    }
}
