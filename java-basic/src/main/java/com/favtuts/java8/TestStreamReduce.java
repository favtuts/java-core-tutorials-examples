package com.favtuts.java8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import com.favtuts.java8.stream.reduce.Invoice;

public class TestStreamReduce {
    
    public static void main(String[] args) {
        //demoSimpleSumOperation();
        //demoMathOperations();
        //demoMaxMinOperations();
        //demoJoinStringOperation();  
        demoMapReduceSumListInvoices();
    }

    static void demoMapReduceSumListInvoices() {

        List<Invoice> invoices = Arrays.asList(
                new Invoice("A01", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
                new Invoice("A02", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
                new Invoice("A03", BigDecimal.valueOf(4.99), BigDecimal.valueOf(2))
        );

        BigDecimal sum = invoices.stream()
                .map(x -> x.getQty().multiply(x.getPrice()))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add);      // reduce

        System.out.println(sum);    // 49.955
        System.out.println(sum.setScale(2, RoundingMode.HALF_UP));  // 49.96
        
    }

    static void demoJoinStringOperation() {
        
        String[] strings = {"a", "b", "c", "d", "e"};

        // |a|b|c|d|e , the initial | join is not what we want
        String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);

        // a|b|c|d|e, filter the initial "" empty string
        String reduce2 = Arrays.stream(strings).reduce("", (a, b) -> {
            if (!"".equals(a)) {
                return a + "|" + b;
            } else {
                return b;
            }
        });

        // a|b|c|d|e , better uses the Java 8 String.join :)
        String join = String.join("|", strings);

    }

    static void demoMaxMinOperations() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int max = Arrays.stream(numbers).reduce(0, (a, b) -> a > b ? a : b);  // 10
        int max1 = Arrays.stream(numbers).reduce(0, Integer::max);            // 10

        int min = Arrays.stream(numbers).reduce(0, (a, b) -> a < b ? a : b);  // 0
        int min1 = Arrays.stream(numbers).reduce(0, Integer::min);            // 0
    }


    static void demoMathOperations() {
        //int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] numbers = {1, 2, 3};

        int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);    // 55

        sum = Arrays.stream(numbers).reduce(1, (a, b) -> a + b);    // 55        
        System.out.println(sum);

        int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);      // 55

        int sum3 = Arrays.stream(numbers).reduce(0, (a, b) -> a - b);   // -55
        int sum4 = Arrays.stream(numbers).reduce(0, (a, b) -> a * b);   // 0, initial is 0, 0 * whatever = 0
        System.out.println(sum4);
        sum4 = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);   // 0, initial is 1, 1 * whatever = 3628800
        System.out.println(sum4);
        int sum5 = Arrays.stream(numbers).reduce(0, (a, b) -> a / b);   // 0

    }


    static void demoSimpleSumOperation() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;

        // classic for loop
        /*        
        for (int i : numbers) {
            sum += i;
        }
        */

        // use Stream.reduce()
        /*
        // 1st argument, init value = 0
        sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
        */

        // use method reference        
        sum = Arrays.stream(numbers).reduce(0, Integer::sum); // 55

        System.out.println("sum : " + sum); // 55
    }
}