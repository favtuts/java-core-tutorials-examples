package com.favtuts.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class JavaBiConsumer {

    public static void main(String[] args) {
        
        //demoBiConsumerSimple();
        //demoBiConsumerArgument();
        //demoBiConsumerArgumentMath();
        demoBiConsumerArgumentMapForEach();

    }
    
    private static void demoBiConsumerSimple() {

        BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
        addTwo.accept(1, 2);    // 3
    }


    private static void demoBiConsumerArgument() {

        addTwo(1, 2, (x, y) -> System.out.println(x + y));          // 3
        addTwo("Node", ".js", (x, y) -> System.out.println(x + y)); // Node.js

    }

    static <T> void addTwo(T a1, T a2, BiConsumer<T, T> c) {
        c.accept(a1, a2);
    }

    private static void demoBiConsumerArgumentMath() {

        math(1, 1, (x, y) -> System.out.println(x + y));   // 2
        math(1, 1, (x, y) -> System.out.println(x - y));   // 0
        math(1, 1, (x, y) -> System.out.println(x * y));   // 1
        math(1, 1, (x, y) -> System.out.println(x / y));   // 1

    }

    static <Integer> void math(Integer a1, Integer a2, BiConsumer<Integer, Integer> c) {
        c.accept(a1, a2);
    }


    private static void demoBiConsumerArgumentMapForEach() {

        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Rust");
        map.put(4, "JavaScript");
        map.put(5, "Go");

        map.forEach((k, v) -> System.out.println(k + ":" + v));

    }
}
