package com.favtuts.string;

public class NumericExample {
    public static void main(String[] args) {

        System.out.println(isNumeric(""));          // false
        System.out.println(isNumeric(" "));         // false
        System.out.println(isNumeric(null));        // false
        System.out.println(isNumeric("1,200"));     // false
        System.out.println(isNumeric("1"));         // true
        System.out.println(isNumeric("200"));       // true
        System.out.println(isNumeric("3000.00"));   // false

    }

    public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
