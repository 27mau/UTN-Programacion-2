/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5;
import java.time.LocalDate;

/**
 *
 * @author Mauro
 */
public class MainPasaporte {
    
    public static void main(String[] args) {
        Titular t1 = new Titular ("Mauro Eleazar", "21245453");
        
        Pasaporte p1 = new Pasaporte("AR-2055", LocalDate.of(2025, 2, 2), "mau_foto.png", "PNG");
        
        p1.setTitular(t1);
        
        // Mostrar resultados
        System.out.println(p1);
        System.out.println("Titular del Pasaporte: " + p1.getTitular());
        System.out.println("Pasaporte del titular: " + t1.getPasaporte());
    }
}
