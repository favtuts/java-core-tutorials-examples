package com.favtuts.crypto.utils;

import java.security.SecureRandom;

public class CryptoUtils {
    
    public static byte[] getRandomNonce(int numBytes) {
        byte[] nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }
}
