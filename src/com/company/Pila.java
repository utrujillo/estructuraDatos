package com.company;
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
public class Pila extends Generales
{
    // Ingresar datos a la Pila
    public Stack pilaIngresaDatos( Stack pila )
    {

        // Agregando los datos a la Pila
        this.imprimel("Ingresa un valor: ");
        pila.push( sc.next() );

        // Preguntando si se desea seguir agregando datos o regresar
        String volver;
        this.imprimel("Quieres agregar mas datos? S/N: ");
        volver = sc.next();

        if (volver.charAt(0) == 'S' || volver.charAt(0) == 's')
        {
            this.limpiaPantalla(2);
            this.pilaIngresaDatos( pila );
        }

        return pila;

    }

    // Ver información contenida en la Pila
    public void pilaVerDatos( Stack pila )
    {
        this.imprime("\nDatos de la Pila: ");

        for( int i = pila.size(); i > 0; i-- )
        {
            System.out.println( pila.get( i - 1 ) );
        }
    }

    // Eliminando el ultimo elemento de la pila(siempre)
    public Stack pilaEliminaDatos( Stack pila )
    {
        // Verificamos que la pila no este vacia para eliminar datos
        if (!pila.isEmpty())
        {
            this.imprime("Se ha eliminado este elemento ->" + pila.peek() +"<- de la pila");
            pila.pop();
        }
        else
        {
            this.imprime("La pila esta vacia, no se pueden eliminar datos");
        }

        return pila;
    }
}
