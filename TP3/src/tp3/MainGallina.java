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
public class MainGallina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Crear primera gallina
        System.out.print("Ingrese el ID de la primera gallina: ");
        int id1 = sc.nextInt();
        System.out.print("Ingrese la edad inicial de la primera gallina: ");
        int edad1 = sc.nextInt();
        Gallina g1 = new Gallina(id1, edad1);

        // Crear segunda gallina
        System.out.print("Ingrese el ID de la segunda gallina: ");
        int id2 = sc.nextInt();
        System.out.print("Ingrese la edad inicial de la segunda gallina: ");
        int edad2 = sc.nextInt();
        Gallina g2 = new Gallina(id2, edad2);

        // Acciones para la primera gallina
        System.out.print("¿Cuántos huevos pondrá la gallina " + id1 + "? ");
        int huevos1 = sc.nextInt();
        g1.ponerHuevo(huevos1);

        System.out.print("¿Cuántos años envejeció la gallina " + id1 + "? ");
        int anios1 = sc.nextInt();
        g1.envejecer(anios1);

        // Acciones para la segunda gallina
        System.out.print("¿Cuántos huevos pondrá la gallina " + id2 + "? ");
        int huevos2 = sc.nextInt();
        g2.ponerHuevo(huevos2);

        System.out.print("¿Cuántos años envejeció la gallina " + id2 + "? ");
        int anios2 = sc.nextInt();
        g2.envejecer(anios2);

        // Mostrar estado final
        g1.mostrarEstado();
        g2.mostrarEstado();

        sc.close();
    }
}
