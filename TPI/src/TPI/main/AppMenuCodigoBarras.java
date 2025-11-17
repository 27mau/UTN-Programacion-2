/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.main;

import TPI.entities.CodigoDeBarras;
import TPI.entities.TipoCodigo;
import TPI.service.CodigoDeBarrasService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Mauro
 */


public class AppMenuCodigoBarras {

    private final CodigoDeBarrasService codigoService = new CodigoDeBarrasService();
    private final Scanner scanner;

    public AppMenuCodigoBarras(Scanner scanner) {
        this.scanner = scanner;
    }

    // MÉTODO PRINCIPAL DEL MENÚ

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n====== MENÚ CÓDIGO DE BARRAS ======");
            System.out.println("1. Crear Código de Barras");
            System.out.println("2. Listar Códigos");
            System.out.println("3. Buscar Código por ID");
            System.out.println("4. Actualizar Código");
            System.out.println("5. Eliminar Código (baja lógica)");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> crearCodigo();
                case 2 -> listarCodigos();
                case 3 -> buscarCodigoPorId();
                case 4 -> actualizarCodigo();
                case 5 -> eliminarCodigo();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    // 1. Crear Código

    private void crearCodigo() {
        try {
            System.out.println("\n--- Crear Código de Barras ---");

            TipoCodigo tipo = leerTipoCodigo();
            System.out.print("Valor: ");
            String valor = scanner.nextLine().trim();

            System.out.print("Fecha asignación (YYYY-MM-DD o vacío): ");
            String fechaStr = scanner.nextLine().trim();
            LocalDate fecha = fechaStr.isEmpty() ? null : LocalDate.parse(fechaStr);

            System.out.print("Observaciones (opcional): ");
            String obs = scanner.nextLine().trim();

            CodigoDeBarras c = new CodigoDeBarras();
            c.setTipo(tipo);
            c.setValor(valor);
            c.setFechaAsignacion(fecha);
            c.setObservaciones(obs);

            CodigoDeBarras creado = codigoService.crearCodigo(c);

            System.out.println("Código creado con éxito. ID generado: " + creado.getId());

        } catch (Exception e) {
            System.out.println("Error al crear código: " + e.getMessage());
        }
    }

    // 2. Listar códigos

    private void listarCodigos() {
        try {
            System.out.println("\n--- Listado de Códigos de Barras ---");

            List<CodigoDeBarras> lista = codigoService.listarCodigos();

            if (lista.isEmpty()) {
                System.out.println("No hay códigos registrados.");
                return;
            }

            for (CodigoDeBarras c : lista) {
                System.out.println(c);
            }

        } catch (Exception e) {
            System.out.println("Error al listar códigos: " + e.getMessage());
        }
    }

    // 3. Buscar por ID

    private void buscarCodigoPorId() {
        try {
            System.out.print("\nIngrese ID del código: ");
            long id = leerLong();

            CodigoDeBarras c = codigoService.obtenerCodigo(id);
            System.out.println("\nCódigo encontrado:");
            System.out.println(c);

        } catch (Exception e) {
            System.out.println("Error al obtener código: " + e.getMessage());
        }
    }

    // 4. Actualizar

    private void actualizarCodigo() {
        try {
            System.out.print("\nIngrese ID del código a actualizar: ");
            long id = leerLong();

            CodigoDeBarras existente = codigoService.obtenerCodigo(id);
            System.out.println("Código actual: " + existente);

            TipoCodigo tipoNuevo = leerTipoCodigo();

            System.out.print("Nuevo valor: ");
            String valor = scanner.nextLine().trim();

            System.out.print("Nueva fecha (YYYY-MM-DD o vacío): ");
            String fechaStr = scanner.nextLine().trim();
            LocalDate fecha = fechaStr.isEmpty() ? null : LocalDate.parse(fechaStr);

            System.out.print("Nuevas observaciones: ");
            String obs = scanner.nextLine().trim();

            existente.setTipo(tipoNuevo);
            existente.setValor(valor);
            existente.setFechaAsignacion(fecha);
            existente.setObservaciones(obs);

            boolean ok = codigoService.actualizarCodigo(existente);

            System.out.println(ok ? "Código actualizado correctamente." : "No se pudo actualizar.");

        } catch (Exception e) {
            System.out.println("Error al actualizar código: " + e.getMessage());
        }
    }

    // ===========================================================
    // 5. Eliminar (baja lógica)
    // ===========================================================

    private void eliminarCodigo() {
        try {
            System.out.print("\nIngrese ID para eliminar: ");
            long id = leerLong();

            boolean ok = codigoService.eliminarCodigo(id);

            System.out.println(ok ? "Código eliminado correctamente (baja lógica)." : "No se pudo eliminar.");

        } catch (Exception e) {
            System.out.println("Error al eliminar código: " + e.getMessage());
        }
    }

    // ===========================================================
    // MÉTODOS AUXILIARES
    // ===========================================================

    private TipoCodigo leerTipoCodigo() {
        while (true) {
            System.out.print("Tipo (EAN8, EAN13, UPC): ");
            String tipoStr = scanner.nextLine().trim().toUpperCase();

            try {
                return TipoCodigo.valueOf(tipoStr);
            } catch (Exception e) {
                System.out.println("Tipo inválido. Intente nuevamente.");
            }
        }
    }

    private int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private long leerLong() {
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("Debe ingresar un número válido.");
        }
    }
}
