package com.favtuts.crypto.bytes;

import java.nio.charset.StandardCharsets;

import org.springframework.security.crypto.codec.Hex;

public class ByteToHexExample4 {
    
    public static void main(String[] args) {
        String input = "favtuts.com";

        char[] encode = Hex.encode(input.getBytes(StandardCharsets.UTF_8));
        String hex = new String(encode);
        System.out.println(hex);                // 666176747574732e636f6d

        byte[] decode = Hex.decode(hex);
        System.out.println(new String(decode)); // favtuts.com
    }
}
