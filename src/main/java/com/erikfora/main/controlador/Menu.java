package com.erikfora.main.controlador;

import java.util.Scanner;
import com.fasterxml.jackson.core.JsonProcessingException;


public class Menu {

    private final String  menu = """
    ========================= MENU =========================
           1. Salir
           2. buscar titulo
           3. buscar autor
    ==========================================================       
    """;

    public void iniciar() throws JsonProcessingException {

        Scanner teclado = new Scanner(System.in);
        controlador control = new controlador();
        String libro;
        int seleccion = 0;

        while (seleccion != 1) {

            System.out.println(menu);
            seleccion = teclado.nextInt();

            switch (seleccion){
                case 1:
                    System.out.println("======================FIN=========================");
                    break;
                case 2:
                    System.out.println("inserte el nombre del libro:");
                    libro = teclado.next();
                    control.buscar_libro(libro);
                    break;
                case 3:
                    System.out.println("inserte el nombre del autor:");
                    libro = teclado.next();
                    control.buscar_autor(libro);
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }

        }

    }
}
