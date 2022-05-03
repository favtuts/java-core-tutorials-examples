package com.favtuts.crypto.bytes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntToBinaryExample2 {

    public static void main(String[] args) {

        int input = 10;
        String result = convertIntToBinaryString(input);
        String resultWithPadding = String.format("%32s", result).replaceAll(" ", "0");
        System.out.println(printBinary(resultWithPadding, 8, " - "));

    }

    public static String convertIntToBinaryString(int number) {

        StringBuilder result = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");
        }
        return result.toString();

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
