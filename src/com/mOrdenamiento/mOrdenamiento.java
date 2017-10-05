package com.mOrdenamiento;

import java.util.Arrays;

/**
 * Created by codehero on 03/10/17.
 */
public class mOrdenamiento
{

    // Metodo de ordenamiento Burbuja
    public void bubbleSort( Integer[] toOrder ){
        Integer i, j;

        for (i = 0; i < toOrder.length - 1; i++)
        {
            for (j = 0; j < toOrder.length - 1; j++)
            {
                if (toOrder[ j ] > toOrder[ j + 1 ])
                {
                    Integer auxIntercambio = toOrder[ j + 1 ];
                    toOrder[ j + 1 ] = toOrder[ j ];
                    toOrder[ j ] = auxIntercambio;
                }

            }
        }

        System.out.println( "Arreglo ordenado con Algoritmo Burbuja: "+ Arrays.toString( toOrder ) );

    }

    // Metodo de ordenamiento Quicksort
    public Integer[] quickSort(Integer[] toOrder, Integer izquierda, Integer derecha) {
        //1. Elegir el pivote
        int pivote = toOrder[ izquierda ];
        //2. Los elementos > al pivote van a su derecha, los < a su izquierda
        //esta parte de la implementación es el corazón del ordenamiento
        //se utilizan variables auxiliares:
        //- i para controlar los elementos a la izquierda del pivote
        //- j para controlar los elementos a la derecha del pivote
        int i = izquierda;
        int j = derecha;
        //esta variable debería tener un alcance menor pero se respeta la implementación
        int auxIntercambio;
        //mientras que deban evaluarse los elementos en el arreglo
        //para ubicar al nuevo pivote
        while( i < j )
        {
            //mientras que el elemento vector[i] sea menor o igual al pivote
            //se aumenta el valor de i
            //cuando este loop se detenga, el elemento en vector[i]
            //es mayor a pivote y deberá ir a su derecha
            while( toOrder[ i ] <= pivote && i < j )
            {
                i++;
            }
            //mientras que el elemento vector[j] sea menor o igual al pivote
            //se desminuye el valor de j
            //cuando este loop se detenga, el elemento en vector[j]
            //es menor o igual a pivote y deberá ir a su izquierda
            while( toOrder[ j ] > pivote )
            {
                j--;
            }
            //siempre y cuando i sea menor a j, se hace un cambio de los elementos
            //puesto que el elemento en vector[i] debe ir a la derecha
            //y vector[j] a la izquierda
            if( i < j )
            {
                auxIntercambio = toOrder[ i ];
                toOrder[ i ] = toOrder[ j ];
                toOrder[ j ] = auxIntercambio;
            }
        }
        //si j es menor a i, entonces se utilizará j como la nueva ubicación
        //del pivote
        //en este caso, la ubicación del pivote es vector[izquierda] tal como
        //se encuentra al comienzo de la implementación
        toOrder[ izquierda ] = toOrder[ j ];
        toOrder[ j ] = pivote;
        //3. Para A1 y A2, aplicar el mismo proceso.
        if( izquierda < j - 1 )
        {
            //quicksort aplicado a A1
            quickSort( toOrder, izquierda, j - 1 );
        }

        if ( j + 1 < derecha )
        {
            //quicksort aplicado a A2
            quickSort( toOrder, j + 1, derecha );
        }

        return toOrder;
    }

    public void shellSort(Integer toOrder[]){
        int salto, auxIntercambio, i;
        boolean cambios;
        for( salto = toOrder.length/2; salto != 0; salto /= 2 )
        {
            cambios = true;
            while( cambios ) // Mientras se intercambie algún elemento
            {
                cambios = false;
                for( i = salto; i < toOrder.length; i++) // se da una pasada
                {
                    if ( toOrder[ i - salto ] > toOrder[ i ] ) { // y si están desordenados
                        auxIntercambio = toOrder[ i ]; // se reordenan
                        toOrder[ i ] = toOrder[ i - salto ];
                        toOrder[ i - salto ] = auxIntercambio;
                        cambios = true; // y se marca como cambio.
                    }
                }
            }
        }

        System.out.println( "Arreglo ordenado con Algoritmo Shellsort: "+ Arrays.toString( toOrder ) );
    }

}
