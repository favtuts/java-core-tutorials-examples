package com.favtuts.classic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class JavaMoney {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        //representMonetaryValuesWithDoubleAndFloat();
        representMonetaryValuesWithBigDecimal();
    }

    static void representMonetaryValuesWithBigDecimal() {
        System.out.println("--- BigDecimal-----");
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.1)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.2)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.3)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.4)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.5)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.6)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.7)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.8)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(1.9)));
        System.out.println(BigDecimal.valueOf(2.00).subtract(BigDecimal.valueOf(2)));

        System.out.println("--------------------");

        BigDecimal i = BigDecimal.valueOf(2.0);
        BigDecimal j = BigDecimal.valueOf(1.7);

        System.out.println("double : " + i.subtract(j));
        System.out.println("double : " + i.subtract(j).setScale(5, RoundingMode.HALF_UP));
    }

    static void representMonetaryValuesWithDoubleAndFloat() {

        System.out.println(2.00 - 1.1);
        System.out.println(2.00 - 1.2);
        System.out.println(2.00 - 1.3);
        System.out.println(2.00 - 1.4);
        System.out.println(2.00 - 1.5);
        System.out.println(2.00 - 1.6);
        System.out.println(2.00 - 1.7);
        System.out.println(2.00 - 1.8);
        System.out.println(2.00 - 1.9);
        System.out.println(2.00 - 2);

        System.out.println("--------------------");

        double i = 2.0;
        double j = 1.7;

        System.out.println("double : " + (i - j));
        System.out.println("double : " + df.format(i - j));

        float i2 = 2.0f;
        float j2 = 1.7f;

        System.out.println("float : " + (i2 - j2));
        System.out.println("float : " + df.format(i2 - j2));

    }
}
