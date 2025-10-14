/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class SIstemaStockMain {
    
    public static void main(String[] args) {
        
        // Ejecuta las tareas solicitadas en orden y muestra resultados por consola.
        Inventario inventario = new Inventario();

        // 1. Crear al menos cinco productos con diferentes categorías y agregarlos al inventario.
        Producto p1 = new Producto("P001", "Arroz Integral 1kg", 850.0, 50, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("P002", "Smartwatch Pro S9", 35000.0, 15, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("P003", "Pantalón Jean", 7800.0, 30, CategoriaProducto.ROPA);
        Producto p4 = new Producto("P004", "Licuadora", 4150.0, 12, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("P005", "Fideos Secos 500g", 620.0, 90, CategoriaProducto.ALIMENTOS);
        Producto p6 = new Producto("P006", "Auriculares Inalámbricos", 1500.0, 45, CategoriaProducto.ELECTRONICA);
        Producto p7 = new Producto("P007", "Camisa Formal Blanca", 9200.0, 20, CategoriaProducto.ROPA);
        Producto p8 = new Producto("P008", "Atril de Lectura", 2100.0, 8, CategoriaProducto.LIBROS);
        Producto p9 = new Producto("P009", "Set de Bloques Armables", 2990.0, 60, CategoriaProducto.JUGUETES);
        Producto p10 = new Producto("P010", "Toallas de Baño Algodón", 1850.0, 40, CategoriaProducto.HOGAR);
        
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        inventario.agregarProducto(p6);
        inventario.agregarProducto(p7);
        inventario.agregarProducto(p8);
        inventario.agregarProducto(p9);
        inventario.agregarProducto(p10);
        
        // 2. Listar todos los productos mostrando su información y categoría.
        System.out.println("\n-- 2. Listar productos --");
        inventario.listarProductos();
        
        // 3. Buscar un producto por ID y mostrar su información.
        System.out.println("\n-- 3. Buscar producto por ID 'P007' --");
        Producto buscado = inventario.buscarProductoPorId("P007");
        if (buscado != null) buscado.mostrarInfo();
        else System.out.println("Producto no encontrado.");
        
        // 4. Filtrar y mostrar productos que pertenezcan a una categoría específica.
        System.out.println("\n-- 4. Filtrar por categoria ELECTRONICA --");
        List<Producto> electronicos = inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
        electronicos.forEach(Producto::mostrarInfo);
        
        // 5. Eliminar un producto por su ID y listar los productos restantes.
        System.out.println("\n-- 5. Eliminar producto 'P004' (Licuadora) y listar resto --");
        boolean eliminado = inventario.eliminarProducto("P004");
        System.out.println("Eliminado P004? " + eliminado);
        inventario.listarProductos();
                
        // 6. Actualizar el stock de un producto existente.
        System.out.println("\n-- 6. Actualizar stock de 'P002' (Smartwatch Pro S9) a 25 unidades --");
        boolean actualizado = inventario.actualizarStock("P002", 25);
        System.out.println("Actualizado P002? " + actualizado);
        System.out.println("P002 ahora: " + inventario.buscarProductoPorId("P002"));

        // 7. Mostrar el total de stock disponible.
        System.out.println("\n-- 7. Total de stock disponible --");
        System.out.println("Total stock: " + inventario.obtenerTotalStock());

        // 8. Obtener y mostrar el producto con mayor stock.
        System.out.println("\n-- 8. Producto con mayor stock --");
        Producto mayor = inventario.obtenerProductoConMayorStock();
        if (mayor != null) mayor.mostrarInfo();
        
        // 9. Filtrar productos con precios entre $1000 y $3000.
        System.out.println("\n-- 9. Filtrar por precio entre $1000 y $3000 --");
        List<Producto> rango = inventario.filtrarProductosPorPrecio(1000, 3000);
        rango.forEach(Producto::mostrarInfo);
        
        // 10. Mostrar las categorías disponibles con sus descripciones.
        System.out.println("\n-- 10. Categorías disponibles --");
        inventario.mostrarCategoriasDisponibles();
    }    
}
