package com.favtuts.io.howto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

public class CloudFlareBanIP {

    private static final String CF_AUTH_EMAIL = "cf_auth_email" ; //PropertyUtils.getInstance().getValue("cf_auth_email");
    private static final String CF_AUTH_TOKEN = "cf_auth_token" ; // PropertyUtils.getInstance().getValue("cf_auth_token");
    private static final String JSON_TYPE = "application/json";
    
    private static Header[] HTTP_HEADERS = {
        new BasicHeader("X-Auth-Email", CF_AUTH_EMAIL),
        new BasicHeader("X-Auth-Key", CF_AUTH_TOKEN),
        new BasicHeader("content-type", JSON_TYPE)
    };
    
    private HttpClient httpClient = HttpClientBuilder.create()
        .setConnectionTimeToLive(10, TimeUnit.SECONDS)
        .build();

    public HttpClient getHttpclient() {
        return httpClient;
    }

    public String banIp(String ip, String note) throws IOException {

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"mode\":\"block\",");
        json.append("\"configuration\":" + "{\"target\":\"ip\",\"value\":\"" + ip + "\"}" + ",");
        json.append("\"notes\":\"" + note + "\"");
        json.append("}");

        StringBuilder result = new StringBuilder();
        HttpPost post = new HttpPost("https://api.cloudflare.com/client/v4/user/firewall/access_rules/rules");
        post.setHeaders(HTTP_HEADERS);
        post.setEntity(new StringEntity(json.toString()));

        // read response from the POST request
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(getHttpclient().execute(post).getEntity().getContent())
        )) {
            String line;
            while((line = br.readLine()) != null) {
                result.append(line);
            }
        }

        return result.toString();
    }
}
