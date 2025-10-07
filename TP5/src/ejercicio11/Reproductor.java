/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio11;

/**
 *
 * @author Mauro
 */
public class Reproductor {
    
    // Dependencia de uso: el objeto Cancion se recibe como parámetro, pero no se guarda como atributo
    public void reproducir(Cancion cancion) {
        System.out.println("Reproduciiendo: " + cancion.getTitulo() + 
                " - " + cancion.getArtista().getNombre());
    }
}
