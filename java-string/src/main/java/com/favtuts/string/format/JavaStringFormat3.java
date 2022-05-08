package com.favtuts.string.format;

public class JavaStringFormat3 {
    
    public static void main(String[] args) {
    
        String input = "Hello World";

        // default
        String result1 = String.format("|%s|", input);              // |Hello World|

        // this %s has lengh of 20, format as %20s, pad 20 characters
        // default right-justified
        String result2 = String.format("|%20s|", "Hello World");    // |         Hello World|

        // left-justified
        String result3 = String.format("|%-20s|", "Hello World");   // |Hello World         |

        // max length = 5
        String result4 = String.format("|%.5s|", "Hello World");    // |Hello|

        // left pad with $
        String result5 = String.format("|%20s|", "Hello World")     // |$$$$$$$$$Hello$World|        
            .replace(' ', '$');

        // left pad with $, ignore spaces in string
        String result6 = padLeft("Hello World", 20, "$");           // $$$$$$$$$Hello World

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);

    }

    public static String padLeft(String str, int width, String padWith) {

        String result = "";
        String temp = String.format("%" + width + "s", str);
        if (temp.length() > str.length()) {
            // cut the left part for padding
            result = temp.substring(0, temp.length() - str.length()).replace(" ", padWith);
        }
        str = temp;
        result += str;
        return result;
    }

}
