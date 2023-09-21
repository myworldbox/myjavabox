package org.example.global;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public abstract class format {

    public static void print_non_empty(String msg) {
        if (!Objects.equals(msg, "")) {
            System.out.println(msg);
        }
    }

    public static void object_to_json_file(String filename, Object object) {
        try {
            Path filePath = Paths.get("allure-results", filename);
            Files.createDirectories(filePath.getParent());
            String json = new Gson().toJson(object);
            Files.write(filePath, json.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String value_type(Object value) {
        if (value instanceof JSONObject) {
            return "Object";
        } else if (value instanceof JSONArray) {
            return "Array";
        } else if (value instanceof String) {
            return "String";
        } else if (value instanceof Number) {
            return "Number";
        } else if (value instanceof Boolean) {
            return "Boolean";
        } else {
            return "Unknown";
        }
    }

    public static void iterate_obj(JSONObject jsonObject) {
        iterate_obj(jsonObject, "");
    }

    private static void iterate_obj(Object object, String prefix) {
        if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            for (Object keyObj : jsonObject.keySet()) {
                String key = (String) keyObj;
                Object value = jsonObject.get(key);
                if (value instanceof JSONObject) {
                    iterate_obj(value, prefix + key + ".");
                } else {
                    System.out.println("Key: " + prefix + key);
                    System.out.println("Value: " + value + "\n");
                }
            }
        }
    }

    public static JSONObject json_to_obj(String path) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(path)) {
            Object obj = parser.parse(reader);
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            } else {
                // Handle the case when the parsed JSON is not a JSONObject
                throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN);
            }
        } catch (IOException | ParseException e) {
            // Handle any exceptions that occur during parsing
            e.printStackTrace();
        }
        return null; // Return null if parsing fails
    }

    public static Object obj_get_child(JSONObject jsonObject, String path) {

        String[] keys = path.split("\\.");

        Object nestedObject = jsonObject;

        // Traverse the keys to access the deeply nested child element
        for (String key : keys) {
            if (nestedObject instanceof JSONObject) {
                nestedObject = ((JSONObject) nestedObject).get(key);
            } else if (nestedObject instanceof JSONArray) {
                int index = Integer.parseInt(key);
                nestedObject = ((JSONArray) nestedObject).get(index);
            } else {
                return null; // Return null for non-JSONObject and non-JSONArray values
            }
        }
        return nestedObject; // Return the final deeply nested child element
    }
}