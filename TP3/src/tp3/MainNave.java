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
public class MainNave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*** Simulación de Nave Espacial ***");

        // Crear una nave con datos ingresados por el usuario
        System.out.print("Ingreso el nombre de la nave: ");
        String nombreNave = sc.nextLine();

        double combustibleInicial = 50.0;
        NaveEspacial miNave = new NaveEspacial(nombreNave, combustibleInicial);
        miNave.mostrarEstado();

        // Intentar avanzar sin recargar
        System.out.println("\n--- Intentar avanzar sin recargar ---");
        System.out.print("Ingresa la distancia a intentar avanzar (más de " + miNave.getCombustible() + " unidades): ");
        double distanciaIntentada = sc.nextDouble();
        miNave.avanzar(distanciaIntentada);
        miNave.mostrarEstado();

        System.out.print("Ingrese la distancia a avanzar después de la recarga: ");
        double distanciaFinal = sc.nextDouble();
        miNave.avanzar(distanciaFinal);

        // Mostrar el estado final
        miNave.mostrarEstado();

        sc.close();
    }

}