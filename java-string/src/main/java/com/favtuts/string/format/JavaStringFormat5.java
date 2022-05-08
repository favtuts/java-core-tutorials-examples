package com.favtuts.string.format;

public class JavaStringFormat5 {

    public static void main(String[] args) {
        
        double pi = Math.PI;

        // default
        String result1 = String.format("%f", pi);       // 3.141593

        // 2 decimal points
        String result2 = String.format("%.2f", pi);     // 3.14

        String result3 = String.format("%e", pi);       // 3.141593e+00

        String result4 = String.format("%a", pi);       // 0x1.921fb54442d18p1

        // right
        String result5 = String.format("|%20f|", pi);   // |            3.141593|

        // left
        String result6 = String.format("|%-20f|", pi);  // |3.141593            |

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        
    }
    
}
