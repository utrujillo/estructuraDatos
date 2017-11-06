package com.basicos;

import java.util.Scanner;
/**
 * Created by codehero on 06/11/17.
 */
public class Recursividad {
    public Scanner sc = new Scanner(System.in);
    public String cadena = null;
    public String cadenaInvertida = null;
    public Integer pos = null;

    public static void main(String[] args) {
        Recursividad rec = new Recursividad();
        rec.leerCadena();
        rec.invertirCadena();
    }

    public void leerCadena(){
        System.out.print("Ingresa cadena a convertir: ");
        cadena = sc.nextLine();
        pos = cadena.length();
    }

    public void invertirCadena(){
        if( pos > 0 ){
            System.out.print(cadena.charAt( pos - 1 ));
            pos--;
            invertirCadena();
        }
    }
}
