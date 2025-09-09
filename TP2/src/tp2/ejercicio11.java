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
public class ejercicio11 {
    // Variable global (de clase)
    static double DESCUENTO_ESPECIAL = 0.10;
    
    // Método que aplica el descuento especial
    public static void calcularDescuentoEspecial(double precio) {
        // Recibe el precio del producto como parámetro
        // Usa la variable global DESCUENTO_ESPECIAL
        // Declara una varuable local descuentoAPlicado
        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        
        // Caclula el precio final con descuento
        double precioFinal = precio - descuentoAplicado;
        
        // Muestra en patnalal el descuento aplicado y el precio final
        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedimos el precio al usuario
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        
        // Llammamos al método
        calcularDescuentoEspecial(precio);
        
        sc.close();
    }
}
