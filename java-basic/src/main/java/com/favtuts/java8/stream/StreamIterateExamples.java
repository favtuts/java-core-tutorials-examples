package com.favtuts.java8.stream;

import java.util.stream.Stream;

public class StreamIterateExamples {
    
    public static void main(String[] args) {
        //demoStreamIterateFrom0To9();
        //demoStreamOddNumbersOnly();
        //demoStreamPrintClassicFibonacci();
        demoStreamSumAllFibonacciValues();
    }

    static void demoStreamSumAllFibonacciValues() {
        int sum = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
            .limit(10)
            .map(n -> n[0]) // Stream<Integer>
            .mapToInt(n -> n)
            .sum();
        System.out.println("Fibonacci 10 sum : " + sum);
    }

    static void demoStreamPrintClassicFibonacci() {
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
            .limit(20)
            .map(n -> n[0])
            .forEach(x -> System.out.println(x));
    }

    static void demoStreamOddNumbersOnly() {
        Stream.iterate(0, n -> n + 1)
			.filter(x -> x % 2 != 0) //odd
			.limit(10)
			.forEach(x -> System.out.println(x));
            
    }

    static void demoStreamIterateFrom0To9() {
        //Stream.iterate(initial value, next value)
        Stream.iterate(0, n -> n + 1)
            .limit(10)
            .forEach(x -> System.out.println(x));
    }
}
