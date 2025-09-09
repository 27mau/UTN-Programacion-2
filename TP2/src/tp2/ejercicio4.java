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
public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Ingresar precio
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        
        // Pedir la categoría
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        String categoria = sc.next().toUpperCase(); // Convertimos a mayúscula
        
        // Determinnar el descuento
        double descuento = 0; // porcentaje
        boolean categoriaValida = true;
        
        if (categoria.equals("A")) {
            descuento = 10;
        } else if (categoria.equals("B")) {
            descuento = 15;
        } else if (categoria.equals("C")) {
            descuento = 20;
        } else {
            categoriaValida = false;
        }
        
        // Calcular precio final y mostrar resultados.
        if (categoriaValida) {          
            double montoDescuento = precio * (descuento / 100);
            double precioFinal = precio - montoDescuento;
            
            System.out.println("Precio ingresado: " + precio);
            System.out.println("Descuento aplicado: " + descuento + "%");
            System.out.println("Monto de descuento: " + montoDescuento);
            System.out.println("Precio final: " + precioFinal);
            
        } else {
            System.out.println("Categoría inváida. Debe ser A, B o C.");
        }
        

        sc.close();
    }
}
