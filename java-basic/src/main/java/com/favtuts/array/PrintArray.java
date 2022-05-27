package com.favtuts.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintArray {

    public static void main(String[] args) {
        // printArrayWithJDK15ArraysToString();
        // printArrayWithJava8StreamAPI();
        // printArrayWithJava8CollectorsJoining();
        printArrayWithJacksonAPIObjectMapper();
    }

    static void printArrayWithJacksonAPIObjectMapper() {

        // simple array
        String[] strArray = new String[]{"Java", "Node", "Python", "Ruby"};
        PrintUtils.print(strArray);

        int[] intArray = {1, 3, 5, 7, 9};
        PrintUtils.print(intArray);

        //2d array or nested array
        String[][] strArrayDeep = new String[][]{{"favtuts1", "favtuts2"}, {"favtuts3", "favtuts4"}};
        PrintUtils.print(strArrayDeep);

        int[][] intArrayDeep = new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}};
        PrintUtils.print(intArrayDeep);
    }

    static void printArrayWithJava8CollectorsJoining() {

        // simple array
        String[] strArray = new String[] { "Java", "Node", "Python", "Ruby" };
        String strArrayCollect = Arrays.stream(strArray).collect(Collectors.joining(", "));
        System.out.println(strArrayCollect);

        // alternative
        System.out.println(String.join(", ", strArray));

        int[] intArray = {1, 3, 5, 7, 9};
        String intArrayCollect = Arrays.stream(intArray)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
        System.out.println(intArrayCollect);

        //2d array
        String[][] strArrayDeep = new String[][]{{"favtuts1", "favtuts2"}, {"favtuts3", "favtuts4"}};
        String strArrayDeepCollect = Arrays.stream(strArrayDeep)
                .flatMap(Arrays::stream)
                .collect(Collectors.joining(", "));
        System.out.println(strArrayDeepCollect);

        int[][] intArrayDeep = new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}};
        String intArrayDeepCollect = Arrays.stream(intArrayDeep).flatMapToInt(Arrays::stream)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));

        System.out.println(intArrayDeepCollect);
    }

    static void printArrayWithJDK15ArraysToString() {

        // string array
        String[] strArray = new String[] { "Java", "Node", "Python", "Ruby" };
        System.out.println(Arrays.toString(strArray));
        // Output : [Java, Node, Python, Ruby]

        // int Array
        int[] intArray = { 1, 3, 5, 7, 9 };
        System.out.println(Arrays.toString(intArray));
        // Output : [1, 3, 5, 7, 9]

        // 2d array, need Arrays.deepToString
        String[][] strArrayDeep = new String[][] { { "favtuts1", "favtuts2" }, { "favtuts3", "favtuts4" } };
        System.out.println(Arrays.toString(strArrayDeep));
        // Output : [[Ljava.lang.String;@23fc625e, [Ljava.lang.String;@3f99bd52]

        System.out.println(Arrays.deepToString(strArrayDeep));
        // Output : [[favtuts1, favtuts2], [favtuts3, favtuts4]

        int[][] intArrayDeep = new int[][] { { 1, 3, 5, 7, 9 }, { 2, 4, 6, 8, 10 } };
        System.out.println(Arrays.toString(intArrayDeep));
        // Output : [[I@3a71f4dd, [I@7adf9f5f]

        System.out.println(Arrays.deepToString(intArrayDeep));
        // Output : [[1, 3, 5, 7, 9], [2, 4, 6, 8, 10]]
    }

    static void printArrayWithJava8StreamAPI() {

        // simple array
        String[] strArray = new String[] { "Java", "Node", "Python", "Ruby" };
        Arrays.stream(strArray).forEach(System.out::println);

        int[] intArray = { 1, 3, 5, 7, 9 };
        Arrays.stream(intArray).forEach(System.out::println);

        // 2d array
        String[][] strArrayDeep = new String[][] { { "favtuts1", "favtuts2" }, { "favtuts3", "favtuts4" } };
        Arrays.stream(strArrayDeep).flatMap(Arrays::stream).forEach(System.out::println);

        int[][] intArrayDeep = new int[][] { { 1, 3, 5, 7, 9 }, { 2, 4, 6, 8, 10 } };
        Arrays.stream(intArrayDeep).flatMapToInt(Arrays::stream).forEach(System.out::println);

        // lambda
        // Arrays.stream(intArrayDeep).flatMapToInt(x ->
        // Arrays.stream(x)).forEach(System.out::println);

    }
    
}
