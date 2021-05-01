package com.pb.laboratory.uitls;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public JsonUtils() {
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> T parseObject(byte[] src, Class<T> clazz) {
        try {
            return objectMapper.readValue(src, clazz);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> T parseObject(InputStream src, Class<T> clazz) {
        try {
            return objectMapper.readValue(src, clazz);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        try {
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
            return (List)objectMapper.readValue(json, listType);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static String writeValueAsString(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException var2) {
            throw new RuntimeException(var2);
        }
    }
}

