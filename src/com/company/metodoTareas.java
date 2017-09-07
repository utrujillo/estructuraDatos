package com.company;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by codehero on 07/09/17.
 */
public class metodoTareas extends Pila
{

    // Variables globales privadas
    private Scanner sc = new Scanner(System.in);
    Stack<String> pilaBase = new Stack();

    /**
     * Metodos generales, estos seran reutilizados a lo largo de las aplicaciones
     */
    public void imprime(String valor)
    {
        System.out.println(valor);
    }

    public void imprimel(String valor)
    {
        System.out.print(valor);
    }

    public void limpiaPantalla(int lineas)
    {
        for (int i = 0; i < lineas; i++)
        {
            this.imprime("");
        }
    }

    public void repeat(String tarea)
    {
        String volver;
        this.imprime("Deseas realizar otra acción? S/N: ");
        volver = sc.next();

        if (volver.charAt(0) == 'S' || volver.charAt(0) == 's')
        {
            this.limpiaPantalla(10);
            switch (tarea)
            {
                case "t1": this.menuPrincipal(); break;
                default: this.imprime("Opcion no encontrada"); break;
            }
        }
        else
        {
            this.imprime("Gracias por usar el sistema");
        }
    }

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
                    this.menuPila();
                    break;
                case 2:
                    this.imprime("Ir a menu Cola");
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
        this.imprime("Submenu - Pila");
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
                    this.pilaBase = this.pilaIngresaDatos( this.pilaBase );
                    this.menuPila();
                    break;
                case 2:
                    this.pilaVerDatos( this.pilaBase );
                    this.imprime("");
                    this.menuPila();
                    break;
                case 3:
                    this.pilaBase = this.pilaEliminaDatos( this.pilaBase );
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


}
