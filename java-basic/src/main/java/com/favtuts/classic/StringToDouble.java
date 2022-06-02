package com.favtuts.classic;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class StringToDouble {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) throws ParseException {

        String str = "12,000,000";

        NumberFormat format = NumberFormat.getInstance();
        Number parse = format.parse(str);

        System.out.println(parse);

        double salary = parse.doubleValue();

        System.out.println(salary);
        System.out.println(df.format(salary));

    }
}
