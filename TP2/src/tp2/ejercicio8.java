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
public class ejercicio8 {
    
    // Método que calcula el precio final, recibe 3 parámetros
    public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        // Devuelve el resultado como double
        double precioFinal = precioBase + (precioBase * impuesto) - (precioBase * descuento);
        return precioFinal;
    }
    
    // Pedimos los datos al usuario y convertir en porcentaje decimales para pasarlos al método
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // Usamos Scanner para pedir los datos
        
        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = scan.nextDouble();
        
        System.out.print("Ingrese el impuesto del porcentaje (Ejemplo: 10 para 10%): ");
        double impuestoPorcentaje = scan.nextDouble();
        
        System.out.print("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        double descuentoPorcentaje = scan.nextDouble();
        
        // Convertimos los porcentajes a decimales
        double impuesto = impuestoPorcentaje / 100;
        double descuento = descuentoPorcentaje / 100;
        
        // Llammamos al método, pasando los valores convertidos
        double precioFinal = calcularPrecioFinal(precioBase, impuesto, descuento);
        
        // Imprimimos el resultado final
        System.out.println("El precio final del producto es: " + precioFinal);
    }
}
