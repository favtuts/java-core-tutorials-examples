package com.favtuts.java8;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Java8Supplier {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        
        //demoSupplierReturnCurrentDateTime();
        //demoSupplierReturnASupplier();
        demoSupplierFactoryMethod();

    }

    private static void demoSupplierReturnCurrentDateTime() {

        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);

    }


    private static void demoSupplierReturnASupplier() {

        Java8Supplier2<String> obj = new Java8Supplier2<>();

        List<String> list = obj.supplier().get();

        list.add("favtuts");

        System.out.println(list);

    }


    private static void demoSupplierFactoryMethod() {

        Developer2 obj = factory(Developer2::new);
        System.out.println(obj);

        Developer2 obj2 = factory(() -> new Developer2("favtuts"));
        System.out.println(obj2);
    }


    public static Developer2 factory(Supplier<? extends Developer2> s) {

        Developer2 developer = s.get();
        if (developer.getName() == null || "".equals(developer.getName())) {
            developer.setName("default");
        }
        developer.setSalary(BigDecimal.ONE);
        developer.setStart(LocalDate.of(2017, 8, 8));
        
        return developer;
    }

}
