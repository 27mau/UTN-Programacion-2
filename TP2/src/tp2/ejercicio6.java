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
public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int positivos = 0;  // Acumulamos los números positivos
        int negativos = 0;  // Acumulamos los números negativos
        int ceros = 0;      // Acumulamos los ceros
        
        // Solicitamos los 10 números.
        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int num = sc.nextInt();
        
            if (num > 0) {
                positivos++;    // Conteo de números positivos
            } else if (num < 0) {
                negativos++;    // Conteo de números negativos
            } else {
                ceros++;        // Conteo de ceros
            }  
        }
        
        // Mostramos los resultados
        System.out.println("Resultados total: ");
        System.out.println("Números positivos: " + positivos);
        System.out.println("Números negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
        
        sc.close();
    }
}
