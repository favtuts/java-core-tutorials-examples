package com.favtuts.crypto.bytes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntToBinaryExample1 {

    public static void main(String[] args) {

        int input = 10;
        String result = Integer.toBinaryString(input);
        String resultWithPadding = String.format("%32s", result).replaceAll(" ", "0");
        System.out.println(resultWithPadding);
        System.out.println(printBinary(resultWithPadding, 8, " | "));   // 00000000 | 00000000 | 00000000 | 00001010
        System.out.println(printBinary(resultWithPadding, 4, " "));     // 0000 0000 0000 0000 0000 0000 0000 1010

    }
    
    public static String printBinary(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }

        return result.stream().collect(Collectors.joining(separator));
    }
}
