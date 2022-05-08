package com.favtuts.string;

public class ConvertStringToCharArray {

    public static void main(String[] args) {
        
        String password = "password123";

        char[] passwordInCharArray = password.toCharArray();

        for (char temp : passwordInCharArray) {
            System.out.println(temp);
        }        
        
    }    
}
