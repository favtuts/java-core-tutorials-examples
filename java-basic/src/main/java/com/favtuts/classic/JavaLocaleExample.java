package com.favtuts.classic;

import java.util.Locale;

public class JavaLocaleExample {
    public static void main(String[] args) {
        // get jvm default locale
        Locale defaultLocale = Locale.getDefault();

        System.out.println(defaultLocale);

        // set jvm locale to china
        Locale.setDefault(Locale.CHINA);

        // or like this
        // Locale.setDefault(new Locale("zh", "cn");

        Locale chinaLocale = Locale.getDefault();

        System.out.println(chinaLocale);
    }
}
