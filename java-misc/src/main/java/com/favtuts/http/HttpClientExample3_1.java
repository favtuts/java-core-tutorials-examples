package com.favtuts.http;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientExample3_1 {

    public static void main(String[] args) {
        
        try {
            String result = sendPOST("https://httpbin.org/post");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private static String sendPOST(String url) throws IOException {

        String result = "";
        HttpPost post = new HttpPost(url);

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"name\":\"favtuts\",");
        json.append("\"notes\":\"hello\"");
        json.append("}");

        // send a JSON data
        post.setEntity(new StringEntity(json.toString()));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(post)) {

            // Get HttpResponse Status
            System.out.println(response.getProtocolVersion());              // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode());   // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
            System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK
            
            result = EntityUtils.toString(response.getEntity());
            
        }

        return result;

    }

}
