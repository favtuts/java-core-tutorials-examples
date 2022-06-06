package com.favtuts.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.favtuts.json.gson.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonParseJSON {

    public static void main(String[] args) {
        // javaObjectsToJSON();
        // jsonToJavaObjects();
        // printJSONcompactMode();
        // printJSONprettyMode();

        // displayJsonObjectIgnoreNull();
        displayJsonObjectIncludeNull();
    }

    static void displayJsonObjectIncludeNull() {
        Gson gson = new GsonBuilder().serializeNulls().create();

        Staff staff = createStaffObjectNull();
		
        String json = gson.toJson(staff);

        System.out.println(json);
    }

    static void displayJsonObjectIgnoreNull() {
        Gson gson = new Gson();

        Staff staff = createStaffObjectNull();
		
        String json = gson.toJson(staff);

        System.out.println(json);
    }

    private static Staff createStaffObjectNull() {

        Staff staff = new Staff();

        staff.setName("favtuts");
        staff.setAge(35);
   
        return staff;

    }

    static void printJSONprettyMode() {
        // pretty print
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String[] lang = { "Java", "Node", "Kotlin", "JavaScript" };
        String json = gson.toJson(lang);

        System.out.println(json);
    }

    static void printJSONcompactMode() {
        // compact print
        Gson gson = new Gson();

        String[] lang = { "Java", "Node", "Kotlin", "JavaScript" };
        String json = gson.toJson(lang);

        System.out.println(json);
    }

    static void jsonToJavaObjects() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("/home/tvt/workspace/favtuts/staff.json")) {

            // Convert JSON File to Java Object
            Staff staff = gson.fromJson(reader, Staff.class);

            // print staff
            System.out.println(staff);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void javaObjectsToJSON() {
        // pretty print
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Staff staff = createStaffObject();

        // Java objects to String
        String json = gson.toJson(staff);

        // System.out.println(json);

        // Java objects to File
        try (FileWriter writer = new FileWriter("/home/tvt/workspace/favtuts/staff.json")) {
            gson.toJson(staff, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Staff createStaffObject() {

        Staff staff = new Staff();

        staff.setName("favtuts");
        staff.setAge(35);
        staff.setPosition(new String[] { "Founder", "CTO", "Writer" });
        Map<String, BigDecimal> salary = new HashMap() {
            {
                put("2010", new BigDecimal(10000));
                put("2012", new BigDecimal(12000));
                put("2018", new BigDecimal(14000));
            }
        };
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;

    }
}
