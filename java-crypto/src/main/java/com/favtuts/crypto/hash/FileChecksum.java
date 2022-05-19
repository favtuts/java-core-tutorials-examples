package com.favtuts.crypto.hash;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileChecksum {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        
        //MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA, MD2, MD5, SHA-256, SHA-384...
        MessageDigest md = MessageDigest.getInstance("MD5"); 
        String hex = checksum("/home/tvt/workspace/favtuts/server.log", md);
        System.out.println(hex);
    }
    
    private static String checksum(String filepath, MessageDigest md) throws IOException {

        // // file hashing with DigestInputStream
        // try (DigestInputStream dis = new DigestInputStream(new FileInputStream(filepath), md)) {
        //     while(dis.read() != -1) ; // empty loop to clear the data
        //     md = dis.getMessageDigest();
        // }

        // DigestInputStream is better, but you also can hash file like this.
        try (InputStream fis = new FileInputStream(filepath)) {
            byte[] buffer = new byte[1024];
            int nread;
            while ((nread = fis.read(buffer)) != -1) {
                md.update(buffer, 0, nread);
            }
        }

        // bytes to hex
        StringBuilder result  = new StringBuilder();
        for (byte b : md.digest()) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }


}
