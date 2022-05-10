package com.favtuts.http;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpExample1 {
    
    // only one client, singleton, better puts it in a factory
    // mutiple instances will create more memory.
    private final OkHttpClient httpClient = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        
        OkHttpExample1 obj = new OkHttpExample1();
        obj.sendGETSync();
        
    }

    private void sendGETSync() throws IOException {

        Request request = new Request.Builder()
            .url("https://httpbin.org/get")
            .addHeader("custom-key", "favtuts")  // add request headers
            .addHeader("User-Agent", "OkHttp Bot")
            .build();
        
        try (Response response = httpClient.newCall(request).execute()) {
            
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response headers
            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i ++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            // Get response body
            System.out.println(response.body().string());
        }
    }

}
