/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio12;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        
        // Crear Contribuyente
        Contribuyente contribuyente = new Contribuyente("Luz Montero", "20-98211198-3");
        
        // Crear impuesto (asociación unidireccional con contribuyente)
        Impuesto impuesto = new Impuesto(60000.0, contribuyente);
        
        // Crear calculadora (dependencia de uso)
        Calculadora calc = new Calculadora();
        calc.calcular(impuesto);
    }
}
