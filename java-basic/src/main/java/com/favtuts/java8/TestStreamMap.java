package com.favtuts.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreamMap {
    
    public static void main(String[] args) {
               
        //convertListStringToUpperCase();
        //getAllNamesFromStaffList();

        List<Staff> staff = Arrays.asList(
            new Staff("favtuts", 30, new BigDecimal(10000)),
            new Staff("jack", 27, new BigDecimal(20000)),
            new Staff("lawrence", 33, new BigDecimal(30000))
        );
        //convertStaffToStaffPublicBeforeJava8(staff);
        convertStaffToStaffPublicNowJava8(staff);

    }

    private static void convertStaffToStaffPublicNowJava8(List<Staff> staff) {

        // convert inside the map() method directly.
        List<StaffPublic> result = staff.stream().map(temp -> {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("favtuts".equals(temp.getName())) {
                obj.setExtra("this field is for favtuts only!");
            }
            return obj;
        }).collect(Collectors.toList());

        System.out.println(result);
    }


    private static void convertStaffToStaffPublicBeforeJava8(List<Staff> staff) {

        List<StaffPublic> result = new ArrayList<>();

        for (Staff temp : staff) {

            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("favtuts".equals(temp.getName())) {
                obj.setExtra("this field is for favtuts only!");
            }

            result.add(obj);
        }

        System.out.println(result);

    }

    private static void getAllNamesFromStaffList(){

        List<Staff> staff = Arrays.asList(
                new Staff("favtuts", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staff) {
            result.add(x.getName());
        }
        System.out.println(result); //[favtuts, jack, lawrence]

        //Java 8
        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect); //[favtuts, jack, lawrence]
    }

    private static void convertListStringToUpperCase() {

        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        
        //Before Java8
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }

        System.out.println(alpha); //[a, b, c, d]
        System.out.println(alphaUpper); //[A, B, C, D]

        //Java 8
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

        // Extra, streams apply to any data type.
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10]

    }

}
