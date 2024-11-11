package com.erikfora.main.controlador;

import com.erikfora.main.modelos.Libro;
import com.erikfora.main.modelos.Resultados;
import com.erikfora.main.servicios.convertirDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class controlador {


    public void buscar_libro(String libro) throws JsonProcessingException {

         convertirDatos conversor = new convertirDatos();
         ObjectMapper mapper = new ObjectMapper();
         conexiones conexion = new conexiones();
         String json = conexion.obtener_datos(libro);
         System.out.println(json);
         Resultados resultado = mapper.readValue(json, Resultados.class);
         encontrar_libro(resultado,libro);
     }

    public void buscar_autor(String autor) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        conexiones conexion = new conexiones();
        convertirDatos conversor = new convertirDatos();
        String json = conexion.obtener_datos(autor);
        System.out.println(json);
        Resultados resultado = mapper.readValue(json, Resultados.class);
        encontrar_autor(resultado,autor);
    }

    public  void encontrar_libro(Resultados resultado,String libro){
        Optional<Libro> encontrado = resultado.getLibros().stream().findFirst();
        System.out.println(encontrado.toString());
    }

    public  void encontrar_autor(Resultados resultado,String autor){
        Optional<Libro> encontrado = resultado.getLibros().stream().findFirst();
        System.out.println(encontrado.toString());
    }
}
