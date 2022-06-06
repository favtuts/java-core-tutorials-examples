package com.favtuts.json.gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.favtuts.json.gson.pojo.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class GsonJavaObjectJSON {
    
    public static void main(String[] args) {
        // convertJavaObjectToJSON();
        // convertJsonToJavaObject();
        convertJsonToJsonElement();
    }

    static void convertJsonToJsonElement() {
        // pretty print 
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Reader reader = new FileReader("/home/tvt/workspace/favtuts/staff.json")) {
		
            // Convert JSON to JsonElement, and later to String
            JsonElement json = gson.fromJson(reader, JsonElement.class);

            String jsonInString = gson.toJson(json);
			
            System.out.println(jsonInString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void convertJsonToJavaObject() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("/home/tvt/workspace/favtuts/staff.json")) {

            // Convert JSON File to Java Object
            Staff staff = gson.fromJson(reader, Staff.class);
			
			// print staff object
            System.out.println(staff);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void convertJavaObjectToJSON() {
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Staff staff = createStaffObject();

        // Java objects to String
        // String json = gson.toJson(staff);

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
        staff.setPosition(new String[]{"Founder", "CTO", "Writer"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;

    }
}
