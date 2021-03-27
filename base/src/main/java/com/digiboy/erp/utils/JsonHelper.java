package com.digiboy.erp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.jackson.JsonObjectDeserializer;

public class JsonHelper {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    public static String jsonString(Object object) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }

}
