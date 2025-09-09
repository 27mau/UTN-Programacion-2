/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;
import java.util.Scanner;

/**
 *
 * @author Mauro
 */
public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Solicitamos los 3 números.
        System.out.print("Ingrese el 1er número: ");
        int num1 = sc.nextInt();
        
        System.out.print("Ingrese el 2do número: ");
        int num2 = sc.nextInt();
        
        System.out.print("Ingrese el 3er número: ");
        int num3 = sc.nextInt();
        
        // Comenzamos el mayor con el primer número
        int mayor = num1;
        
        // Comparamos con el segundo número
        if (num2 > mayor) {
            mayor = num2;
        }
        
        // Comparamos con el tercer número
        if (num3 > mayor) {
            mayor = num3;
        }
        
        // Mostramos el resultado
        System.out.println("El mayor número es: " + mayor);
        
        sc.close();
    }
}
