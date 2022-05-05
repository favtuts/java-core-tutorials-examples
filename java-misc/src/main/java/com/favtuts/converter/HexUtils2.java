package com.favtuts.converter;

public class HexUtils2 {
    
    // Char -> Decimal -> Hex
    public static String convertStringToHex(String str) {
        StringBuilder hex = new StringBuilder();

        // loop chars one by one
        for (char temp : str.toCharArray()) {
            // convert char to int, for char 'a' decimal 97
            int decimal = (int) temp;

            // convert int to hex, for decimal 97 hex 61
            hex.append(Integer.toHexString(decimal));
        }

        return hex.toString();
    }

    // Hex -> Decimal -> Char
    public static String convertHexToString(String hex) {
        StringBuilder result = new StringBuilder();

        // split into two chars per loop, hex, 0A, 0B, 0C...
        for (int i = 0; i < hex.length() - 1; i += 2) {
            String tempInHex = hex.substring(i, (i + 2));

            // convert hex to decimal
            int decimal = Integer.parseInt(tempInHex, 16);

            // convert the decimal to char
            result.append((char) decimal);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "a";
        // String input = "java";
        System.out.println("input : " + input);

        String hex = convertStringToHex(input);
        System.out.println("hex : " + hex);

        String result = convertHexToString(hex);
        System.out.println("result : " + result);
    }
}
