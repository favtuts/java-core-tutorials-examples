package com.favtuts.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonStreamingModelExamples {

    public static void main(String[] args) {
        // writeJSONToFile();
        // writeJSONarrayToFile();
        // readJSONfromFile();
        readJSONarrayFromFile();
    }

    static void readJSONarrayFromFile() {
        try (JsonParser jParser = new JsonFactory()
            .createParser(new File("/home/tvt/workspace/favtuts/user2.json"));) {

            // JSON array?
            if (jParser.nextToken() == JsonToken.START_ARRAY) {

                while (jParser.nextToken() != JsonToken.END_ARRAY) {

                    // loop until token equal to "}"
                    while (jParser.nextToken() != JsonToken.END_OBJECT) {

                        String fieldname = jParser.getCurrentName();
                        if ("name".equals(fieldname)) {
                            // current token is "name",
                            // move to next, which is "name"'s value
                            jParser.nextToken();
                            System.out.println(jParser.getText());
                        }

                        if ("age".equals(fieldname)) {
                            jParser.nextToken();
                            System.out.println(jParser.getIntValue());
                        }

                        if ("messages".equals(fieldname)) {

                            // jParser.nextToken(); // current token is "[", move next
                            if (jParser.nextToken() == JsonToken.START_ARRAY) {
                                // messages is array, loop until token equal to "]"
                                while (jParser.nextToken() != JsonToken.END_ARRAY) {
                                    System.out.println(jParser.getText());
                                }
                            }

                        }

                    }

                }
            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readJSONfromFile() {
        try (JsonParser jParser = new JsonFactory()
                .createParser(new File("/home/tvt/workspace/favtuts/user.json"));) {

            // loop until token equal to "}"
            while (jParser.nextToken() != JsonToken.END_OBJECT) {

                String fieldname = jParser.getCurrentName();

                if ("name".equals(fieldname)) {
                    // current token is "name",
                    // move to next, which is "name"'s value
                    jParser.nextToken();
                    System.out.println(jParser.getText());
                }

                if ("age".equals(fieldname)) {
                    jParser.nextToken();
                    System.out.println(jParser.getIntValue());
                }

                if ("messages".equals(fieldname)) {

                    if (jParser.nextToken() == JsonToken.START_ARRAY) {
                        // messages is array, loop until token equal to "]"
                        while (jParser.nextToken() != JsonToken.END_ARRAY) {
                            System.out.println(jParser.getText());
                        }
                    }

                }

            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeJSONarrayToFile() {
        ObjectMapper mapper = new ObjectMapper();

        try (JsonGenerator jGenerator = mapper.getFactory()
                .createGenerator(new File("/home/tvt/workspace/favtuts/user2.json"),
                        JsonEncoding.UTF8)) {

            // pretty print
            jGenerator.useDefaultPrettyPrinter();

            // start array
            jGenerator.writeStartArray(); // [

            jGenerator.writeStartObject(); // {

            jGenerator.writeStringField("name", "favtuts"); // "name" : "favtuts"
            jGenerator.writeNumberField("age", 38); // "age" : 38

            jGenerator.writeFieldName("messages"); // "messages" :

            jGenerator.writeStartArray(); // [

            jGenerator.writeString("msg 1"); // "msg 1"
            jGenerator.writeString("msg 2"); // "msg 2"
            jGenerator.writeString("msg 3"); // "msg 3"

            jGenerator.writeEndArray(); // ]

            jGenerator.writeEndObject(); // }

            // next object, pls

            jGenerator.writeStartObject(); // {

            jGenerator.writeStringField("name", "lap"); // "name" : "lap"
            jGenerator.writeNumberField("age", 5); // "age" : 5

            jGenerator.writeFieldName("messages"); // "messages" :

            jGenerator.writeStartArray(); // [

            jGenerator.writeString("msg a"); // "msg a"
            jGenerator.writeString("msg b"); // "msg b"
            jGenerator.writeString("msg c"); // "msg c"

            jGenerator.writeEndArray(); // ]

            jGenerator.writeEndObject(); // }

            jGenerator.writeEndArray(); // ]

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeJSONToFile() {

        ObjectMapper mapper = new ObjectMapper();
        try (JsonGenerator jGenerator = mapper.getFactory()
                .createGenerator(new File("/home/tvt/workspace/favtuts/user.json"),
                        JsonEncoding.UTF8)) {

            jGenerator.writeStartObject(); // {

            jGenerator.writeStringField("name", "favtuts"); // "name" : "favtuts"
            jGenerator.writeNumberField("age", 38); // "age" : 38

            jGenerator.writeFieldName("messages"); // "messages" :

            jGenerator.writeStartArray(); // [

            jGenerator.writeString("msg 1"); // "msg 1"
            jGenerator.writeString("msg 2"); // "msg 2"
            jGenerator.writeString("msg 3"); // "msg 3"

            jGenerator.writeEndArray(); // ]

            jGenerator.writeEndObject(); // }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
