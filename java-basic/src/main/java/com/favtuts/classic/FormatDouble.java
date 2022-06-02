package com.favtuts.classic;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatDouble {
    public static void main(String[] args) {
        //formatDoubleWithStringFormat();
        formatDoubleWithDecimalFormat();
    }

    static void formatDoubleWithDecimalFormat() {
        DecimalFormat df = new DecimalFormat("#,###.##");

        // different locale - GERMAN
        DecimalFormat dfGerman = new DecimalFormat("#,###.##",
                new DecimalFormatSymbols(Locale.GERMAN));

        String input = "1234567890.123456";
        double d = Double.parseDouble(input);

        System.out.println(df.format(d)); // 1,234,567,890.12

        System.out.println(dfGerman.format(d)); // 1.234.567.890,12
    }

    static void formatDoubleWithStringFormat() {
        String input = "1234567890.123456";
        double d = Double.parseDouble(input);

        // 2 decimal points
        System.out.println(String.format("%,.2f", d)); // 1,234,567,890.12

        // 4 decimal points
        System.out.println(String.format("%,.4f", d)); // 1,234,567,890.1235

        // 20 digits, if enough digits, puts 0
        System.out.println(String.format("%,020.2f", d)); // 00001,234,567,890.12

        // 10 decimal points, if not enough digit, puts 0
        System.out.println(String.format("%,.010f", d)); // 1,234,567,890.1234560000

        // in scientist format
        System.out.println(String.format("%e", d)); // 1.234568e+09

        // different locale - FRANCE
        System.out.println(String.format(
                Locale.FRANCE, "%,.2f", d)); // 1 234 567 890,12

        // different locale - GERMAN
        System.out.println(String.format(
                Locale.GERMAN, "%,.2f", d)); // 1.234.567.890,12
    }
}
