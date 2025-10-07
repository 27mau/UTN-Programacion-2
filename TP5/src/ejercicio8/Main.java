/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;
import java.time.LocalDate;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear usuario
        Usuario usuario = new Usuario("Vanina Araceli", "ara.vanina@email.com");

        // Crear firma digital (agregación con usuario)
        FirmaDigital firma = new FirmaDigital("FFF6V6V6", LocalDate.now(), usuario);

        // Crear documento con firma (composición)
        Documento doc = new Documento("Contrato", "Contenido del contrato...", firma);

        // Mostrar información
        System.out.println(doc);
        System.out.println("Usuario que firmó: \n" + doc.getFirma().getUsuario());
    }
}
