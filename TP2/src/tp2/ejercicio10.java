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
public class ejercicio10 {
    
    // Método recibe tres entero que actualiza el stock
    public static int actualizarStock( int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Solicitamos datos al usuario
        System.out.print("Ingrese el stock actual del producto: ");
        int stockActual = sc.nextInt();
        
        System.out.print("Ingrese la cantidad vendida: ");
        int cantidadVendida = sc.nextInt();
        
        System.out.print("Ingrese la cantidad recibida: ");
        int cantidadRecibida = sc.nextInt();
        
        // Llamamos al método para calcular el nuevo stock
        int nuevoStock = actualizarStock(stockActual, cantidadVendida, cantidadRecibida);
        
        // Mostrar resultados
        System.out.println("El nuevo stock del producto es: " + nuevoStock);
        
        
        sc.close();
    }
}
