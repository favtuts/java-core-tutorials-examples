package com.favtuts.string.format;

public class JavaStringFormat1 {

    public static void main(String[] args) {
        
        String result = String.format("%s is %d", "favtuts", 38);   //favtuts is 38
        System.out.println(result);

        String result2 = String.format("%d + %d = %d", 1, 1, 1+1);  // 1 + 1 = 2
        System.out.println(result2);

        String result3 = String.format("%s = %f", "PI", Math.PI);   // PI = 3.141593
        String result4 = String.format("%s = %.3f", "PI", Math.PI); // PI = 3.142
        System.out.println(result3);
        System.out.println(result4);
    }
    
}
