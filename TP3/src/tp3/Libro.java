/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author Mauro
 */
public class Libro {
    
    // Atributos privados, que se accederán a ellos mediante getters y setters.
    private String titulo;
    private String autor;
    private int anioPublicacion;
    
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        setAnioPublicacion(anioPublicacion); // usamos el setter para validar
    }
    
    // Getters para todos los atributos (accesi de lectura)
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    
    // Setter con validación para el año de publicación (acceso de escritura seguro)
    public void setAnioPublicacion(int anioPublicacion) {
        // En este ejemplo, el año válido debe ser entre 1900 y el año actual.
        if (anioPublicacion > 1900 && anioPublicacion <= 2025) {
            this.anioPublicacion = anioPublicacion;
        } else {
            System.out.println("Año de publicación inválido: " + anioPublicacion);
        }
    }
    
    // Método para mostrar la información
    public void mostrarInfo() {
        System.out.println("*** Información del Libro ***");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + anioPublicacion);
        System.out.println("==============");
    }
    
}
