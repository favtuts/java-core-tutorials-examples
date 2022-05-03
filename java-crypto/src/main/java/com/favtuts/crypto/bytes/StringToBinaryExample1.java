package com.favtuts.crypto.bytes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringToBinaryExample1 {
    
    public static void main(String[] args) {
        
        String input = "Hello";
        String result = convertStringToBinary(input);

        System.out.println(result);

        // pretty print the binary format
        System.out.println(prettyBinary(result, 8, " ")); 
    }

    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                String.format("%8s", Integer.toBinaryString(aChar))     // char -> int, auto-cast
                    .replaceAll(" ", "0")                               // zero pads
            );
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
