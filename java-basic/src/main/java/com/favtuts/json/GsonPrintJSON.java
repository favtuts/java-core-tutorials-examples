package com.favtuts.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonPrintJSON {
    
    public static void main(String[] args) {
        // gsonCompactPrint();
        gsonPrettyPrint();
    }

    static void gsonPrettyPrint() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String[] lang = {"Java", "Node", "Kotlin", "JavaScript"};

        String json = gson.toJson(lang);

        System.out.println(json);
    }

    static void gsonCompactPrint() {
        Gson gson = new Gson();

        String[] lang = {"Java", "Node", "Kotlin", "JavaScript"};

        String json = gson.toJson(lang);

        System.out.println(json);
    }
}