package com.erikfora.main.servicios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class convertirDatos implements IConversor {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertir(String json, Class<T> clase) throws JsonProcessingException {
        return mapper.readValue(json,clase);
    }
}
