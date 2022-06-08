/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeros;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dam
 */
public class Numeros {
     public static int pedirNumero(String mensaje){
        int numero=0;
        boolean tengoNumero= false;
        Scanner entrada = new Scanner(System.in);
        while(!tengoNumero){
            try{
                System.out.println(mensaje);
                numero=entrada.nextInt();
                if(numero<0){
                    System.out.println("Error. El valor debe ser positivo");
                }else{
                    tengoNumero=true;
                }
            }catch(InputMismatchException ex){
                System.out.println("Error. El valor debe ser numerico");
                entrada.nextLine();
            }
        }
        return numero;
    }
    
    public static int pedirNumero(String mensaje, int limiteInferior){
        int numero=0;
        boolean tengoNumero= false;
        Scanner entrada = new Scanner(System.in);
        while(!tengoNumero){
            try{
                System.out.println(mensaje);
                numero=entrada.nextInt();
                if(numero < limiteInferior){
                    System.out.println("Error. El valor no puede ser mas "
                            + "pequeño que "+ limiteInferior);
                }else{
                    tengoNumero=true;
                }
            }catch(InputMismatchException ex){
                System.out.println("Error. El valor debe ser numerico");
                entrada.nextLine();
            }
        }
        return numero;
    }
    
    public static int pedirNumero(String mensaje, int limiteInferior
            ,int limiteSuperior){
        
        int numero=0;
        boolean tengoNumero= false;
        Scanner entrada = new Scanner(System.in);
        while(!tengoNumero){
            try{
                System.out.println(mensaje);
                numero=entrada.nextInt();
                if(numero < limiteInferior || numero > limiteSuperior){
                    System.out.println("Error. El valor no puede ser mas "
                            + "pequeño que "+ limiteInferior 
                            + " o más grande que "+ limiteSuperior);
                }else{
                    tengoNumero=true;
                }
            }catch(InputMismatchException ex){
                System.out.println("Error. El valor debe ser numerico");
                entrada.nextLine();
            }
        }
        return numero;
    }
     public static float pedirNumeroReal(String mensaje){
        float numero=0;
        boolean tengoNumero= false;
        Scanner entrada = new Scanner(System.in);
        while(!tengoNumero){
            try{
                System.out.println(mensaje);
                numero=entrada.nextFloat();
                if(numero<0){
                    System.out.println("Error. El valor debe ser positivo");
                }else{
                    tengoNumero=true;
                }
            }catch(InputMismatchException ex){
                System.out.println("Error. El valor debe ser numerico");
                entrada.nextLine();
            }
        }
        return numero;
    }
    
    public static float pedirNumeroReal(String mensaje, float limiteInferior){
        float numero=0;
        boolean tengoNumero= false;
        Scanner entrada = new Scanner(System.in);
        while(!tengoNumero){
            try{
                System.out.println(mensaje);
                numero=entrada.nextFloat();
                if(numero < limiteInferior){
                    System.out.println("Error. El valor no puede ser mas "
                            + "pequeño que "+ limiteInferior);
                }else{
                    tengoNumero=true;
                }
            }catch(InputMismatchException ex){
                System.out.println("Error. El valor debe ser numerico");
                entrada.nextLine();
            }
        }
        return numero;
    }
    
    public static float pedirNumeroReal(String mensaje, float limiteInferior
            ,int limiteSuperior){
        
        float numero=0;
        boolean tengoNumero= false;
        Scanner entrada = new Scanner(System.in);
        while(!tengoNumero){
            try{
                System.out.println(mensaje);
                numero=entrada.nextFloat();
                if(numero < limiteInferior || numero > limiteSuperior){
                    System.out.println("Error. El valor no puede ser mas "
                            + "pequeño que "+ limiteInferior 
                            + " o más grande que "+ limiteSuperior);
                }else{
                    tengoNumero=true;
                }
            }catch(InputMismatchException ex){
                System.out.println("Error. El valor debe ser numerico");
                entrada.nextLine();
            }
        }
        return numero;
    }
}


