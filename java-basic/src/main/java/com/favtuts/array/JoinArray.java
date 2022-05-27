package com.favtuts.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;

public class JoinArray {

    public static void main(String[] args) {

        //joinArraysUsingCommonsLang();
        //joinArraysUsingJavaAPI();
        joinArraysWithJava8Stream();
    }

    private static void joinArraysUsingCommonsLang() {

        String[] s1 = new String[]{"a", "b", "c"};
        String[] s2 = new String[]{"d", "e", "f"};

        String[] result = ArrayUtils.addAll(s1, s2);

        System.out.println(Arrays.toString(result));

        int[] int1 = new int[]{1,2,3};
        int[] int2 = new int[]{4,5,6};

        int[] result2 = ArrayUtils.addAll(int1, int2);

        System.out.println(Arrays.toString(result2));
    }

    private static void joinArraysWithJava8Stream() {

        String[] s1 = new String[]{"a", "b", "c"};
        String[] s2 = new String[]{"d", "e", "f"};
        String[] s3 = new String[]{"g", "h", "i"};

        //join object type array
        String[] result = Stream.of(s1, s2, s3).flatMap(Stream::of).toArray(String[]::new);
        System.out.println(Arrays.toString(result));

        int[] int1 = new int[]{1,2,3};
        int[] int2 = new int[]{4,5,6};
        int[] int3 = new int[]{7,8,9};

        //join 2 primitive type array
        int[] result2 = IntStream.concat(Arrays.stream(int1), Arrays.stream(int2)).toArray();

		//join 3 primitive type array, any better idea?
        int[] result3 = IntStream.concat(Arrays.stream(int1), 
			IntStream.concat(Arrays.stream(int2), Arrays.stream(int3))).toArray();

        System.out.println(Arrays.toString(result2));

        System.out.println(Arrays.toString(result3));

    }

    private static void joinArraysUsingJavaAPI() {

        String[] s1 = new String[]{"a", "b", "c"};
        String[] s2 = new String[]{"d", "e", "f"};
        String[] s3 = new String[]{"g", "h", "i"};

        String[] result = joinArrayGeneric(s1, s2, s3);
        System.out.println(Arrays.toString(result));

        int[] int1 = new int[]{1, 2, 3};
        int[] int2 = new int[]{4, 5, 6};
        int[] int3 = new int[]{7, 8, 9};

        int[] result2 = joinArray(int1, int2, int3);

        System.out.println(Arrays.toString(result2));

    }

    static <T> T[] joinArrayGeneric(T[]... arrays) {
        int length = 0;
        for (T[] array : arrays) {
            length += array.length;
        }

        //T[] result = new T[length];
        final T[] result = (T[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);

        int offset = 0;
        for (T[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }

    static int[] joinArray(int[]... arrays) {
        int length = 0;
        for (int[] array : arrays) {
            length += array.length;
        }

        final int[] result = new int[length];

        int offset = 0;
        for (int[] array : arrays) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }

        return result;
    }

    //create other overloaded primitive type - long, double...
	//static long[] joinArray(long[]... arrays) 
}
