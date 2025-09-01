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
public class ejercicio8 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedir datos
        System.out.print("Ingresa primer número entero: ");
        int num1 = sc.nextInt();
        
        System.out.print("Ingresa segundo número entero: ");
        int num2 = sc.nextInt();
        
        if (num2 != 0) {
            int division = num1 / num2; // Division Entera
            
            double divisionDecimal = (double) num1 / num2; // Division Decimal
            
            // Mostrar resultados
            System.out.println("División entera: " + division);
            System.out.println("Division decimal: " + divisionDecimal);
        } else {
            System.out.println("Error: no se puede dividir entre 0.");
        }
        
        sc.close();
    }
}
