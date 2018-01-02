package com.gyq.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.gyq.exception.JsonException;

import java.util.ArrayList;
import java.util.List;

/**
 * jackson转换基础类.
 *
 * @auther gaoyaqiu
 */
public class JsonConverter {
    private static JsonConverter jsonConverter = new JsonConverter();
    private ObjectMapper objMapper;
    private TypeFactory typeFactory;

    private JsonConverter() {
        this.objMapper = new ObjectMapper();
        // 属性为NULL 不序列化
        this.objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 属性为 空（“”）  或者为 NULL 都不序列化
        // 如果设置了对于数字类型数据不能输出 0 这个数字
        //this.objMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 忽略序列化时,json字符串中有bean中没有的属性
        this.objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 支持字符串转义
        this.objMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
        this.typeFactory = TypeFactory.defaultInstance();
    }

    public static JsonConverter getInstance() {
        return jsonConverter;
    }

    public String object2Json(Object objValue) {
        String rtnValue = null;
        try {
            rtnValue = this.objMapper.writeValueAsString(objValue);
        } catch (Exception ex) {
            throw new JsonException(ex);
        }
        return rtnValue;
    }

    public JsonNode json2JsonNode(String jsonString) {
        try {
            return ((JsonNode) this.objMapper.readValue(jsonString, JsonNode.class));
        } catch (Exception ex) {
            throw new JsonException(ex);
        }
    }

    public <T> T json2Object(Class<T> targetClzz, Object jsonObject) {
        try {
            return this.objMapper.readValue(jsonObject.toString(), targetClzz);
        } catch (Exception ex) {
            throw new JsonException(ex);
        }
    }

    public <T> List<T> json2List(Class<T> targetClzz, Object jsonObject) {
        try {
            return ((List) this.objMapper.readValue(jsonObject.toString(), this.typeFactory.constructParametricType(ArrayList.class, new Class[]{targetClzz})));
        } catch (Exception ex) {
            throw new JsonException(ex);
        }
    }

}
