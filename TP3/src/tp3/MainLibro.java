/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;
import java.util.Scanner;

/**
 *
 * @author Mauro
 */
public class MainLibro {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedir datos del libro
        System.out.print("Ingrese el título del libro: ");
        String titulo = sc.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        String autor = sc.nextLine();

        System.out.print("Ingrese el año de publicación: ");
        int anio = sc.nextInt();
        
        // Crear objeto Libro con los datos ingresados
        Libro libro1 = new Libro(titulo, autor, anio);
        
        // Mostrar información inicial
        libro1.mostrarInfo();

        // Asignar un año inválido
        System.out.print("Ingrese un nuevo año de publicación (inválido para probar): ");
        int anioInvalido = sc.nextInt();
        libro1.setAnioPublicacion(anioInvalido);
        libro1.mostrarInfo();

        // Asignar un año válido
        System.out.print("Ingrese un nuevo año de publicación (válido): ");
        int anioValido = sc.nextInt();
        libro1.setAnioPublicacion(anioValido);
        libro1.mostrarInfo();
        
        sc.close();
    }
}
