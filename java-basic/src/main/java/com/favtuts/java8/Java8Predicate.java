package com.favtuts.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Predicate {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> listStrings = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        /* 
        // Example 1: Inline predicate
        List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());

        System.out.println(collect); // [6, 7, 8, 9, 10]
        */
        
        /*
        // Example 2: Explicit predicate
        Predicate<Integer> noGreaterThan5 = x -> x > 5;

        List<Integer> collect = list.stream()
                .filter(noGreaterThan5)
                .collect(Collectors.toList());

        System.out.println(collect); // [6, 7, 8, 9, 10]
        */

        /*
        // Example 3: Predicate.and() - multiple filters
        List<Integer> collect = list.stream()
                .filter(x -> x > 5 && x < 8).collect(Collectors.toList());

        System.out.println(collect);
        */

        // Example 4: Replace Predicate.end()
        /*
        Predicate<Integer> noGreaterThan5 = x -> x > 5;
        Predicate<Integer> noLessThan8 = x -> x < 8;

        List<Integer> collect = list.stream()
                .filter(noGreaterThan5.and(noLessThan8))
                .collect(Collectors.toList());

        System.out.println(collect);               
        */

        // Example 5: Predicate.or()
        /*
        Predicate<String> lengthIs3 = x -> x.length() == 3;
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> collect = listStrings.stream()
                .filter(lengthIs3.or(startWithA))
                .collect(Collectors.toList());

        System.out.println(collect);
        */

        // Example 6: Predicate.negate()
        /* 
        // Find all elements not start with ‘A’.
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> collect = listStrings.stream()
                .filter(startWithA.negate())
                .collect(Collectors.toList());

        System.out.println(collect);
        */

        // Example 7: Predicate.test() in function
        /*
        System.out.println(StringProcessor.filter(listStrings, 
            x -> x.startsWith("A")));                           // [A, AA, AAA]
        
        System.out.println(StringProcessor.filter(listStrings, 
            x -> x.startsWith("A") && x.length() == 3));        // [AAA]
        */

        // Example 8: Predicate Chaining
        /*
        Predicate<String> startWithA = x -> x.startsWith("a");

        // start with "a" or "f"
        boolean result = startWithA.or(x -> x.startsWith("f")).test("favtuts");
        System.out.println(result);     // true

        // !(start with "a" and length is 3)
        boolean result2 = startWithA.and(x -> x.length() == 3).negate().test("abc");
        System.out.println(result2);    // false
        */


        // Example 9: Predicate in Object
        Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting(2, "linode", "linode.com");
        Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting(4, "google", "google.com");

        List<Hosting> listObjects = Arrays.asList(new Hosting[]{h1, h2, h3, h4});

        List<Hosting> result = HostingRespository.filterHosting(listObjects, x -> x.getName().startsWith("g"));
        System.out.println("result : " + result);  // google

        List<Hosting> result2 = HostingRespository.filterHosting(listObjects, isDeveloperFriendly());
        System.out.println("result2 : " + result2); // linode
    }

    public static Predicate<Hosting> isDeveloperFriendly() {
        return n -> n.getName().equals("linode");
    }
}

class StringProcessor {
    static List<String> filter(List<String> list, Predicate<String> predicate) {
        return list.stream().filter(predicate::test).collect(Collectors.toList());
    }
}