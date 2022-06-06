package com.favtuts.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class GsonStreamingModelExamples {

    public static void main(String[] args) {
        // writeJSONasStream();
        readJSONasStream();
    }

    static void readJSONasStream() {
        try (JsonReader reader = new JsonReader(new FileReader("/home/tvt/workspace/favtuts/user.json"))) {

            reader.beginObject();

            while (reader.hasNext()) {

                String name = reader.nextName();

                if (name.equals("name")) {

                    System.out.println(reader.nextString());

                } else if (name.equals("age")) {

                    System.out.println(reader.nextInt());

                } else if (name.equals("messages")) {

                    // read array
                    reader.beginArray();

                    while (reader.hasNext()) {
                        System.out.println(reader.nextString());
                    }

                    reader.endArray();

                } else {
                    reader.skipValue(); // avoid some unhandle events
                }
            }

            reader.endObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeJSONasStream() {
        try (JsonWriter writer = new JsonWriter(new FileWriter("/home/tvt/workspace/favtuts/user.json"))) {

            writer.beginObject(); // {
            writer.name("name").value("favtuts"); // "name" : "favtuts"
            writer.name("age").value(29); // "age" : 29

            writer.name("messages"); // "messages" :
            writer.beginArray(); // [
            writer.value("msg 1"); // "msg 1"
            writer.value("msg 2"); // "msg 2"
            writer.value("msg 3"); // "msg 3"
            writer.endArray(); // ]

            writer.endObject(); // }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
