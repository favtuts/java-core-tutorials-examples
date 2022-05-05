package com.favtuts.converter;

import java.nio.charset.StandardCharsets;

public class HexUtils3 {

    private static final char[] HEX_UPPER = "0123456789ABCDEF".toCharArray();
    private static final char[] HEX_LOWER = "0123456789abcdef".toCharArray();
    
    public static void main(String[] args) {

        String input = "java";
        System.out.println("input : " + input);

        String hex = convertStringToHex(input, false);
        System.out.println("hex : " + hex);

    }

    public static String convertStringToHex(String str, boolean lowercase) {

        char[] HEX_ARRAY = lowercase ? HEX_LOWER : HEX_UPPER;

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        // two chars form the hex value.
        char[] hex = new char[bytes.length * 2];

        for (int j = 0; j < bytes.length; j++) {

            // 1 byte = 8 bits,
            // upper 4 bits is the first half of hex
            // lower 4 bits is the second half of hex
            // combine both and we will get the hex value, 0A, 0B, 0C

            int v = bytes[j] & 0xFF;               // byte widened to int, need mask 0xff
                                                   // prevent sign extension for negative number

            hex[j * 2] = HEX_ARRAY[v >>> 4];       // get upper 4 bits

            hex[j * 2 + 1] = HEX_ARRAY[v & 0x0F];  // get lower 4 bits

        }

        return new String(hex);

    }

}
