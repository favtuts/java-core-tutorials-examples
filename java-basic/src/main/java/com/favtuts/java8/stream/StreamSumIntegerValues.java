package com.favtuts.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSumIntegerValues {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total : " + sum);

        Stream<Integer> integers2 = Stream.iterate(1, n -> n + 1).limit(10);
        IntStream intStream = integers2.mapToInt(x -> x);
        int sum1 = intStream.sum();
        System.out.println("Total : " + sum1);
        
    }
    
}
