package com.favtuts.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonMapExamples {

    public static void main(String[] args) {
        // convertJSONstringToMap();
        convertMapToJSONstring();
    }

    static void convertMapToJSONstring() {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> map = new HashMap<>();
        map.put("name", "favtuts");
        map.put("age", "37");

        try {

            // convert map to JSON string
            String json = mapper.writeValueAsString(map);

            System.out.println(json);   // compact-print

            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);

            System.out.println(json);   // pretty-print

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    static void convertJSONstringToMap() {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"name\":\"favtuts\", \"age\":\"37\"}";

        try {

            // convert JSON string to Map
            Map<String, String> map = mapper.readValue(json, Map.class);

            // it works
            // Map<String, String> map = mapper.readValue(json, new
            // TypeReference<Map<String, String>>() {});

            System.out.println(map);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
