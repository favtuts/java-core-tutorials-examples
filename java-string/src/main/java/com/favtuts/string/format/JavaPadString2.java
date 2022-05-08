package com.favtuts.string.format;

import org.apache.commons.lang3.StringUtils;

public class JavaPadString2 {
    
    public static void main(String[] args) {
        
        String input = "I Love Java!";

        String result4 = StringUtils.leftPad(input, 20, "*");

        String result5 = StringUtils.rightPad(input, 20, "*");

        String result6 = StringUtils.center(input, 20, "*");

        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        
    }
}
