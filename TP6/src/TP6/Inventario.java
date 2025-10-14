/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mauro
 */
public class Inventario {
    
    private ArrayList<Producto> productos;

    // Se usa ArrayList<Producto> para manipular una colección dinámica (agregar, eliminar, iterar)
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // 1. agregarProducto
    public void agregarProducto(Producto p) {
        // evitar ids duplicados (opcional)
        if (buscarProductoPorId(p.getId()) != null) {
            System.out.println("Ya existe un producto con ID " + p.getId() + ". No se agregó.");
            return;
        }
        productos.add(p);
    }

    // 2. listarProductos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("Inventario vacío.");
            return;
        }
        System.out.println("Listado de productos:");
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    // 3. buscarProductoPorId
    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    // 4. eliminarProducto
    public boolean eliminarProducto(String id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }

    // 5. actualizarStock
    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    // 6. filtrarPorCategoria
    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    // 7. obtenerTotalStock
    public int obtenerTotalStock() {
        int total = 0;
        for (Producto p : productos) total += p.getCantidad();
        return total;
    }

    // 8. obtenerProductoConMayorStock
    public Producto obtenerProductoConMayorStock() {
        return productos.stream()
                .max(Comparator.comparingInt(Producto::getCantidad))
                .orElse(null);
    }

    // 9. filtrarProductosPorPrecio
    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        return productos.stream()
                .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
                .collect(Collectors.toList());
    }

    // 10. mostrarCategoriasDisponibles
    public void mostrarCategoriasDisponibles() {
        System.out.println("Categorías disponibles:");
        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.printf("- %s : %s%n", c, c.getDescripcion());
        }
    }
}
