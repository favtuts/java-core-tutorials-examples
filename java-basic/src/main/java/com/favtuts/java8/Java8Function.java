package com.favtuts.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.codec.digest.DigestUtils;

public class Java8Function {
    
    public static void main(String[] args) {
        
        //demoFunctionTR();
        //demoChainFunctionTR(); 
        //demoFunctionArgumentListToMap();
        demoFunctionArgumentListToList();
    }


    private static void demoFunctionTR() {
        Function<String, Integer> func = x -> x.length();

        Integer apply = func.apply("favtuts");          // 7

        System.out.println(apply);
    }

    private static void demoChainFunctionTR() {

        Function<String, Integer> func = x -> x.length();

        Function<Integer, Integer> func2 = x -> x * 2;

        Integer result = func.andThen(func2).apply("favtuts");  // 14

        System.out.println(result);
    }


    private static void demoFunctionArgumentListToMap() {
        
        Java8Function obj = new Java8Function();

        List<String> list = Arrays.asList("node", "c++", "java", "javascript");

        // lambda
        Map<String, Integer> map = obj.convertListToMap(list, x -> x.length());
        System.out.println(map);    // {node=4, c++=3, java=4, javascript=10}

        // method reference
        Map<String, Integer> map2 = obj.convertListToMap(list, obj::getLength);        
        System.out.println(map2);

    }


    private static void demoFunctionArgumentListToList() {

        Java8Function obj = new Java8Function();

        List<String> list = Arrays.asList("node", "c++", "java", "javascript");

        // lambda
        //List<String> result = obj.map(list, x -> obj.sha256(x));

        // method reference
        List<String> result = obj.map(list, obj::sha256);

        result.forEach(System.out::println);

    }


    public <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {
        
        Map<T, R> result = new HashMap<>();
        for (T t : list) {
            result.put(t, func.apply(t));
        }
        return result;
    }

    public <T, R> List<R> map(List<T> list, Function<T, R> func) {

        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(func.apply(t));
        }
        return result;

    }

    public Integer getLength(String str) {
        return str.length();
    }

    // sha256 a string
    public String sha256(String str) {
        return DigestUtils.sha256Hex(str);
    }
}
