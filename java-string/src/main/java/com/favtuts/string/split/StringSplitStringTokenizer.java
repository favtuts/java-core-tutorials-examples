package com.favtuts.string.split;

import java.util.StringTokenizer;

public class StringSplitStringTokenizer {
    public static void main(String[] args) {

        String test = "abc.def.123";
        // the delimiter is a string, not regex, no need to escape the dot
        StringTokenizer token = new StringTokenizer(test, ".");

        while (token.hasMoreTokens()) {
            System.out.println(token.nextToken());
        }

    }
}
