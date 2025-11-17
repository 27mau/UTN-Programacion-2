/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.main;

import TPI.service.ProductoService;
import TPI.entities.Producto;
import TPI.entities.CodigoDeBarras;
import TPI.entities.TipoCodigo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mauro
 */

public class AppMenuProducto {

    private final ProductoService productoService = new ProductoService();
    private final Scanner scanner;

    public AppMenuProducto(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n====== MENÚ PRODUCTOS ======");
            System.out.println("1. Crear Producto");
            System.out.println("2. Crear Producto con Código (Transacción)");
            System.out.println("3. Listar Productos");
            System.out.println("4. Buscar Producto por ID");
            System.out.println("5. Actualizar Producto");
            System.out.println("6. Eliminar Producto (baja lógica)");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> crearProductoConCodigo();
                case 3 -> listarProductos();
                case 4 -> buscarProductoPorId();
                case 5 -> actualizarProducto();
                case 6 -> eliminarProducto();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    // 1. Crear Producto (sin código)

    private void crearProducto() {
        try {
            System.out.println("\n--- Crear Producto ---");

            Producto p = leerDatosProductoBasico();

            Producto creado = productoService.crearProducto(p);
            System.out.println("Producto creado. ID: " + creado.getId());

        } catch (Exception e) {
            System.out.println("Error al crear producto: " + e.getMessage());
        }
    }

    // 2. Crear Producto con Código (usa transacción del DAO)

    private void crearProductoConCodigo() {
        try {
            System.out.println("\n--- Crear Producto con Código (Transacción) ---");

            // Datos del producto
            Producto p = leerDatosProductoBasico();

            // Datos del código
            System.out.println("\n--- Código de Barras ---");
            CodigoDeBarras c = new CodigoDeBarras();

            c.setTipo(leerTipoCodigo());

            System.out.print("Valor: ");
            c.setValor(scanner.nextLine().trim());

            System.out.print("Fecha asignación (YYYY-MM-DD o vacío): ");
            String fechaStr = scanner.nextLine().trim();
            c.setFechaAsignacion(fechaStr.isEmpty() ? null : LocalDate.parse(fechaStr));

            System.out.print("Observaciones (opcional): ");
            c.setObservaciones(scanner.nextLine().trim());

            // Aquí llamamos al método transaccional
            Producto creado = productoService.crearProductoConCodigo(p, c);

            System.out.println("Producto + Código creados correctamente.");
            System.out.println("Nuevo ID de producto: " + creado.getId());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 3. Listar Productos

    private void listarProductos() {
        try {
            System.out.println("\n--- Listado de Productos ---");

            List<Producto> lista = productoService.listarProductos();

            if (lista.isEmpty()) {
                System.out.println("No hay productos cargados.");
                return;
            }

            for (Producto p : lista) {
                System.out.println(p);
            }

        } catch (Exception e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }
    }

    // 4. Buscar por ID

    private void buscarProductoPorId() {
        try {
            System.out.print("\nIngrese ID del producto: ");
            long id = leerLong();

            Producto p = productoService.obtenerProducto(id);
            System.out.println("\nProducto encontrado:");
            System.out.println(p);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 5. Actualizar

    private void actualizarProducto() {
        try {
            System.out.print("\nIngrese ID del producto a actualizar: ");
            long id = leerLong();

            Producto existente = productoService.obtenerProducto(id);
            System.out.println("\nProducto actual:");
            System.out.println(existente);

            System.out.println("\n--- Nuevos datos ---");
            Producto actualizado = leerDatosProductoBasico();
            actualizado.setId(id);
            actualizado.setCodigoBarras(existente.getCodigoBarras());

            boolean ok = productoService.actualizarProducto(actualizado);
            System.out.println(ok ? "Producto actualizado." : "No se pudo actualizar.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 6. Eliminar

    private void eliminarProducto() {
        try {
            System.out.print("\nIngrese ID: ");
            long id = leerLong();

            boolean ok = productoService.eliminarProducto(id);

            System.out.println(ok ? "Producto eliminado (baja lógica)." : "No se pudo eliminar.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // MÉTODOS AUXILIARES DE LECTURA

    private Producto leerDatosProductoBasico() {
        Producto p = new Producto();

        System.out.print("Nombre: ");
        p.setNombre(scanner.nextLine().trim());

        System.out.print("Marca (opcional): ");
        p.setMarca(scanner.nextLine().trim());

        System.out.print("Categoria (opcional): ");
        p.setCategoria(scanner.nextLine().trim());

        System.out.print("Precio: ");
        p.setPrecio(new BigDecimal(scanner.nextLine().trim()));

        System.out.print("Peso (opcional): ");
        String pesoStr = scanner.nextLine().trim();
        p.setPeso(pesoStr.isEmpty() ? null : new BigDecimal(pesoStr));

        return p;
    }

    private TipoCodigo leerTipoCodigo() {
        while (true) {
            System.out.print("Tipo (EAN8, EAN13, UPC): ");
            String str = scanner.nextLine().trim().toUpperCase();

            try {
                return TipoCodigo.valueOf(str);
            } catch (Exception e) {
                System.out.println("Tipo inválido. Reintente.");
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

