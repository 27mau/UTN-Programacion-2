/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author Mauro
 */
public class Gallina {
    // Atributos
    private int idGallina;
    private int edad;
    private int huevosPuestos;
    
    // COnstructor
    public Gallina(int idGallina, int edad) {
        this.idGallina = idGallina;
        this.edad = edad;
        this.huevosPuestos = 0;
    }
    
    // Método para poner un huevo
    public void ponerHuevo(int cantidad) {
        this.huevosPuestos += cantidad;
        System.out.println("La gallina " + idGallina + " puso " + cantidad + " huevo(s).");
    }
    
    // Método para envejecer
    public void envejecer(int anios) {
        this.edad += anios;
        System.out.println(" La gallina " + idGallina + " envejeció " + anios + " año(s). Ahora tiene " + edad + " años.");
    }

    // Método para mostrar el estado
    public void mostrarEstado() {
        System.out.println("*** Estado de la Gallina " + idGallina + " ***");
        System.out.println("Edad: " + edad + " años");
        System.out.println("Huevos puestos: " + huevosPuestos);
        System.out.println("===============");
    }
}
