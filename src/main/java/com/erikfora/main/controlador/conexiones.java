package com.erikfora.main.controlador;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class conexiones {

    public String obtener_datos(String search){

        search.replaceAll(" ","%20");
         String url = "https://gutendex.com/books/?search=" + search;


         HttpClient cliente = HttpClient.newHttpClient();
         HttpRequest solicitud = HttpRequest.newBuilder()
                 .uri(URI.create(url))
                 .build();
         HttpResponse<String> respuesta = null;

         try {
             respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

         }catch (Exception e){
             throw new RuntimeException();
         }

         return respuesta.body();
     }

}
