package com.favtuts.string;

import org.apache.commons.lang3.math.NumberUtils;

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

        /*
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
        */        

        // return str.chars().allMatch(Character::isDigit);

        return NumberUtils.isDigits(str);
    }

    //This solution is working, but not recommend, performance issue.
    public static boolean isNumeric2(final String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        try {

            Integer.parseInt(str);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
