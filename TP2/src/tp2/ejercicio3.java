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
public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Ingresamos la edad
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();
        
        // Clasificamos según la edad
        if (edad < 12) {
            System.out.println("Eres un niño.");
        } else if (edad >= 12 && edad <= 17) {
            System.out.println("Eres un adolescente.");
        } else if (edad >= 18 && edad <= 59) {
            System.out.println("Eres un adulto.");
        } else {
            System.out.println("Eres un adulto mayor.");
        }
        
        sc.close();
    }
    
    
}
