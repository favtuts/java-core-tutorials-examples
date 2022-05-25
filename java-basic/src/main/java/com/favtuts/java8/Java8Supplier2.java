package com.favtuts.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Java8Supplier2<T> {


    public Supplier<List<T>> supplier() {

        // lambda
        // return () -> new ArrayList<>();

        // constructor reference
        return ArrayList::new;

    }

}
