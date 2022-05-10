package com.favtuts.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Performance optimization
public class OkHttpExample11 {
    
    // only one client, singleton, better puts it in a factory
    // mutiple instances will create more memory.
    private final OkHttpClient httpClient = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        
        OkHttpExample11 obj = new OkHttpExample11();
        obj.sendGETSync();
        
    }

    private void sendGETSync() throws IOException {

        Request request = new Request.Builder()
            .url("https://httpbin.org/get")
            .addHeader("custom-key", "favtuts")  // add request headers
            .addHeader("User-Agent", "OkHttp Bot")
            .build();
        
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Get response headers
                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i ++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                 // Get response body
                System.out.println(response.body().string());
            }
        });
    }
}
