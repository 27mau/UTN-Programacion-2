/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2;
import java.util.Scanner;

/**
 *
 * @author Mauro
 */
public class ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        System.out.print("Ingrese un año: ");
        int anio = sc.nextInt(); // Lee el año como entero
        
        // Verificación de año bisisesto
        // anio % 4 == 0: múltiplo de 4
        // anio % 100 != 0: descartamos los múltiplos de 100
        // anio % 400 == 0: los múltiplos de 400 son bisiestos.
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println(anio + " es bisiesto.");
        } else {
            System.out.println(anio + " no es bisiesto.");
        }              
        
        sc.close();
    }
    
}
