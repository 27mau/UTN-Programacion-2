/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio13;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear usuario
        Usuario usuario = new Usuario("Ailin Ando", "ailin.a@email.com");

        // Crear generador y generar código QR (dependencia de creación)
        GeneradorQR generador = new GeneradorQR();
        generador.generar("70D4P4T1", usuario);
    }
}
