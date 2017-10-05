package com.shellsort;

import com.mOrdenamiento.mOrdenamiento;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by codehero on 04/10/17.
 */
public class shellsort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean accepted = false;
        Integer tamanoArray = 0;

        while ( accepted == false )
        {
            System.out.print("Cuantos elementos deseas ordenar? ");
            tamanoArray = sc.nextInt();

            if ( tamanoArray % 2 == 0 ) {
                accepted = true;
            }else{
                System.out.println("El metodo Shellsort funciona solo con multiplos de 2");
            }

        }

        Integer[] myArray = new Integer[ tamanoArray ];

        // Leemos los numeros y los asignamos al arreglo principal(sin ordenar)
        for (Integer i = 0; i < myArray.length; i++)
        {
            System.out.print("Inserta un digito: ");
            myArray[ i ] = sc.nextInt();
        }

        //Imprimimos los numeros almacenamos
        System.out.println( "Los datos insertados: " + Arrays.toString( myArray ) );


        mOrdenamiento order = new mOrdenamiento();

        order.shellSort( myArray );


    }

}
