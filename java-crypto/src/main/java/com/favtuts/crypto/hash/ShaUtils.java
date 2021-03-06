package com.favtuts.crypto.hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.favtuts.crypto.utils.CryptoUtils;

import org.apache.commons.codec.digest.DigestUtils;

public class ShaUtils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";

    public static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }

        byte[] result = md.digest(input);
        return result;
    }

    private static byte[] checksum(String filePath, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }

        try (InputStream is = new FileInputStream(filePath); 
            DigestInputStream dis = new DigestInputStream(is, md)) {
            while (dis.read() != -1) ; //empty loop to clear the data
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return md.digest();
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //String algorithm = "SHA-256"; // if you perfer SHA-2
        String algorithm = "SHA3-256";
        String pText = "Hello World";
        // String pText = "Hello SHA Hashing"; //Try hash another string, differ length, for SHA3-256, the output fixed to 256 bits, 32 bytes.

        System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
        System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText.length()));

        byte[] shaInBytes = ShaUtils.digest(pText.getBytes(UTF_8), algorithm);
        System.out.println(String.format(OUTPUT_FORMAT, algorithm + " (hex) ", bytesToHex(shaInBytes)));

        // fixed length, 32 bytes, 256 bits.
        System.out.println(String.format(OUTPUT_FORMAT, algorithm + " (length)", shaInBytes.length));


        // examples using Apache Commons Codec
        byte[] hash1 = DigestUtils.sha256(pText);           // returns byte arrays
        String hash2 = DigestUtils.sha256Hex(pText);        // returns encoded hex
        System.out.println(hash2);

        byte[] hash3 = DigestUtils.sha3_256(pText);         // return byte arrays
        String hash4 = DigestUtils.sha3_256Hex(pText);    // returns encoded hex
        System.out.println(hash4);

        
        // get file path from resources
        String filePath = ClassLoader.getSystemResource("sha-file.txt").getFile();
        System.out.println("Resourc path: " + filePath);
        byte[] hashInBytes = checksum(filePath, algorithm);
        System.out.println(String.format(OUTPUT_FORMAT, "Checksum sha-file.txt", bytesToHex(hashInBytes)));

        // get a 16 bytes random salt
        byte[] salt = CryptoUtils.getRandomNonce(16);
        byte[] text = "Hello World".getBytes(StandardCharsets.UTF_8);

        // combine two byte array
        byte[] input = ByteBuffer.allocate(salt.length + text.length)
            .put(salt)
            .put(text)
            .array();
        
        // no salt, SHA3-256
        System.out.println(bytesToHex(ShaUtils.digest(text, "SHA3-256")));


        // 16 bytes salt, SHA3-256
        System.out.println(bytesToHex(ShaUtils.digest(input, "SHA3-256")));
    }
    
}
