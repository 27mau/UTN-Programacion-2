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
public class main_mascota {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos de la mascota
        System.out.print("Ingrese el nombre de la mascota: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la especie de la mascota: ");
        String especie = sc.nextLine();

        System.out.print("Ingrese la edad de la mascota: ");
        int edad = sc.nextInt();

        // Crear objeto Mascota
        Mascota m1 = new Mascota(nombre, especie, edad);

        // Mostrar información inicial
        m1.mostrarInfo();

        // Simular el paso del tiempo
        System.out.print("¿Cuántos años desea simular? ");
        int anios = sc.nextInt();

        for (int i = 0; i < anios; i++) {
            m1.cumplirAnios(); // La mascota cumple años
        }

        // Mostrar información final
        m1.mostrarInfo();

        sc.close();
    }
}
