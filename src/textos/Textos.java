/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textos;

import Fecha.Fecha;
import java.util.Scanner;

/**
 *
 * @author dam
 */
public class Textos {
    public static String pedirString(String mensaje){
        Scanner entrada=new Scanner (System.in);
        String nombre;
        System.out.println(mensaje);
        nombre=entrada.nextLine();
        while(nombre.equalsIgnoreCase("")){
            System.out.println("Dato requerido");
            System.out.println(mensaje);
            nombre=entrada.nextLine();
        }
        return nombre;
    }
    public static Fecha pedirFecha(String mensaje){
        Fecha fintroducida= new Fecha();
        String dato;
        dato= pedirString (mensaje);
        while(fintroducida.validarFecha(dato)!=0){
            System.out.println("Fecha incorrecta. Vuelve a introducirla");
            dato= pedirString(mensaje);
    }
        return fintroducida;
    }
    
    public static boolean pedirBoolean(String mensaje){
        Scanner entrada=new Scanner (System.in);
        boolean nombre;
        System.out.println(mensaje);
        nombre=entrada.nextBoolean();
        
       
        return nombre;
    }
    
}
