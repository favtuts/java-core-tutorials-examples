package com.favtuts.json;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.favtuts.json.nullfields.Staff;

public class JacksonIgnoreNullFields {
    
    public static void main(String[] args) {
        //includeNullFieldsByDefault();
        ignoreNullFieldsGlobally();
    }

    static void ignoreNullFieldsGlobally() {

        ObjectMapper mapper = new ObjectMapper();

        Staff staff = new Staff("favtuts", 38);

        try {

            // ignore the null fields globally
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);

            System.out.println(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void includeNullFieldsByDefault() {
        ObjectMapper mapper = new ObjectMapper();

        Staff staff = new Staff("favtuts", 38);

        try {

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);

            System.out.println(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
