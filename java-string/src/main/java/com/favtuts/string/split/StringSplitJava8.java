package com.favtuts.string.split;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSplitJava8 {
    public static void main(String[] args) {

        String phone = "012-3456789";

        // Normal String#split
        // String[] output = phone.split("-");

        // Java 8 splitAsStream
        List<String> output = Pattern.compile("-")
                .splitAsStream(phone)
                .collect(Collectors.toList());

        System.out.println(output);
    }
}
