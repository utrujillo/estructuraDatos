package com.company;

import java.util.Scanner;

/**
 * Created by codehero on 09/09/17.
 * Metodos generales, estos seran reutilizados a lo largo de las aplicaciones
 */
public class Generales {

    // Variables globales
    public Scanner sc = new Scanner(System.in);

    // Metodo para imprimir una linea con salto de linea
    public void imprime(String valor)
    {
        System.out.println(valor);
    }

    // Metodo para imprimir una linea con el valor
    public void imprimel(String valor)
    {
        System.out.print(valor);
    }

    // Metodo para imprimir varias lineas en blanco
    public void limpiaPantalla(int lineas)
    {
        for (int i = 0; i < lineas; i++)
        {
            this.imprime("");
        }
    }
}
