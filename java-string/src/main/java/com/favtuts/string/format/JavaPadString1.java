package com.favtuts.string.format;

public class JavaPadString1 {

    public static void main(String[] args) {

        String input = "I Love Java!";

        // I Love Java!
        String result1 = String.format("%s", input);

        // pad 20 chars
        String result2 = String.format("|%20s|", input);    // |        I Love Java!|

        String result3 = String.format("|%-20s|", input);   // |I Love Java!        |

        // ********I*Love*Java!
        String result4 = String.format("%20s", input).replace(" ", "*");

        // I*Love*Java!********
        String result5 = String.format("%-20s", input).replace(" ", "*");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

    }
    
}
