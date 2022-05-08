package com.favtuts.string;

// A Java example to show you how to convert a Char into a String and vise verse.
public class ConvertCharToString {

    public static void main(String[] args) {
        
        String website = "http://www.favtuts.com";

        //convert a String into char
        char charH = website.charAt(0); //h
        char charP = website.charAt(3);//p
        char charM = website.charAt(11);//m
        System.out.println(charH);
        System.out.println(charP);
        System.out.println(charM);

        //convert char back to String
        String temp = Character.toString(charM);

        if ("f".equals(temp)) {
            System.out.println("match");
        }

    }
    
}
