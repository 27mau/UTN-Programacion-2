/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamundo;
import java.util.Scanner;

/**
 *
 * @author Mauro
 */
public class ejercicio4 {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer desde la consola
        Scanner sc = new Scanner(System.in);

        // Ingresar el nombre
        System.out.print("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        // Ingresasr edad
        System.out.print("Ingresa tu edad: ");
        int edad = sc.nextInt();

        // Mostrar los datos
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    
        sc.close();
    }
}
