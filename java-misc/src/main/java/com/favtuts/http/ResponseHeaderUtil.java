package com.favtuts.http;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ResponseHeaderUtil {

    public static void main(String[] args) {
        getResponseHeadersURLConnection();
        //getResponseHeadersApacheHttpClient();
    }

    private static void getResponseHeadersApacheHttpClient() {
        try {

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("http://favtuts.com");
            HttpResponse response = client.execute(request);

            System.out.println("Printing Response Header...\n");

            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                System.out.println("Key : " + header.getName()
                        + " ,Value : " + header.getValue());

            }

            System.out.println("\nGet Response Header By Key ...\n");
            String server = response.getFirstHeader("Server").getValue();

            if (server == null) {
                System.out.println("Key 'Server' is not found!");
            } else {
                System.out.println("Server - " + server);
            }

            System.out.println("\n Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getResponseHeadersURLConnection() {
        try {

            URL obj = new URL("https://favtuts.com");
            URLConnection conn = obj.openConnection();
            Map<String, List<String>> map = conn.getHeaderFields();

            System.out.println("Printing Response Header...\n");

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                System.out.println("Key : " + entry.getKey()
                        + " ,Value : " + entry.getValue());
            }

            System.out.println("\nGet Response Header By Key ...\n");
            String server = conn.getHeaderField("Server");

            if (server == null) {
                System.out.println("Key 'Server' is not found!");
            } else {
                System.out.println("Server - " + server);
            }

            System.out.println("\n Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
