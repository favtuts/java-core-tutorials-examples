package com.favtuts.java8;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.favtuts.java8.stream.flatmap.Developer;
import com.favtuts.java8.stream.flatmap.LineItem;
import com.favtuts.java8.stream.flatmap.Order;

public class TestFlatMap {
    
    public static void main(String[] args) {
    
        //filter2DStringArray();
        //flatten2DStringArray();
        //filterFlattenStringArray();
        //filterBookOfDevelopers();
        //workOrderAndLineItems();
        //countTotalWordsTextFile();

        flatMapWithPrimitiveType();
        
    }

    private static void flatMapWithPrimitiveType() {

        int[] array = {1, 2, 3, 4, 5, 6};

        //Stream<int[]>
        Stream<int[]> streamArray = Stream.of(array);

        //Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

        intStream.forEach(x -> System.out.println(x));

    }

    private static void countTotalWordsTextFile() {
        try {
            Path path = Paths.get("/home/tvt/workspace/favtuts/flatmap.txt");

            // read file into a stream of lines
            Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);

            // stream of array...hard to process.
            // Stream<String[]> words = lines.map(line -> line.split(" +"));

            // stream of stream of string....hmm...better flat to one level.
            // Stream<Stream<String>> words = lines.map(line -> Stream.of(line.split(" +")));

            // result a stream of words, good!
            Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));

            // count the number of words.
            long noOfWords = words.count();

            System.out.println(noOfWords);  // 16

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void workOrderAndLineItems() {

        List<Order> orders = findAll();

        /*
            Stream<List<LineItem>> listStream = orders.stream()
                    .map(order -> order.getLineItems());

            Stream<LineItem> lineItemStream = orders.stream()
                    .flatMap(order -> order.getLineItems().stream());
        */

        // sum the line items' total amount
        BigDecimal sumOfLineItems = orders.stream()
                .flatMap(order -> order.getLineItems().stream())    //  Stream<LineItem>
                .map(line -> line.getTotal())                       //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all

        // sum the order's total amount
        BigDecimal sumOfOrder = orders.stream()
                .map(order -> order.getTotal())                     //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all

        System.out.println(sumOfLineItems);                         // 3194.20
        System.out.println(sumOfOrder);                             // 3194.20

        if (!sumOfOrder.equals(sumOfLineItems)) {
            System.out.println("The sumOfOrder is not equals to sumOfLineItems!");
        }

    }

    private static List<Order> findAll() {

        LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

        return Arrays.asList(order1, order2, order3);

    }

    private static void filterBookOfDevelopers() {

        Developer o1 = new Developer();
        o1.setName("favtuts");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        // hmm....Set of Set...how to process?
        /*Set<Set<String>> collect = list.stream()
                .map(x -> x.getBook())
                .collect(Collectors.toSet());*/
        
        Set<String> collect =
            list.stream()
                .map(x -> x.getBook())                              //  Stream<Set<String>>
                .flatMap(x -> x.stream())                           //  Stream<String>
                .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
                .collect(Collectors.toSet());                       //  remove duplicated
        
        collect.forEach(System.out::println);
        
    }

    private static void filterFlattenStringArray () {

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String> collect = Stream.of(array)     // Stream<String[]>
                .flatMap(Stream::of)                // Stream<String>
                .filter(x -> !"a".equals(x))        // filter out the a
                .collect(Collectors.toList());      // return a List

        collect.forEach(System.out::println);

    }

    private static void flatten2DStringArray() {
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        // Java 8
        String[] result = Stream.of(array)  // Stream<String[]>
                .flatMap(Stream::of)        // Stream<String>
                .toArray(String[]::new);    // [a, b, c, d, e, f]
      
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void filter2DStringArray() {

        String[][] array = new String[][] {{"a", "b"}, {"c", "d"}, {"e", "f"}};

        // convert array to a stream
        Stream<String[]> stream1 = Arrays.stream(array);

        // x is a String[]
        List<String[]> result = stream1
            .filter(x -> {
                for (String s : x) {        // really?
                    if (s.equals("a")) {
                        return false;
                    }
                }
                return true;
            }).collect(Collectors.toList());
        
        // print array
        result.forEach(x -> System.out.println(Arrays.toString(x)));

    }

}
