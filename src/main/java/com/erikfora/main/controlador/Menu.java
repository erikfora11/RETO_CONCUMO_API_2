package com.erikfora.main.controlador;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.erikfora.main.modelos.Libro;
import com.erikfora.main.modelos.Resultados;
import com.erikfora.main.servicios.autorRepo;
import com.erikfora.main.servicios.convertirDatos;
import com.erikfora.main.servicios.libroRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class Menu {
    @Autowired
    private libroRepo repolibro;

    public Menu(libroRepo repolibro) {
        this.repolibro = repolibro;
    }

    public void iniciar() throws JsonProcessingException {

        Scanner teclado = new Scanner(System.in);
        String libro;
        int seleccion = 0;

        while (seleccion != 1) {

            String menu = """
                     ========================= MENU =========================
                            1. Salir
                            2. buscar titulo
                            3. buscar autor
                     ==========================================================      \s
                    \s""";
            System.out.println(menu);
            seleccion = teclado.nextInt();

            switch (seleccion){
                case 1:
                    System.out.println("======================FIN=========================");
                    break;
                case 2:
                    System.out.println("inserte el nombre del libro:");
                    libro = teclado.next();
                    buscar_libro(libro);
                    break;
                case 3:
                    System.out.println("inserte el nombre del autor:");
                    libro = teclado.next();
                    buscar_autor(libro);
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }

        }

    }

    libroRepo repo_libros = new libroRepo();


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


        List<Libro> encontrado = resultado.getLibros().stream().findFirst().stream().toList();
        Libro libro_Unidad = encontrado.getFirst();
        System.out.println(libro_Unidad.toString());
        libro_Unidad.setId(Long.parseLong(String.valueOf(Math.random())));
        repolibro.guardar(libro_Unidad);

    }

    public  void encontrar_autor(Resultados resultado,String autor){
        Optional<Libro> encontrado = resultado.getLibros().stream().findFirst();
        System.out.println(encontrado.toString());
    }
}
