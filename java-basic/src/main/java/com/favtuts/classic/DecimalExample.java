package com.favtuts.classic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DecimalExample {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        // roundDecimalWithDecimalFormat();
        // roundDecimalWithStringFormat();
        // roundDecimalWithBigDecimal();
    }

    

    static void roundDecimalWithBigDecimal() {
        double input = 3.14159265359;
        System.out.println("double : " + input);

        BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        double newInput = bd.doubleValue();

        System.out.println("double : " + newInput);
    }

    static void roundDecimalWithStringFormat() {

        double input = 3.14159265359;
        System.out.println("double : " + input);
        System.out.println("double : " + String.format("%.2f", input));
        System.out.format("double : %.2f", input);

    }

    static void roundDecimalWithDecimalFormat() {

        double input = 3.14159265359;

        System.out.println("double : " + input);
        System.out.println("double : " + df.format(input)); // 3.14

        // DecimalFormat, default is RoundingMode.HALF_EVEN
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println("\ndouble (RoundingMode.DOWN) : " + df.format(input)); // 3.14

        df.setRoundingMode(RoundingMode.UP);
        System.out.println("double (RoundingMode.UP)  : " + df.format(input)); // 3.15
    }
}
