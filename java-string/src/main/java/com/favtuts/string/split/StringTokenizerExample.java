package com.favtuts.string.split;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringTokenizerExample {

    public static void main(String[] args) {
        
        String line = "This is a String, split by, StringTokenizer example.";
        List<String> result = split(line, ",");
        for (String s : result) {
            System.out.println(s.trim());
        }
        
    }
    
    public static List<String> split(String line, String delimiter) {
        List<String> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line, delimiter);
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result;
    }
}
