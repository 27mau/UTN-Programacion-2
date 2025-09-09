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
public class ejercicio9 {
    // Calcula costo de envío según zona y peso
    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")){
            return peso * 5.0;
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return peso * 10.0;
        } else {            
            return 0;
        }
    }
    
    // Este método se encarga de sumar el precio del prodcuto + el costo del envío
    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }
    
    // El main usa las dos funciones y muestra resultados formateados
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedimos los datos al usuario
        System.err.print("Ingrese el precio del producto: ");
        double precioProducto = sc.nextDouble();
        
        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = sc.nextDouble();
        
        sc.nextLine();  // consumir el salto de línea pendiente
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = sc.nextLine().trim();
        
        // Calculamos costo de envío usando la función
        double costoEnvio = calcularCostoEnvio(peso, zona);
        
        // Si la zona es inválida, se da aviso
        if (!(zona.equalsIgnoreCase("Nacional") || zona.equalsIgnoreCase("Internacional"))) {                
            System.out.println("Zona inválida. Se asumirá costo = 0.0");
        }
        
        // Calculamos total usando la función que compone ambas partes
        double total = calcularTotalCompra(precioProducto, costoEnvio);
        
        // Salida formateada con 2 decimales
        System.out.printf("El costo de envío es: %.2f%n", costoEnvio);
        System.out.printf("El total a pagar es: %.2f%n", total);
        
        sc.close();
    }
    
}
