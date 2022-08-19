/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.maquinadealimentosapg;

import java.util.Scanner;

/**
 * @author Arianne Pozo
 * UPB - 57439 - 19/08/2022
 */
public class MaquinaDeAlimentosAPG {
    
    static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {
        char producto;
        int precio,cantidad,moneda,cambio;
        
        producto = leerCaracter(); //Solicitar el producto
        
        precio = 0;
        cantidad = 0;
        cambio = 0;
        
        //Asignar el valor del producto en el precio
        switch (producto) {
            case 'A':
                precio = 270;
                break;
            case 'B':
                precio = 340;
                break;
            case 'C':        
                precio = 390;
                break;
            default:
                System.out.println("\nDigite uno de los productos disponibles");
                break;
        }
        
        //Solicitar las monedas hasta que correspondan al precio o un poco más
        while (cantidad < precio) {
            moneda = leerMoneda();
            
            //La moneda elegida se sumará a la cantidad total de dinero ingresada
            switch (moneda) {
                case 1:
                    cantidad = cantidad + 10;
                    break;
                case 2:
                    cantidad = cantidad + 50;
                    break;
                case 3:
                    cantidad = cantidad + 100; 
                    break;
                default:
                    System.out.println("\nIngrese las monedas válidas para la máquina");
                    break;
            }
        }
        
        System.out.println("\nPrecio del producto: " + precio + "$" );
        System.out.println("Cantidad ingresada: " + cantidad + "$\n" );
        
        if (cantidad > precio) {
            cambio = cantidad - precio;
            
            System.out.println("Su cambio: ");
            
            while (cambio > 0) {
                
                if (cambio >= 100) {
                    System.out.println("100");
                    cambio = cambio - 100;
                } else if(cambio >= 50) {
                    System.out.println("50");
                    cambio = cambio - 50;
                }else if (cambio < 50){
                    System.out.println("10");
                    cambio = cambio - 10; 
                }
            }
        }  
    }  
    
    //Leer la opcion de producto elegida
    public static char leerCaracter(){
        System.out.println("\nElija Producto:\n"
                            + "A -> 270$\n"
                            + "B -> 340$\n"
                            + "C -> 390$");
        return sn.next().toUpperCase().charAt(0);
    }
    
    //Leer las monedas introducidas en la máquina
    public static int leerMoneda(){
        System.out.println("\nIngrese las monedas:\n"
                + "1 -> 10$\n"
                + "2 -> 50$\n"
                + "3 -> 100$");
        return sn.nextInt();
    }
}