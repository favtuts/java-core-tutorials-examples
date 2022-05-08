package com.favtuts.string.format;

public class JavaStringFormat4 {

    public static void main(String[] args) {
        
        // default
        String result1 = String.format("|%d|", 100);                // |100|

        // this %d has length of 20, format as %20d, pad 20 characters
        // default right-justified
        String result2 = String.format("|%20d|", 100);              // |                 100|

        // left-justified
        String result3 = String.format("|%-20d|", 100);             // |100                 |

        // left pad with 0
        String result4 = String.format("|%020d|", 100);             // |00000000000000000100|

        // prefix with +
        String result5 = String.format("|%+20d|", 100);             // |                +100|

        // negative
        String result6 = String.format("|%20d|", -100);             // |                -100|

        // octal
        String result7 = String.format("|%20o|", 100);              // |                 144|

        // hex
        String result8 = String.format("|%20x|", 30);               // |                  1e|

        // prefix 0x with #
        String result9 = String.format("|%#20x|", 30);              // |                0x1e|

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);

    }
    
}
