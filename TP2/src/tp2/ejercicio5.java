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
public class ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num;    // número ingresado
        int suma = 0;   // acumular los números pares
        System.out.print("Ingresa un número (0 para terminar): ");
        num = sc.nextInt();
        
        // Bucle que continúa hasta ingresar el 0.
        while (num != 0) {
            // verifica si es par
            if (num % 2 == 0) {
                suma += num;    // suma si es par
            }
            
            // Ingresamos más números
            System.out.print("Ingrese un número (0 para terminar): ");
            num = sc.nextInt();
        }
        
        // Mostrar el resultado final
        System.out.println("La suma de los números pares es: " + suma);
    }
    
}
