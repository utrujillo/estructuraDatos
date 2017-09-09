package com.company;
import java.util.LinkedList;

/**
 * Created by codehero on 08/09/17.
 * Cola.- Un espacio en memoria donde almacenaremos información de forma dinamica
 * Cola utiliza FIFO(First In First Out) - Primero en entrar primero en salir
 * Offer.- Para añadir un dato
 * Poll .- Para obtener un dato
 */
public class Cola extends Generales
{
    // Ingresar datos a la Cola
    public LinkedList colaIngresaDatos( LinkedList cola )
    {

        // Agregando los datos a la Cola
        this.imprimel("Ingresa un valor: ");
        cola.offer( sc.next() );

        // Preguntando si se desea seguir agregando datos o regresar
        String volver;
        this.imprimel("Quieres agregar mas datos? S/N: ");
        volver = sc.next();

        if (volver.charAt(0) == 'S' || volver.charAt(0) == 's')
        {
            this.limpiaPantalla(2);
            this.colaIngresaDatos( cola );
        }

        return cola;

    }

    // Ver información contenida en la Cola
    public void colaVerDatos( LinkedList cola )
    {
        this.imprime("\nDatos de la Cola: ");

        for( int i = 0; i < cola.size(); i++ )
        {
            System.out.println( cola.get( i ) );
        }
    }

    // Eliminando el primer elemento de la cola(siempre)
    public LinkedList colaEliminaDatos( LinkedList cola )
    {
        // Verificamos que la cola no este vacia para eliminar datos
        if (!cola.isEmpty())
        {
            this.imprime("Se ha eliminado este elemento ->" + cola.peek() +"<- de la cola");
            cola.poll();
        }
        else
        {
            System.out.println("La cola esta vacia, no se pueden eliminar datos");
        }

        return cola;
    }

}
