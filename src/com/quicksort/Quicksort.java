package com.quicksort;

import com.mOrdenamiento.mOrdenamiento;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by codehero on 02/10/17.
 */
public class Quicksort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cuantos elementos deseas ordenar? ");
        Integer[] myArray = new Integer[ sc.nextInt() ];

        // Leemos los numeros y los asignamos al arreglo principal(sin ordenar)
        for (Integer i = 0; i < myArray.length; i++)
        {
            System.out.print("Inserta un digito: ");
            myArray[ i ] = sc.nextInt();
        }

        //Imprimimos los numeros almacenamos
        System.out.println( "Los datos insertados: " + Arrays.toString( myArray ) );
        /*for(Integer item : myArray){
            System.out.print( item+" " );
        }*/

        mOrdenamiento order = new mOrdenamiento();

        Integer[] quickSortOrder = order.quickSort( myArray, 0, myArray.length - 1 );

        System.out.println( "Arreglo ordenado con Algoritmo QuickSort: "+ Arrays.toString( quickSortOrder ) );

    }

}
