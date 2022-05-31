package com.favtuts.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindExamples {
    
    public static void main(String[] args) {
        //demoStreamFindFirst();
        //demoStreamFindFirstAfterFiltering();
        demoStreamFindAny();
    }

    static void demoStreamFindAny() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> any = list.stream().filter(x -> x > 1).findAny();
        if (any.isPresent()) {
            Integer result = any.get();
            System.out.println(result);
        }
    }

    static void demoStreamFindFirstAfterFiltering() {
        List<String> list = Arrays.asList("node", "java", "python", "ruby");

        Optional<String> result = list.stream()
                .filter(x -> !x.equalsIgnoreCase("node"))
                .findFirst();

        if (result.isPresent()) {
            System.out.println(result.get()); // java
        } else {
            System.out.println("no value?");
        }
    }

    static void demoStreamFindFirst() {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 1);

        Optional<Integer> first = list.stream().findFirst();
        if (first.isPresent()) {
            Integer result = first.get();
            System.out.println(result);       // 1
        } else {
            System.out.println("no value?");
        }

        Optional<Integer> first2 = list
                .stream()
                .filter(x -> x > 1).findFirst();

        if (first2.isPresent()) {
            System.out.println(first2.get()); // 2
        } else {
            System.out.println("no value?");
        }
    }
}
