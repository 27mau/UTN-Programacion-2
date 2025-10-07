/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio11;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        
        // Crear artista
        Artista artista = new Artista("The Killers", "Rock Inde");
        
        // Crear canción (asociación con artista)
        Cancion cancion = new Cancion("Mr. Brightside", artista);
        
        // Crear reproductor y usar dependencia de uso
        Reproductor reproductor = new Reproductor();
        reproductor.reproducir(cancion);
    }
}
