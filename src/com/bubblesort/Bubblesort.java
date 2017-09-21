package com.bubblesort;
import java.util.Scanner;

/**
 * Created by codehero on 21/09/17.
 */
public class Bubblesort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer[] myArray = new Integer[9];
        Integer i, j;

        // Leemos los numeros
        for (i = 0; i < myArray.length; i++)
        {
            System.out.print("Inserta un digito: ");
            myArray[i] = sc.nextInt();
        }

        //Imprimimos los numeros almacenamos
        System.out.println("\nLos datos insertados:");
        for (i = 0; i < myArray.length; i++)
        {
            System.out.print(myArray[i] + " ");
        }

        // Realizo el ordenamiento burbuja en orden ascendente
        System.out.println("\n\nDatos ordenados con buble sort Ascendente");
        for (i = 0; i < myArray.length - 1; i++)
        {
            for (j = 0; j < myArray.length - 1; j++)
            {

                if (myArray[j] > myArray[j + 1])
                {
                    int tmp = myArray[j+1];
                    myArray[j+1] = myArray[j];
                    myArray[j] = tmp;
                }

            }
        }

        for (i = 0; i < myArray.length; i++)
        {
            System.out.print(myArray[i] + " ");
        }

    }
}
