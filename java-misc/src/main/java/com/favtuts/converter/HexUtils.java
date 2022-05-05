package com.favtuts.converter;

import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Hex;

public class HexUtils {

    public static String convertStringToHex(String str) {
        // display in uppercase
        //char[] chars = Hex.encodeHex(str.getBytes(StandardCharsets.UTF_8), false);

        // display in lowercase, default
        char[] chars = Hex.encodeHex(str.getBytes(StandardCharsets.UTF_8));

        return String.valueOf(chars);
    }

    public static String convertHexToString(String hex) {
        String result = "";
        try {
            byte[] bytes = Hex.decodeHex(hex);
            result = new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Hex format!");
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "a";
        System.out.println("input : " + input);

        String hex = convertStringToHex(input);
        System.out.println("hex : " + hex);

        String result = convertHexToString(hex);
        System.out.println("result : " + result); 
    }
}
