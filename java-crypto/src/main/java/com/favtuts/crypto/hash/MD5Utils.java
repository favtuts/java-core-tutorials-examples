package com.favtuts.crypto.hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    private static byte[] digest(byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }

        byte[] result = md.digest(input);
        return result;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static byte[] checksum(String filePath) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }

        try (InputStream is = new FileInputStream(filePath);
             DigestInputStream dis = new DigestInputStream(is, md)) {
            while (dis.read() != -1) ; //empty loop to clear the data
            md = dis.getMessageDigest();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return md.digest();
    }

    public static void main(String[] args) {
        String pText = "Hello MD5";
        System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
        System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText.length()));

        byte[] md5InBytes = MD5Utils.digest(pText.getBytes(UTF_8));
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (hex) ", bytesToHex(md5InBytes)));
        // fixed length, 16 bytes, 128 bits.
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (length)", md5InBytes.length));

        // get file path from resources
        System.out.println("------");
        String filePath = ClassLoader.getSystemResource("readme.txt").getFile();
        System.out.println(String.format(OUTPUT_FORMAT, "Input (file) ", filePath));
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (checksum hex) ", bytesToHex(checksum(filePath))));

        // commons-codec
        System.out.println("------");
        System.out.println(String.format(OUTPUT_FORMAT, "MD5 (hex)", DigestUtils.md5Hex(pText)));

        // commons-codec
        try (InputStream is = new FileInputStream(filePath)) {
            String checksum = DigestUtils.md5Hex(is);
            System.out.println(String.format(OUTPUT_FORMAT, "MD5 (checksum hex) ", checksum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
