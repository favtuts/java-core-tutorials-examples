package com.favtuts.string.compare;

public class StringCompareIntern {
    public static void main(String[] args) {
        // JVM checks if this string exists in the string pool? The answer is NO.
        // JVM add this string object to the string pool and returns a reference
        // str1 has a reference "111" (example), which points to "apple" in the string pool
        String str1 = "apple";

        // JVM checks if this string exists in string pool? The answer is YES.
        // JVM returns the reference "111", which points to "apple"
        String str2 = "apple";

        // Now str1 and str2 both have the same reference "111" to the "apple"
        // and that is why it return true here.
        System.out.println(str1 == str2);  

        // move on for the following example

        // JVM see "new", ignore string pool and create a new reference or address "222" (example)
        String str3 = new String("apple");

        // str = address "111"
        // str3 = address "222"

        // false
        System.out.println(str1 == str3);


        // move on for the following example

        // we can use `intern` to add this to the string pool
        // JVM see this "apple" already existed in the string pool
        // JVM returns the reference "111" to str4
        String str4 = str3.intern();

        // true
        System.out.println(str1 == str4);

        // still false, str3 is still has the reference "222"
        System.out.println(str1 == str3);
    }
}
