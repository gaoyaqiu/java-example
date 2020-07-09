package com.gyq.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.gyq.json.JsonConverter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * jackson工具类.
 *
 * @auther gaoyaqiu
 */
public class JsonUtil {

    public static String object2Json(Object objValue){
        return JsonConverter.getInstance().object2Json(objValue);
    }

    public static <T> T json2Object(Class<T> targetClzz, String jsonString) {
        Object rtnValue = null;
        JsonConverter jsonConverter = JsonConverter.getInstance();
        rtnValue = jsonConverter.json2Object(targetClzz, jsonString);
        return (T) rtnValue;
    }

    public static <T> T json2Object(Class<T> targetClzz, Object jsonString) {
        Object rtnValue = null;
        JsonConverter jsonConverter = JsonConverter.getInstance();
        rtnValue = jsonConverter.json2Object(targetClzz, jsonString);
        return (T) rtnValue;
    }


    public static <T> T json2Object(Class<T> targetClzz, String fieldName, String jsonString) {
        Object rtnValue = null;
        JsonConverter jsonConverter = JsonConverter.getInstance();
        if (fieldName == null) {
            rtnValue = jsonConverter.json2Object(targetClzz, jsonString);
        } else {
            JsonNode root = jsonConverter.json2JsonNode(jsonString);
            if(root.get(fieldName) == null){
                return null;
            }
            rtnValue = jsonConverter.json2Object(targetClzz, root.get(fieldName));
        }
        return (T) rtnValue;
    }

    public static Map<String, Object> json2Map(String fieldName, String jsonString) {
        return ((Map) json2Object(HashMap.class, fieldName, jsonString));
    }

    public static Map<String, Object> json2LinkedHashMap(String fieldName, String jsonString) {
        return ((Map) json2Object(LinkedHashMap.class, fieldName, jsonString));
    }


    public static <T> List<T> json2List(Class<T> targetClzz, String fieldName, String jsonString) {
        List rtnValue = null;
        JsonConverter jsonConverter = JsonConverter.getInstance();
        if (fieldName == null) {
            rtnValue = jsonConverter.json2List(targetClzz, jsonString);
        } else {
            JsonNode root = jsonConverter.json2JsonNode(jsonString);
            rtnValue = jsonConverter.json2List(targetClzz, root.get(fieldName));
        }
        return rtnValue;
    }

    public static <T> List<T> json2List(Class<T> targetClzz, String jsonString) {
        List rtnValue = null;
        JsonConverter jsonConverter = JsonConverter.getInstance();

        JsonNode root = jsonConverter.json2JsonNode(jsonString);
        rtnValue = jsonConverter.json2List(targetClzz, root);

        return rtnValue;
    }

    public static List<HashMap> json2MapList(String fieldName, String jsonString) {
        return json2List(HashMap.class, fieldName, jsonString);
    }

    public static JsonNode json2JsonNode(String jsonString) {
        return JsonConverter.getInstance().json2JsonNode(jsonString);
    }
}
