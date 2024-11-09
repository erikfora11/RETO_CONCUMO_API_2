package com.erikfora.main.controlador;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class conexiones {

    public String obtener_datos(){

         Scanner teclado = new Scanner(System.in);
         String libro = teclado.nextLine().replaceAll(" ","%20");
         System.out.println(libro);
         String url = "https://gutendex.com/books/?search=" + libro;


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
