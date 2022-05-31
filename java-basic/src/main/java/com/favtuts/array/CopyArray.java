package com.favtuts.array;

import java.util.Arrays;

public class CopyArray {

    public static void main(String[] args) {
        // HowNOTtoCopyAnArray();
        // copyArrayByMethodObjectClone();
        // copyArrayWithArraysCopyOfMethod();
        // copyArrayWithArraysCopyOfRangeMethod();
        copyArrayWithSystemArrayCopyMethod();
    }

    static void copyArrayWithSystemArrayCopyMethod() {
        String[] x = { "one", "two", "three", "four", "five" };
        String[] y = new String[2];
        System.arraycopy(x, 3, y, 0, 2);

        System.out.println("Array x: " + Arrays.toString(x));
        System.out.println("Array y: " + Arrays.toString(y) + "\n");

        Object[] z = new Object[5];
        System.arraycopy(x, 0, z, 0, 5);
        System.out.println("Array z: " + Arrays.toString(z) + "\n");

        Integer[] w = { 3, 4, 5 };
        System.out.println("Array w: " + Arrays.toString(w));

        // copy from the second value (1) of array w to z and place in the fourth place
        // (3) the 2 values
        System.arraycopy(w, 1, z, 3, 2);
        System.out.println("Array z: " + Arrays.toString(z));
    }

    static void copyArrayWithArraysCopyOfRangeMethod() {
        String[] x = { "one", "two", "three", "four", "five" };
        String[] y = Arrays.copyOfRange(x, 0, x.length); // full copy of the array
        String[] z = Arrays.copyOfRange(x, x.length - 2, x.length); // copy only the last 2 elements

        System.out.println("Array x: " + Arrays.toString(x));
        System.out.println("Array y: " + Arrays.toString(y));
        System.out.println("Array z: " + Arrays.toString(z));
    }

    static void copyArrayWithArraysCopyOfMethod() {
        String[] x = { "one", "two", "three", "four", "five" };

        // fully copy
        String[] y = Arrays.copyOf(x, x.length);

        // partially copy
        String[] z = Arrays.copyOf(x, 3); // will copy the 3 first elements of array x

        System.out.println("Array x: " + Arrays.toString(x));
        System.out.println("Array y: " + Arrays.toString(y));
        System.out.println("Array z: " + Arrays.toString(z));
    }

    static void copyArrayByMethodObjectClone() {
        int[] x = { 1, 2, 3, 4, 5 };
        int[] y = x.clone();

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y) + "\n");

        x[1] = 22;

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y) + "\n");

        y[4] = 55;

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }

    static void HowNOTtoCopyAnArray() {
        int[] x = { 1, 2, 3, 4, 5 };
        int[] y = x; // don't copy array like this!

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y) + "\n");

        x[1] = 22; // y[1] will display 22! same reference

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y) + "\n");

        y[4] = 55; // x[4] will display 55!

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }
}
