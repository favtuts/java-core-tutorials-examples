package com.favtuts.crypto.bytes;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class UnicodeToBinary2 {

    public static void main(String[] args) {

        String binary = "111001001011110110100000";     // 你, Chinese character
        String result = binaryUnicodeToString(binary);
        System.out.println(result.trim());

    }
    
    // <= 32bits = 4 bytes, int needs 4 bytes
    public static String binaryUnicodeToString(String binary) {
        byte[] array = ByteBuffer.allocate(4).putInt(
            Integer.parseInt(binary, 2)
        ).array();

        return new String(array, StandardCharsets.UTF_8);
    }
}
