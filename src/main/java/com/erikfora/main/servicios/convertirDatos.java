package com.erikfora.main.servicios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class convertirDatos implements IConversor {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertirDatos(String json, Class<T> clase)throws JsonProcessingException{
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.readValue(json, clase);
    }

}
