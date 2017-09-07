package com.company;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by codehero on 07/09/17.
 * Pila.- Un espacio en memoria donde almacenaremos información de forma dinamica
 * Pila utiliza FILO(First In Last Out) - Primero en entrar ultimo en salir
 * Utilizaremos la clase Stack
 * push.- Insertar datos a la pila
 * pop.- Utilizado para quitar el ultimo dato de la pila, solo el ultimo
 * peek.- Utilizado para visualizar cual es el ultimo dato de la pila
 * empty.- Utilizado para saber si la pila tiene datos o no adentro
 */
public class Pila
{


    // Variables globales
    private Scanner sc = new Scanner(System.in);

    public void limpiaPantalla(int lineas)
    {
        for (int i = 0; i < lineas; i++)
        {
            System.out.println("");
        }
    }

    public Stack pilaIngresaDatos( Stack pila )
    {

        // Agregando los datos a la Pila
        System.out.println("Ingresa un valor: ");
        pila.push( sc.next() );

        // Preguntando si se desea seguir agregando datos o regresar
        String volver;
        System.out.println("Quieres agregar mas datos? S/N: ");
        volver = sc.next();

        if (volver.charAt(0) == 'S' || volver.charAt(0) == 's')
        {
            this.limpiaPantalla(5);
            this.pilaIngresaDatos( pila );
        }

        return pila;

    }

    public void pilaVerDatos( Stack pila )
    {
        System.out.println("\nDatos de la Pila: ");

        for( int i=0; i < pila.size(); i++ )
        {
            System.out.println( pila.get( i ) );
        }
    }

    public Stack pilaEliminaDatos( Stack pila )
    {
        // Verificamos que la pila no este vacia para eliminar datos
        if (!pila.isEmpty())
        {
            pila.pop();
            System.out.println("Se ha eliminado el ultimo elemento de la pila");
        }
        else
        {
            System.out.println("La pila esta vacia, no se pueden eliminar datos");
        }

        return pila;
    }

}
