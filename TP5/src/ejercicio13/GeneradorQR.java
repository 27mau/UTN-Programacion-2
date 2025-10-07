/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio13;

/**
 *
 * @author Mauro
 */
public class GeneradorQR {
    
    // Dependencia de creación: crea un objeto de otra clase, pero no lo guarda como atributo.
    public void generar(String valor, Usuario usuario) {
        CodigoQR qr = new CodigoQR(valor, usuario);
        System.out.println("Generando código QR...");
        System.out.println(qr);
    }
}
