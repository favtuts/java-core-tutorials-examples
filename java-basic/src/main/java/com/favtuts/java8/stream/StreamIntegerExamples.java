package com.favtuts.java8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntegerExamples {
    
    public static void main(String[] args) {
        boxedIntStreamToIntegerArray();
    }

    static void boxedIntStreamToIntegerArray() {
        //int[] -> IntStream -> Stream<Integer> -> Integer[]
        int[] num = {3, 4, 5};

        //1. int[] -> IntStream
        IntStream stream = Arrays.stream(num);

        //2. IntStream -> Stream<Integer>
        Stream<Integer> boxed = stream.boxed();

        //3. Stream<Integer> -> Integer[]
        Integer[] result = boxed.toArray(Integer[]::new);

        System.out.println(Arrays.toString(result));

        // one line
        Integer[] oneLineResult = Arrays.stream(num).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(oneLineResult));
    }
}
