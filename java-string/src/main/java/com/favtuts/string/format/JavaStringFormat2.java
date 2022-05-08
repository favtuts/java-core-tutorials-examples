package com.favtuts.string.format;

public class JavaStringFormat2 {

    public static void main(String[] args) {
        
        String a1 = "hello1";
        String a2 = "hello2";
        Integer a3 = 333;

        String result = String.format("Test: %3$d, %1$s, %1$s, %2$s", a1, a2, a3);
        System.out.println(result);
    }
    
}
