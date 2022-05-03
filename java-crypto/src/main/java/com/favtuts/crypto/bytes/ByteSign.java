package com.favtuts.crypto.bytes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ByteSign {

    public static final String OUTPUT_FORMAT = "%32s";

    public static String printBinary(int number) {
        return printBinary(number, 8, "|");
    }

    public static String printBinary(int number, int blockSize, String separator) {

        // pad leading zero
        String pBinary = String
            .format(OUTPUT_FORMAT, Integer.toBinaryString(number))
            .replace(" ", "0");
        
        // split by blockSize
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < pBinary.length()) {
            result.add(pBinary.substring(index, Math.min(index + blockSize, pBinary.length())));
            index += blockSize;
        }

        return result.stream().collect(Collectors.joining(separator));
    }
    
    public static void main(String[] args) {
        
        String STRING_FORMAT = "%-10s = %s";

        int number = 24;
        System.out.println("Input Number");
        System.out.println(Integer.toBinaryString(number));
        String pBinary = String
            .format(OUTPUT_FORMAT, Integer.toBinaryString(number))
            .replace(" ", "0");
        System.out.println(pBinary);

        System.out.println("Positive Number");
        System.out.println(String.format(STRING_FORMAT, "Input " + number, printBinary(number)));
        System.out.println(String.format(STRING_FORMAT, number + " >> 2", printBinary(number >> 2)));      
        System.out.println(String.format(STRING_FORMAT, number + " >>> 2", printBinary(number >>> 2)));

        int number2 = -19;

        System.out.println("\nNegative Number");
        System.out.println(String.format(STRING_FORMAT, "Input " + number2, printBinary(number2)));
        System.out.println(String.format(STRING_FORMAT, number2 + " >> 2", printBinary(number2 >> 2)));
        System.out.println(String.format(STRING_FORMAT, number2 + " >>> 2", printBinary(number2 >>> 2)));
    }
}
