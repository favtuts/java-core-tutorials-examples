package com.favtuts.crypto.bytes;

public class ReverseString1 {
    
    public static void main(String[] args) {

        String str = "Reverse a String in Java";

        StringBuilder sb = new StringBuilder(str).reverse();

        System.out.println(sb.toString());

    }

}
