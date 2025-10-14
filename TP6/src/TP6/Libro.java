/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6;

/**
 *
 * @author Mauro
 */
public class Libro {
    
    private String isbn;
    private String titulo;
    private Autor autor;
    private int anioPublicacion;
    private String genero;
    private boolean disponible;
    
    public Libro(String isbn, String titulo, Autor autor, int anioPublicacion, String genero, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.disponible = disponible;
    }
    
    // Getters y Setters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public Autor getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public String getGenero() { return genero; }
    public boolean isDisponible() { return disponible; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    // Mostrar info completa
    public void mostrarInfo() {
        System.out.printf(
                "ISBN: %s | Título: %s | Autor: %s | Año: %d | Género: %s | Disponible: %s%n",
                isbn, titulo, autor.toString(), anioPublicacion, genero, disponible ? "Sí" : "No"
        );
    }

   @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d) - %s [%s]",
                isbn, titulo, autor.getNombre(), anioPublicacion, genero,
                disponible ? "Disponible" : "Prestado");
    }
}
