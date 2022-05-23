package com.favtuts.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8Consumer {
    public static void main(String[] args) {

        /*
        // Example 1: Simple Consumer
        Consumer<String> print = x -> System.out.println(x);
        print.accept("java"); // java
        */

        /*
        // Example 2: Consumer as an argument forEach, print each item
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // implementation of the Consumer's accept methods
        Consumer<Integer> consumer = (Integer x) -> System.out.println(x);
        forEach(list, consumer);
        
        // or call this directly
        forEach(list, (Integer x) -> System.out.println(x));
        */
        
        // Example 3: Consumer as an argument forEach, print length of string
        List<String> list = Arrays.asList("a", "ab", "abc");
        forEach(list, (String x) -> System.out.println(x.length()));

    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);            
        }
    }
}
