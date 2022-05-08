package com.favtuts.string;

public class ConvertCharToString {

    public static void main(String[] args) {
        
        String website = "http://www.favtuts.com";

        //convert a String into char
        char charH = website.charAt(0); //h
        char charP = website.charAt(3);//p
        char charF = website.charAt(11);//f
        System.out.println(charH);
        System.out.println(charP);
        System.out.println(charF);

        //convert char back to String
        String temp = Character.toString(charF);

        if ("f".equals(temp)) {
            System.out.println("match");
        }

    }
    
}
