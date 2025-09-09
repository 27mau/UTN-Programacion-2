/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author Mauro
 */
public class ejercicio13 {
    
    public static void main(String[] args) {
        // Declarar e inicializar array con precios
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        
        // Mostrar los valores originales
        System.out.println("Precios originales: ");
        mostrarArrayRecursivo(precios, 0);
        
        // Modificar el precio de un producto específico
        precios[2] = 129.99;
        
        // Mostrar los valores modificados
        System.out.println("Precios modificados: ");
        mostrarArrayRecursivo(precios, 0);
    }
    
    // Versión recursiva
    public static void mostrarArrayRecursivo(double[] arr, int i) {
        if(i < arr.length) {
            System.out.println("Precio: $" + arr[i]);
            mostrarArrayRecursivo(arr, i + 1); // llamada recursiva al siguiente elemnto
        }
    }
}
