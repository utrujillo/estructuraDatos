package com.mOrdenamiento;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by codehero on 04/10/17.
 */
public class ordenamientos {

    public Integer[] myArray;

    public static void main(String[] args)
    {
        ordenamientos principal = new ordenamientos();

        principal.addItems();

        principal.menu();
    }

    public void menu()
    {
        Scanner sc = new Scanner(System.in);
        Integer opcion = 0;

        this.imprime("\nMetodos de Ordenamiento - Menú Principal");
        this.imprime("Selecciona el numero de opcion que deseas realizar");
        this.imprime("1.- Bubbleshort");
        this.imprime("2.- Quicksort");
        this.imprime("3.- Shellsort");
        this.imprime("4.- Cambiar valores del arreglo");
        this.imprime("5.- Terminar");

        mOrdenamiento order = new mOrdenamiento();

        try
        {
            opcion = sc.nextInt();
            switch (opcion)
            {
                case 1:
                    this.imprime("");
                    order.bubbleSort( this.myArray );
                    this.menu();
                    break;
                case 2:
                    this.imprime("");
                    Integer[] quickSortOrder = order.quickSort( this.myArray, 0, this.myArray.length - 1 );
                    System.out.println( "Arreglo ordenado con Algoritmo QuickSort: "+ Arrays.toString( quickSortOrder ) );
                    this.menu();
                    break;
                case 3:
                    this.imprime("");
                    if ( this.myArray.length % 2 == 0 ) {
                        order.shellSort( myArray );
                    }else{
                        System.out.println("El metodo Shellsort funciona solo con multiplos de 2");
                    }
                    this.menu();
                    break;
                case 4:
                    this.addItems();
                    this.menu();
                    break;
                case 5:
                    this.imprime("Gracias por utilizar el programa, vuelve pronto!!");
                    break;
                default:
                    this.imprime("Opción no valida, favor de seleccionar una correcta");
                    this.menu();
                    break;
            }
        }
        catch (Exception ex)
        {
            this.imprime("Error!! seleccionar solo numeros enteros, volver a ejecutar");

        }
    }

    public void imprime(Object toPrint){
        System.out.println( toPrint );
    }

    public void addItems(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantos elementos deseas ordenar? ");
        this.myArray = new Integer[ sc.nextInt() ];

        // Leemos los numeros y los asignamos al arreglo principal(sin ordenar)
        for (Integer i = 0; i < this.myArray.length; i++)
        {
            this.myArray[ i ] = this.randomRange(0, 10000);
        }

        //Imprimimos los numeros almacenamos
        System.out.println( "Los datos insertados: " + Arrays.toString( this.myArray ) );
    }

    public int randomRange(int min, int max) {
        return (int) Math.round(((Math.random() * (max - min)) + min));
    }

}
