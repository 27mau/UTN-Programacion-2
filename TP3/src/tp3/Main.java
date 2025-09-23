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
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Pedimos datos al ususario
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = sc.nextLine();
        
        System.out.print("Ingrese el curso: ");
        String curso = sc.nextLine();

        System.out.print("Ingrese la calificación inicial: ");
        double calificacion = sc.nextDouble();

        // Creamos un objeto Estudiante con los datos ingresados
        ejercicio1 est1 = new ejercicio1(nombre, apellido, curso, calificacion);

        // Mostramos la información inicial
        est1.mostrarInfo();

        // Subir calificación
        System.out.print("¿Cuántos puntos desea aumentar a la calificación? ");
        double subir = sc.nextDouble();
        est1.subirCalificacion(subir);
        est1.mostrarInfo();

        // Bajar calificación
        System.out.print("¿Cuántos puntos desea disminuir a la calificación? ");
        double bajar = sc.nextDouble();
        est1.bajarCalificacion(bajar);
        est1.mostrarInfo();

        sc.close(); // Cerramos el scanner
    }
}
