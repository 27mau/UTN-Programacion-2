/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author Mauro
 */
public class ejercicio12 {
    
    public static void main(String[] args) {
        // Declarar e inicializar array con precios
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        
        // Mostrar los valores originales
        System.out.println("Precios originales: ");
        mostrarArray(precios);
        
        // Modificar el precio de un producto específico
        precios[2] = 129.99;
        
        // Mostrar los valores modificados
        System.out.println("Precios modificados: ");
        mostrarArray(precios);
    }
    
    // Método para mostrar los precios (versión iterativa)
    public static void mostrarArray(double[] arr) {
        for (double precio : arr) {
            System.out.println("Precio: $" + precio);
        }
    }   
}
