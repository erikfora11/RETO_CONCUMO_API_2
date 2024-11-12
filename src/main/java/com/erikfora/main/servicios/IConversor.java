package com.erikfora.main.servicios;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConversor {
    public <T> T convertir(String json, Class<T> clase)throws JsonProcessingException;
}
