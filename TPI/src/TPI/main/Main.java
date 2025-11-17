/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.main;

import java.util.Scanner;
/**
 *
 * @author Mauro
 */


/**
 * Clase principal de la aplicación.
 * Presenta el menú general para acceder a los distintos módulos.
 */

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Crear menús con el mismo scanner
        AppMenuProducto menuProducto = new AppMenuProducto(scanner);
        AppMenuCodigoBarras menuCodigo = new AppMenuCodigoBarras(scanner);

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE TIENDA =====");
            System.out.println("1) Gestión de Productos");
            System.out.println("2) Gestión de Códigos de Barras");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> menuProducto.mostrarMenu();
                case 2 -> menuCodigo.mostrarMenu();
                case 0 -> System.out.println("👋 Saliendo del sistema. ¡Hasta luego!");
                default -> System.out.println("⚠ Opción inválida, intente nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}

