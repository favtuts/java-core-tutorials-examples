package com.favtuts.io.temp;

public class TempFilePath {

    public static void main(String[] args) {

        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println("Temp file path: " + tmpdir);

    }
    
}
