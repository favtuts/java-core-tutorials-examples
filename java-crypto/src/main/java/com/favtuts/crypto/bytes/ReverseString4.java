package com.favtuts.crypto.bytes;

import org.apache.commons.lang3.StringUtils;

public class ReverseString4 {

    public static void main(String[] args) {

        System.out.println(StringUtils.reverse("Hello World Java"));                // reverse string

        System.out.println(StringUtils.reverseDelimited("Hello World Java", ' '));  // reverse words

    }
}
