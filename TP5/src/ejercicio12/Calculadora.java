/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio12;

/**
 *
 * @author Mauro
 */
public class Calculadora {
    
    // Dependencia de uso: usa Impuesto como parámetro pero no lo guarda
    public void calcular(Impuesto impuesto) {
        double monto = impuesto.getMonto();
        double total = monto + (monto * 0.21); // Ejemplo: aplica 21% de IVA
        
        System.out.println("Calculando impuesto para: " + impuesto.getContribuyente().getNombre());
        System.out.println("Monto base: $" + monto);
        System.out.println("Monot total con IVA: $" + total);
    }
}
