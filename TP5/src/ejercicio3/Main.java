/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

/**
 *
 * @author Mauro
 */
public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor("Axel Kaiser", "Chileno");
        Editorial editorial = new Editorial("Ariel", "2024");
        
        Libro libro = new Libro("Parásitos Mentelas", "123-154-484-55", autor, editorial);
    
         System.out.println(libro);
    }
}
