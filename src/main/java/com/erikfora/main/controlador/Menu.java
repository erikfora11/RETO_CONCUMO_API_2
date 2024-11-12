package com.erikfora.main.controlador;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.erikfora.main.modelos.Autores;
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
    @Autowired
    private autorRepo repoAutor;

    public Menu(libroRepo repolibro,autorRepo repoAutor) {
        this.repolibro = repolibro;
        this.repoAutor = repoAutor;
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
                            4. buscar libros con idiomas en la base de datos
                            5. Buscar autores por año de nacimiento
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

                case 4:
                    System.out.println("inserte el idioma:");
                    String idioma = '{' + teclado.next() + '}';
                    System.out.println(idioma);
                    libro_idioma(idioma);
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }

        }

    }

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
        Libro libro_Unidad = new Libro();

        libro_Unidad.setId(encontrado.getFirst().getId());
        libro_Unidad.setTitulo(encontrado.getFirst().getTitulo());
        libro_Unidad.setAutores(encontrado.getFirst().getAutores());
        libro_Unidad.setDescargas(encontrado.getFirst().getDescargas());
        libro_Unidad.setLenguaje(encontrado.getFirst().getLenguaje());

        libro_Unidad.getAutores().getFirst().setId(libro_Unidad.getId());

        System.out.println(libro_Unidad);
        System.out.println(libro_Unidad.getAutores().toString());

        repolibro.save(libro_Unidad);

    }

    public  void encontrar_autor(Resultados resultado,String autor){
        List<Autores> encontrado = resultado.getLibros().getFirst().getAutores().stream().toList();

        Autores autor_unidad = new Autores();

        autor_unidad.setNombre(encontrado.getFirst().getNombre());
        autor_unidad.setNacimiento(encontrado.getFirst().getNacimiento());
        autor_unidad.setMuerte(encontrado.getFirst().getNacimiento());

        System.out.println(autor_unidad.toString());

        repoAutor.save(autor_unidad);

    }

    void libro_idioma(String idioma){
       Optional<Libro> libros_encontrados = repolibro.findByLenguaje(idioma);
       if (libros_encontrados.isPresent()){
           System.out.println(libros_encontrados);
       }else {
           System.out.println("no encontrados");
       }
    }


}
