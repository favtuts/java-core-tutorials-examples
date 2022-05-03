package com.favtuts.crypto.bytes;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringToBinaryExample3 {
    
    public static void main(String[] args) {
        String input = "01001000 01100101 01101100 01101100 01101111";

        // Java 8 makes life easier
        String raw = Arrays.stream(input.split(" "))
                .map(binary -> Integer.parseInt(binary, 2))
                .map(Character::toString)
                .collect(Collectors.joining()); // cut the space
        
        System.out.println(raw);
    }
}
