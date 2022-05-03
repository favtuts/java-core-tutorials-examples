package com.favtuts.crypto.bytes;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnicodeToBinary1 {

    public static void main(String[] args) {
        byte[] input = "你".getBytes(StandardCharsets.UTF_8);
        System.out.println(input.length);                       // 3, 1 Chinese character = 3 bytes
        String binary = convertByteArraysToBinary(input);
        System.out.println(binary);
        System.out.println(prettyBinary(binary, 8, " "));
    }
    
    public static String convertByteArraysToBinary(byte[] input) {

        StringBuilder result = new StringBuilder();
        for (byte b : input) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                result.append((val & 128) == 0 ? 0 : 1);      // 128 = 1000 0000
                val <<= 1;
            }
        }
        return result.toString();
    }

    public static String prettyBinary(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }

        return result.stream().collect(Collectors.joining(separator));
        
    }
}
