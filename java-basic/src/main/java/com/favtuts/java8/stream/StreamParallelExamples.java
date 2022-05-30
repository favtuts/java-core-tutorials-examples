package com.favtuts.java8.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.favtuts.java8.Employee;

public class StreamParallelExamples {
    
    public static void main(String[] args) {
        
        //demoSimpleStreamParallel();
        //demoCollectionParallelStream();
        //checkStreamIsRunningParallelMode();
        //printStreamCurrentThreadName();
        //demoStreamParallelPrimeCalculation();
        demoStreamParallelAverageAgeEmployees();

    }


    static void demoStreamParallelAverageAgeEmployees() {

        IntStream range = IntStream.rangeClosed(1, 10000);
        List<Employee> employees = range.boxed()
            .map(x -> {
                Employee obj = new Employee("Employee" + x, x, BigDecimal.valueOf(x * 100));
                return obj;
            })
            .collect(Collectors.toList());
            ;
        System.out.println(employees);

        double age = employees
            .parallelStream()
            .mapToInt(Employee::getAge)
            .average()
            .getAsDouble();

        System.out.println("Average age: " + age);

    }


    static void demoStreamParallelPrimeCalculation() {

        long count = Stream.iterate(0, n -> n + 1)
                .limit(1_000_000)
                //.parallel()   with this 23s, without this 1m 10s
                .filter(StreamParallelExamples::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);

    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

    static void printStreamCurrentThreadName() {

        System.out.println("Normal...");

        IntStream range = IntStream.rangeClosed(1, 10);
        range.forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });

        System.out.println("Parallel...");

        IntStream range2 = IntStream.rangeClosed(1, 10);
        range2.parallel().forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });

    }

    static void checkStreamIsRunningParallelMode() {

        System.out.println("Normal...");

        IntStream range = IntStream.rangeClosed(1, 10);
        System.out.println(range.isParallel());         // false
        range.forEach(System.out::println);

        System.out.println("Parallel...");

        IntStream range2 = IntStream.rangeClosed(1, 10);
        IntStream range2Parallel = range2.parallel();
        System.out.println(range2Parallel.isParallel()); // true
        range2Parallel.forEach(System.out::println);

    }

    static void demoCollectionParallelStream() {

        System.out.println("Normal...");

        List<String> alpha = getData();

        alpha.stream().forEach(System.out::println);

        System.out.println("Parallel...");

        List<String> alpha2 = getData();

        alpha2.parallelStream().forEach(System.out::println);
    }

    private static List<String> getData() {

        List<String> alpha = new ArrayList<>();

        int n = 97;  // 97 = a , 122 = z
        while (n <= 122) {
            char c = (char) n;
            alpha.add(String.valueOf(c));
            n++;
        }

        return alpha;

    }

    static void demoSimpleStreamParallel() {

        System.out.println("Normal...");
        
        IntStream range = IntStream.rangeClosed(1, 10);

        range.forEach(System.out::println);

        System.out.println("Parallel...");

        IntStream range2 = IntStream.rangeClosed(1, 10);

        range2.parallel().forEach(System.out::println);

    }
}
