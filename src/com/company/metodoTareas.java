package com.company;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

/**
 * Created by codehero on 07/09/17.
 */
public class metodoTareas extends Generales
{

    // Variables globales privadas
    Stack<String> pilaBase = new Stack();
    LinkedList<String> colaBase = new LinkedList();
    private Pila pila = new Pila();
    private Cola cola = new Cola();

    // Metodos =====================
    public void menuPrincipal()
    {
        Integer opcion = 0;
        this.imprime("Estructura de Datos - Menú Principal");
        this.imprime("Selecciona el numero de opcion que deseas realizar");
        this.imprime("1.- Pila");
        this.imprime("2.- Cola");
        this.imprime("3.- ¿?");
        this.imprime("4.- ¿?");
        this.imprime("5.- ¿?");
        this.imprime("6.- Terminar");


        try
        {
            opcion = sc.nextInt();
            switch (opcion)
            {
                case 1:
                    this.imprime("");
                    this.menuPila();
                    break;
                case 2:
                    this.imprime("1");
                    this.menuCola();
                    break;
                case 6:
                    this.imprime("Gracias por utilizar el programa, vuelve pronto!!");
                    break;
                default:
                    this.imprime("Opción no valida, favor de seleccionar una correcta");
                    this.menuPrincipal();
                    break;
            }
        }
        catch (Exception ex)
        {
            this.imprime("Error!! seleccionar solo numeros enteros, volver a ejecutar");

        }
    }

    // Menu de Pila =====================
    public void menuPila()
    {
        Integer opcion = 0;
        this.imprime("Submenu - Pila (Primero en Entrar - Ultimo en Salir)");
        this.imprime("Selecciona el numero de opcion que deseas realizar");
        this.imprime("1.- Agregar datos a la pila(poner)");
        this.imprime("2.- Consultar datos de la pila");
        this.imprime("3.- Sacar datos de la pila");
        this.imprime("4.- Regresar al menu principal");

        try
        {
            opcion = sc.nextInt();
            switch (opcion)
            {
                case 1:
                    this.pilaBase = pila.pilaIngresaDatos( this.pilaBase );
                    this.menuPila();
                    break;
                case 2:
                    pila.pilaVerDatos( this.pilaBase );
                    this.imprime("");
                    this.menuPila();
                    break;
                case 3:
                    this.pilaBase = pila.pilaEliminaDatos( this.pilaBase );
                    this.imprime("");
                    this.menuPila();
                    break;
                case 4:
                    this.menuPrincipal();
                    break;
                default:
                    this.imprime("Opción no valida, favor de seleccionar una correcta");
                    this.menuPila();
                    break;
            }
        }
        catch (Exception ex)
        {
        this.imprime("Error!! seleccionar solo numeros enteros, volver a ejecutar");

        }
    }

    // Menu de Cola=====================
    public void menuCola()
    {
        Integer opcion = 0;
        this.imprime("Submenu - Cola (Primero en Entrar - Primero en Salir)");
        this.imprime("Selecciona el numero de opcion que deseas realizar");
        this.imprime("1.- Agregar datos a la cola(poner)");
        this.imprime("2.- Consultar datos de la cola");
        this.imprime("3.- Sacar datos de la cola(quita)");
        this.imprime("4.- Regresar al menu principal");

        try
        {
            opcion = sc.nextInt();
            switch (opcion)
            {
                case 1:
                    this.colaBase = cola.colaIngresaDatos( this.colaBase );
                    this.menuCola();
                    break;
                case 2:
                    cola.colaVerDatos( this.colaBase );
                    this.imprime("");
                    this.menuCola();
                    break;
                case 3:
                    this.colaBase = cola.colaEliminaDatos( this.colaBase );
                    this.imprime("");
                    this.menuCola();
                    break;
                case 4:
                    this.menuPrincipal();
                    break;
                default:
                    this.imprime("Opción no valida, favor de seleccionar una correcta");
                    this.menuCola();
                    break;
            }
        }
        catch (Exception ex)
        {
            this.imprime("Error!! seleccionar solo numeros enteros, volver a ejecutar");

        }
    }


}
