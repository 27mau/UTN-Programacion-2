/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class SistemaBibliotecaMain {
    
    public static void main(String[] args) {
        // 1. Creamos una biblioteca.
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("--- INICIO DEL SISTEMA DE BIBLIOTECA ---");

        // 2. Crear al menos tres autores
        Autor autor1 = new Autor("J. D. Perón", "Argentino");
        Autor autor2 = new Autor("J.R.R. Tolkien", "Británico");
        Autor autor3 = new Autor("Philip K. Dick", "Estadounidense");
        Autor autor4 = new Autor("Nicolás Márquez", "Argentino");
        Autor autor5 = new Autor("Agustín Laje", "Argentino");
        Autor autor6 = new Autor("Salvador Borrego", "Mexicano");
        
        // 3. Agregar 5 libros asociados a alguno de los Autores
        System.out.println("\n--- 3. AGREGANDO LIBROS ---");
        biblioteca.agregarLibro(new Libro("935-1", "La hora de los pueblos", autor1, 1968, "Ensayo", true));
        biblioteca.agregarLibro(new Libro("935-2", "El Hobbit", autor2, 1937, "Fantasía", true));
        biblioteca.agregarLibro(new Libro("935-3", "1984", new Autor("George Orwell", "Británico"), 1949, "Distopía", true));
        biblioteca.agregarLibro(new Libro("935-4", "¿Es de Izquierda? ¡La Cultura!", autor4, 2024, "Política", true));
        biblioteca.agregarLibro(new Libro("935-5", "Generación de Cristal", autor5, 2022, "Ensayo", true));
        biblioteca.agregarLibro(new Libro("935-6", "Derrota Mundial", autor6, 1953, "Historia", false));
        biblioteca.agregarLibro(new Libro("935-7", "Blade Runner", autor3, 1968, "Ciencia Ficción", true));
        biblioteca.agregarLibro(new Libro("935-8", "Ubik", autor3, 1969, "Ciencia Ficción", true));
        biblioteca.agregarLibro(new Libro("935-9", "El Señor de los Anillos: La Comunidad", autor2, 1954, "Fantasía", true));

        // 4. Listar todos los libros con su información y la del autor
        System.out.println("\n--- 4. LISTAR LIBROS ---");
        biblioteca.listarLibros();
        
        // 5. Buscar un libro por su ISBN y mostrar su información
        System.out.println("\n--- 5. BUSCAR LIBRO POR ISBN (935-7) ---");
        Libro buscado = biblioteca.buscarPorISBN("935-7");
        if (buscado != null) buscado.mostrarInfo();
        else System.out.println("No se encontró el libro.");
        
        // 6. Filtrar y mostrar los libros publicados en un año específico
        System.out.println("\n--- 6. FILTRAR LIBROS PUBLICADOS EN 1968 ---");
        List<Libro> publicados1968 = biblioteca.filtrarPorAnio(1968);
        if (publicados1968.isEmpty())
            System.out.println("No hay libros publicados en ese año.");
        else
            publicados1968.forEach(Libro::mostrarInfo);
        
        // 7. Eliminar un libro por su ISBN y listar los libros restantes
        System.out.println("\n--- 7. ELIMINAR LIBRO (935-4) ---");
        boolean eliminado = biblioteca.eliminarLibro("935-4");
        System.out.println(eliminado ? "Libro eliminado." : "No se encontró el libro.");
        biblioteca.listarLibros();
        
        // 8. Mostrar la cantidad total de libros en la biblioteca
        System.out.println("\n--- 8. CANTIDAD TOTAL DE LIBROS ---");
        System.out.println("Total de libros en biblioteca: " + biblioteca.contarLibros());

        // 9. Listar todos los autores de los libros disponibles
        System.out.println("\n--- 9. AUTORES DE LIBROS DISPONIBLES ---");
        biblioteca.listarAutoresDisponibles();
        
         System.out.println("\n--- FIN DEL PROGRAMA ---");
    }
}
