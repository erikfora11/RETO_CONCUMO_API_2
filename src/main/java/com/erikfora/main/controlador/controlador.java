package com.erikfora.main.controlador;

import java.util.Scanner;

public class controlador {
     public void buscar_libro(){
         conexiones encontrar = new conexiones();
         System.out.println(encontrar.obtener_datos());
     }
}
