package com.favtuts.java8.stream;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntegerExamples {
    
    public static void main(String[] args) {
        //boxedIntStreamToIntegerArray();
        //accessFirstIntValueFromIntStream();
        //accessFilterIntValueFromIntStream();
        convertIntStreamToIntegerArray();
    }

    static void convertIntStreamToIntegerArray() {
        int[] num = {1, 2, 3, 4, 5};

        IntStream stream = Arrays.stream(num);

        // IntStream -> int[]
        int[] ints = stream.toArray();

        IntStream stream2 = Arrays.stream(num);

        // IntStream -> Integer[]
        Integer[] integers = stream2.boxed().toArray(Integer[]::new);
    }

    static void accessFilterIntValueFromIntStream() {
        int[] num = {1, 2, 3, 4, 5};

        //1. int[] -> IntStream
        IntStream stream = Arrays.stream(num);

        // 2. OptionalInt
        OptionalInt any = stream.filter(x -> x % 2 == 0).findAny();

        // 3. getAsInt()
        int result = any.getAsInt();

        System.out.println(result); // 2 or 4
    }

    static void accessFirstIntValueFromIntStream() {
        int[] num = {1, 2, 3, 4, 5};

        //1. int[] -> IntStream
        IntStream stream = Arrays.stream(num);

        // 2. OptionalInt
        OptionalInt first = stream.findFirst();

        // 3. getAsInt()
        int result = first.getAsInt();

        System.out.println(result);                                     // 1

        // one line
        System.out.println(Arrays.stream(num).findFirst().getAsInt());  // 1
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
