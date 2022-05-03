package com.favtuts.crypto.bytes;

import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class ByteToHexExample3 {

    public static String hex(byte[] bytes) {
        char[] result = Hex.encodeHex(bytes);
        return new String(result);
    }

    public static String unhex(String hex) throws DecoderException {
        return new String(Hex.decodeHex(hex));
    }

    public static void main(String[] args) throws DecoderException {

        String input = "favtuts.com";

        String hex = hex(input.getBytes(StandardCharsets.UTF_8));
        System.out.println(hex);    // 666176747574732e636f6d

        String unhex = unhex(hex);
        System.out.println(unhex);  // favtuts.com
    }
}
