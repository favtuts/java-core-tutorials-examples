package com.favtuts.string;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ConvertStringToBytes {
    
    public static void main(String[] args) {
        String example = "This is an example";

        // the best , java 1.7+
        byte[] output = example.getBytes(StandardCharsets.UTF_8);

        System.out.println("Text : " + example);

        String based64encoded = Base64.getEncoder().encodeToString(output);

        System.out.println("Text [Base64] : " + based64encoded);
    }
}
