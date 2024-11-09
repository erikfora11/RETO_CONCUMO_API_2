package com.erikfora.main.controlador;

import com.erikfora.main.modelos.Resultados;
import com.erikfora.main.servicios.convertirDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.GsonBuilderUtils;

public class controlador {

    public void buscar_libro() throws JsonProcessingException {

         convertirDatos conversor = new convertirDatos();
         ObjectMapper mapper = new ObjectMapper();
         conexiones conexion = new conexiones();
         String json = conexion.obtener_datos();
         System.out.println(json);

         Resultados resultado = mapper.readValue(json, Resultados.class);
         System.out.println(resultado.toString());
     }
}
