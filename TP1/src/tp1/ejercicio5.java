/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamundo;
import java.util.Scanner;
/**
 *
 * @author Mauro
 */
public class ejercicio5 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Ingresar dos números
        System.out.print("Ingresa 1er número: ");
        int num1 = sc.nextInt();
        
        System.out.print("Ingresa 2do número: ");
        int num2 = sc.nextInt();
        
        // Las Operaciones
        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;
        
        // División
        if (num2 != 0) {
            double division = (double) num1 / num2;
            System.out.println("División: " + division);
        } else {
            System.out.println("No se puede dividir entre 0.");          
        }   
        
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        
        sc.close();
    }
    
}
