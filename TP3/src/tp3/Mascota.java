/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author Mauro
 */
public class Mascota {
    
    // Atributos privados
    private String nombre;
    private String especie;
    private int edad;

    // Constructor recibe los valores cuando se crea un objeto
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    
    // Método para mostrar la información de la mascota
    public void mostrarInfo() {
        System.out.println("*** Información de la Mascota ***");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
        System.out.println("===========");
    }

    // Método para cumplir años, aumenta la edad en 1
    public void cumplirAnios() {
        this.edad++;
        System.out.println(nombre + " ha cumplido un año más 🎉");
    }
}

