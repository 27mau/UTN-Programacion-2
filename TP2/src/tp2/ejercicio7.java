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
public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota;
        
        // Usamos do while para que se ejecute al menos una vez
        do {
            System.out.print("Ingrese una nota (0 - 10): ");
            nota = sc.nextInt();
            
            // Seguir pidiendo mientras la nota sea inválida
            if (nota < 0 || nota > 10) {
                System.out.println("Error: nota inválida. Ingrese un número entre 0 y 10.");
            }
            
        } while (nota < 0 || nota > 10);    
        
        // Cuando se sale del bucle, significa que la nota es correcta
        System.out.println("Nota guardada correctamente."); 
        sc.close();
    }    
}
