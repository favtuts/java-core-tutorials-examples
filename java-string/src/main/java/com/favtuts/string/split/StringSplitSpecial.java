package com.favtuts.string.split;

public class StringSplitSpecial {
    public static void main(String[] args) {
        String csv = "a|b|c|d";
        String[] output = csv.split("|");

        for (String s : output) {
            System.out.println(s);
        }
    }
}
