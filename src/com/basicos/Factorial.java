package com.basicos;

/**
 * Created by codehero on 25/10/17.
 */
public class Factorial {
    public static void main(String[]args){
        Integer noFactoriales = 5;
        Factorial factorial = new Factorial();
        Integer resultado = factorial.calculoFactorial( noFactoriales );
        System.out.println( "El numero factorial es: "+ resultado +" de "+ noFactoriales +" numeros factorizados" );
    }
    // A continuacion la funcion recursiva del factorial
    public Integer calculoFactorial(int n){
        if(n==1 || n==0)
            return 1;
        else
            return n*calculoFactorial(n-1);
    }
}
