package com.favtuts.java8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintPrimeNumber {

    public static void main(String[] args) {
        //printPrimeJava8Stream();
        //printPrimeBigIntegerNextProbablePrime();
        //printPrimeBigIntegerNextProbablePrimeJava9();
        //printPrimePlainOldJavaNoMoreStream();
        printPrimeSieveOfEratosthenesAlgorithm();
    }

    public static void printPrimeSieveOfEratosthenesAlgorithm() {
        List<Integer> result = primes_soe_array(1000);

        result.forEach(x -> System.out.format("%s\t", x));

        System.out.println("\nTotal: " + result.size());
    }

    /**
     * Sieve of Eratosthenes, true = prime number
     */
    private static List<Integer> primes_soe(int limit) {

        BitSet primes = new BitSet(limit);
        primes.set(0, false);                       
        primes.set(1, false);                       
        primes.set(2, limit, true);

        for (int p = 2; p * p <= limit; p++) {
            if (primes.get(p)) {
                for (int j = p * 2; j <= limit; j += p) {
                    primes.set(j, false);
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i <= limit; i++) {
            if (primes.get(i)) {
                result.add(i);
            }
        }

        return result;

    }

    // Some developers prefer array.
    public static List<Integer> primes_soe_array(int limit) {

        boolean primes[] = new boolean[limit + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int p = 2; p * p <= limit; p++) {
            if (primes[p]) {
                for (int j = p * 2; j <= limit; j += p) {
                    primes[j] = false;
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i <= limit; i++) {
            if (primes[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void printPrimePlainOldJavaNoMoreStream() {
        List<Integer> collect = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            if (isPrime(i)) {
                collect.add(i);
            }
        }

        for (Integer prime : collect) {
            System.out.format("%s\t", prime);
        }

        System.out.println("\nTotal: " + collect.size());
    }

    private static boolean isPrimeClassic(int number) {

        if (number <= 1) return false;    //  1 is not prime and also not composite

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrimeBigIntegerNextProbablePrimeJava9() {
        Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime)
			.limit(168)
			.forEach(x -> System.out.format("%s\t", x));
    }

    public static void printPrimeBigIntegerNextProbablePrime() {
        Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime)
			.limit(168)
			.forEach(x -> System.out.format("%s\t", x));
    }

    public static void printPrimeJava8Stream() {

        long count = Stream.iterate(0, n -> n + 1)
                .limit(1000)
                .filter(PrintPrimeNumber::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);

    }

    public static boolean isPrime(int number) {

        if (number <= 1) return false; // 1 is not prime and also not composite

        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }
}
