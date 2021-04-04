package com.digiboy.erp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static String jsonString(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.warn(e.getMessage(), e);
        }
        return object.toString();
    }
}
