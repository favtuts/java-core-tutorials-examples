package com.favtuts.java8.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterNullValues {

    public static void main(String[] args) {

        Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");

        // Contains null values
        //List<String> result = language.collect(Collectors.toList());

        // Filter to remove null values with Lambda predicate
        // List<String> result = language.filter(x -> x!=null).collect(Collectors.toList());

        // Filter to remove null values with Method Reference
        List<String> result = language.filter(Objects::nonNull).collect(Collectors.toList());

        result.forEach(System.out::println);

    }
}
