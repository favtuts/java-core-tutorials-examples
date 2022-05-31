package com.favtuts.array;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayToStream {
    
    public static void main(String[] args) {
        //convertObjectArraysToStream();
        convertPrimitiveArraysToStream();
    }

    static void convertPrimitiveArraysToStream() {
        int[] intArray = {1, 2, 3, 4, 5};

        // 1. Arrays.stream -> IntStream 
        IntStream intStream1 = Arrays.stream(intArray);
        intStream1.forEach(x -> System.out.println(x));

        // 2. Stream.of -> Stream<int[]>
        Stream<int[]> temp = Stream.of(intArray);

        // Cant print Stream<int[]> directly, convert / flat it to IntStream 
        IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
        intStream2.forEach(x -> System.out.println(x));
    }

    static void convertObjectArraysToStream() {
        String[] array = {"a", "b", "c", "d", "e"};

        //Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(x -> System.out.println(x));

        //Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.println(x));
    }
}
