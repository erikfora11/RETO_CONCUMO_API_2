package com.erikfora.main.servicios;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConversor {
      <T> T convertirDatos (String json, Class<T> clase) throws JsonProcessingException;

}
