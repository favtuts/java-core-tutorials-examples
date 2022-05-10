package com.favtuts.http;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpExample4 {

    private final OkHttpClient httpClient = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        OkHttpExample4 obj = new OkHttpExample4();
        obj.sendPOST();
    }
    
    private void sendPOST() throws IOException {

        // json formatted data
        String json = new StringBuilder()
                .append("{")
                .append("\"name\":\"favtuts\",")
                .append("\"notes\":\"hello\"")
                .append("}").toString();

		// json request body
        RequestBody body = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url("https://httpbin.org/post")
                .addHeader("User-Agent", "OkHttp Bot")
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }

    }
}
