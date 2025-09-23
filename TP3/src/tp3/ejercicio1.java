/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3;
import java.util.Scanner;

/**
 *
 * @author Mauro
 */
public class ejercicio1 {
    
    // Atributos privados
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;
    
    public ejercicio1(String nombre, String apellido, String curso,double calificacion) {
    
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso=curso;
        this.calificacion = calificacion;
        
    }
    
    // Método para mostrar la infomcación del estudiante
    public void mostrarInfo() {
        
        System.out.println("** Información del Estudiante **");
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Curso: " + curso);
        System.out.println("Calificación: " + calificacion);
        System.out.println("--------------");
    }
    
    // Método para subir calificación
    public void subirCalificacion(double puntos) {
        this.calificacion += puntos;
        System.out.println("Calificación aumentada en " + puntos + " puntos.");
    }
    
    // Método para ahar calificación 
    public void bajarCalificacion(double puntos) {
        this.calificacion -= puntos;
        if (this.calificacion < 0) {
            this.calificacion = 0; // Evita calificación negativa
        }
        System.out.println("Calificación disminuida en " + puntos + " puntos.");
    } 
 
    
}
