package com.favtuts.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamFilter {

    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "favtuts");

        // Example 1: Before Java 8
        /*        
        List<String> result = getFilterOutput(lines, "favtuts");
        for (String temp : result) {
            System.out.println(temp);   //output : spring, node
        }
        */

        // Example 2: Now Java 8
        /*
        List<String> result = lines.stream()                 // convert list to stream
                .filter(line -> !"favtuts".equals(line))     // we dont like favtuts
                .collect(Collectors.toList());               // collect the output and convert streams to a List

        result.forEach(System.out::println);                //output : spring, node
        */


        List<Person> persons = Arrays.asList(
                new Person("favtuts", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        // Example 3: Before Java 8 - get a Person by name
        /*
        Person result = getStudentByName(persons, "jack");
        System.out.println(result);
        */

        // Example 4: Now Java8 - get a Person by name
        /*
        Person result1 = persons.stream()                        // Convert to stream
                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null
        
        System.out.println(result1);

        Person result2 = persons.stream()
                .filter(x -> "ahmook".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result2);
        */

        // Example 5: Now Java8 - For multiple condition
        /*
        Person result1 = persons.stream()
                .filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = persons.stream()
                .filter(p -> {
                    if ("jack".equals(p.getName()) && 20 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);
        */

        // Example 6: Now Java8 - filter() and map()
        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
    
    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"favtuts".equals(line)) {   // we dont like favtuts
                result.add(line);
            }
        }
        return result;
    }

    private static Person getStudentByName(List<Person> persons, String name) {

        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
    }
}
