package com.favtuts.java8.stream;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamClosedAfterOperated {
    
    public static void main(String[] args) {
        //demoStreamIsClosed();
        useSupplierToReuseStream();
    }

    static void useSupplierToReuseStream() {
        String[] array = {"a", "b", "c", "d", "e"};

        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

        //get new stream
        streamSupplier.get().forEach(x -> System.out.println(x));

        //get another new stream
        long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
        System.out.println(count);
    }

    static void demoStreamIsClosed() {
        String[] array = {"a", "b", "c", "d", "e"};
        Stream<String> stream = Arrays.stream(array);

        // loop a stream
        stream.forEach(x -> System.out.println(x));

        // reuse it to filter again! throws IllegalStateException
        long count = stream.filter(x -> "b".equals(x)).count();
        System.out.println(count);
    }
}
