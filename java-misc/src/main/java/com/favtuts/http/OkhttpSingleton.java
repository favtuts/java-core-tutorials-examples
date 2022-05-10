package com.favtuts.http;

import okhttp3.OkHttpClient;

public class OkhttpSingleton {
    private static volatile OkHttpClient instance;
    public static OkHttpClient getInstance() {
        // Do something before get instance ...
        if (instance == null) {
            // Do the task too long before create instance ...
            // Block so other threads cannot come into while initialize
            synchronized (OkhttpSingleton.class) {
                // Re-check again. Maybe another thread has initialized before
                if (instance == null) {
                    instance = new OkHttpClient.Builder().build();
                }
            }
        }
        // Do something after get instance ...
        return instance;
    }
}