/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mauro
 */
public class Biblioteca {
    
    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }
    
    // 1. Agregar libro
    public void agregarLibro(Libro libro) {
        if (buscarPorISBN(libro.getIsbn()) != null) {
            System.out.println("️Alerta!! Ya existe un libro con el mismo ISBN.");
            return;
        }
        libros.add(libro);
    }
    
    // 2. Listar todos los libros
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros cargados.");
        } else {
            System.out.println("Listado de libros:");
            for (Libro l : libros) l.mostrarInfo();
        }
    }
    
    // 3. Buscar libro por ISBN
    public Libro buscarPorISBN(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                return l;
            }
        }
        return null;
    }
    
    // 4. Eliminar libro por ISBN
    public boolean eliminarLibro(String isbn) {
        Libro l = buscarPorISBN(isbn);
        if (l != null) {
            libros.remove(l);
            return true;
        }
        return false;
    }
    
    // 5. Filtrar por año
    public List<Libro> filtrarPorAnio(int anio) {
        return libros.stream()
                .filter(l -> l.getAnioPublicacion() == anio)
                .collect(Collectors.toList());
    }
    
   // 6. Contar total de libros
    public int contarLibros() {
        return libros.size();
    }

    // 7. Filtrar libros por autor
    public List<Libro> filtrarPorAutor(Autor autor) {
        return libros.stream()
            .filter(l -> l.getAutor().equals(autor))
            .collect(Collectors.toList());
}
    
   // 7. Listar autores de los libros disponibles
    public void listarAutoresDisponibles() {
        List<String> autores = libros.stream()
                .filter(Libro::isDisponible)
                .map(l -> l.getAutor().toString())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Autores con libros disponibles:");
        for (String a : autores) {
            System.out.println("- " + a);
        }
    }
}
