package com.favtuts.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToList {
    public static void main(String[] args) {
        //summaryConvertArrayToList();
        //convertPrimitiveArrayToListClassic();
        convertPrimitiveArrayToListJava8Stream();
    }

    static void convertPrimitiveArrayToListJava8Stream() {
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // IntStream.of or Arrays.stream, same output
        //List<Integer> list = IntStream.of(number).boxed().collect(Collectors.toList());
		
        List<Integer> list = Arrays.stream(number).boxed().collect(Collectors.toList());
        System.out.println("list : " + list);
    }

    static void convertPrimitiveArrayToListClassic() {
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> list = convertIntArrayToList(number);
        System.out.println("list : " + list);
    }

    private static List<Integer> convertIntArrayToList(int[] input) {

        List<Integer> list = new ArrayList<>();
        for (int i : input) {
            list.add(i);
        }
        return list;

    }

    static void summaryConvertArrayToList() {
        String sArray[] = new String[] { "A", "B", "C" };

        // convert array to list #1
        List<String> list = Arrays.asList(sArray);

        System.out.println(list);

        // convert array to list #2
        List<String> list2 = new ArrayList<String>(Arrays.asList(sArray));

        System.out.println(list2);

        int iArray[] = new int[] { 1, 2, 3 };

        // Java 8, convert array to List, primitive int[] to List<Integer>
        List<Integer> list3 = Arrays.stream(iArray).boxed().collect(Collectors.toList());

        System.out.println(list3);
    }
}
