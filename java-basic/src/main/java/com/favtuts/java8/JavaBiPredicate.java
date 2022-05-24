package com.favtuts.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class JavaBiPredicate {
    
    public static void main(String[] args) {

        // Example 1: BiPredicate Hello World
        /*
        BiPredicate<String, Integer> filter = (x, y) -> {
            return x.length() == y;
        };

        boolean result = filter.test("favtuts", 7);
        System.out.println(result);  // true

        boolean result2 = filter.test("java", 10);
        System.out.println(result2); // false
        */

        // Example 2: BiPredicate as function argument
        List<Domain> domains = Arrays.asList(new Domain("google.com", 1),
                new Domain("i-am-spammer.com", 10),
                new Domain("favtuts.com", 0),
                new Domain("microsoft.com", 2));
        
        BiPredicate<String, Integer> bi = (domain, score) -> {
            return (domain.equalsIgnoreCase("google.com") || score == 0);
        };

        // if google or score == 0
        List<Domain> result = filterBadDomain(domains, bi);
        System.out.println(result); // google.com, favtuts.com

        //  if score == 0
        List<Domain> result2 = filterBadDomain(domains, (domain, score) -> score == 0);
        System.out.println(result2); // favtuts.com, microsoft.com

         // if start with i or score > 5
         List<Domain> result3 = filterBadDomain(domains, (domain, score) -> domain.startsWith("i") && score > 5);
         System.out.println(result3); // i-am-spammer.com

          // chaining with or
        List<Domain> result4 = filterBadDomain(domains, bi.or(
            (domain, x) -> domain.equalsIgnoreCase("microsoft.com"))
        );
        System.out.println(result4); // google.com, favtuts.com, microsoft.com

    }

    public static <T extends Domain> List<T> filterBadDomain(
        List<T> list, BiPredicate<String, Integer> biPredicate
    ) {

        return list.stream()
            .filter(x -> biPredicate.test(x.getName(), x.getScore()))
            .collect(Collectors.toList());

    }

}

class Domain {    

    String name;
    Integer score;

    public Domain(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
    // getters , setters , toString
    @Override
    public String toString() {
        return "Domain{" +
            " name='" + getName() + "'" +
            ", score='" + getScore() + "'" +
            "}";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
