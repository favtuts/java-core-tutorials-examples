package com.favtuts.classic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RoundDecimal {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final DecimalFormat dfZero = new DecimalFormat("0.00");
    private static final DecimalFormat dfSharp = new DecimalFormat("#.##");

    public static void main(String[] args) {
        // roundDecimalWithDecimalFormat();
        // roundDecimalWithDecimalFormatDifference();
        // roundDecimalWithBigDecimal();
        // roundDecimalWithStringFormat();
        // roundDecimalWithMathRound();
        roundDecimalWithMathRound3Places();
    }

    static void roundDecimalWithMathRound3Places() {
        double input = 1205.6358;

        System.out.println("salary : " + input);

        double salary = Math.round(input * 1000.0) / 1000.0;

        System.out.println("salary : " + salary);
    }

    static void roundDecimalWithMathRound() {
        double input = 1205.6358;

        System.out.println("salary : " + input);

        double salary = Math.round(input * 100.0) / 100.0;

        System.out.println("salary : " + salary);
    }

    static void roundDecimalWithStringFormat() {
        double input = 1205.6358;

        System.out.println("salary : " + input);

        // round half-up, no way control
        // 1205.64
        System.out.println("salary : " + String.format("%.2f", input));

        // 1205.64
        System.out.format("salary : %.2f", input);
    }

    static void roundDecimalWithBigDecimal() {
        // double input = 3.14159265359;
        double input = 1205.6358;
        System.out.println("double : " + input);

        // convert double to BigDecimal
        BigDecimal salary = new BigDecimal(input);
        System.out.println("BigDecimal: " + salary);

        // round to 2 decimal places
        BigDecimal salary2 = salary.setScale(2, RoundingMode.HALF_UP);
        System.out.println("BigDecimal: " + salary2);

        // one line
        BigDecimal salary3 = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        System.out.println("BigDecimal: " + salary3);

        // convert BigDecimal back to double
        double salary4 = salary3.doubleValue();
        System.out.println("double : " + salary4);
    }

    static void roundDecimalWithDecimalFormatDifference() {
        double input = 1205.6;

        System.out.println("salary : " + input);

        System.out.println("salary 0.00 : " + dfZero.format(input));
        System.out.println("salary #.## : " + dfSharp.format(input));

        double input2 = 1205.60;

        System.out.println("salary : " + input2);

        System.out.println("salary 0.00 : " + dfZero.format(input2));
        System.out.println("salary #.## : " + dfSharp.format(input2));
    }

    static void roundDecimalWithDecimalFormat() {
        double input = 1205.6358;

        System.out.println("salary : " + input);

        // DecimalFormat, default is RoundingMode.HALF_EVEN
        System.out.println("salary : " + df.format(input)); // 1205.64

        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println("salary : " + df.format(input)); // 1205.63

        df.setRoundingMode(RoundingMode.UP);
        System.out.println("salary : " + df.format(input)); // 1205.64
    }
}
