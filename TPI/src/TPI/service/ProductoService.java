/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.service;

import TPI.dao.ProductoDaoJdbc;
import TPI.entities.Producto;
import TPI.entities.CodigoDeBarras;

import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author Mauro
 */

public class ProductoService {

    private final ProductoDaoJdbc productoDao = new ProductoDaoJdbc();

    // 1. Crear producto SIN código

    public Producto crearProducto(Producto p) throws Exception {
        // Primero aplica validaciones. Luego delega la inserción al DAO.
        validarProducto(p);
        return productoDao.crear(p);
    }

    // 2. Crear Producto + Código de Barras (transacción en el DAO)

    public Producto crearProductoConCodigo(Producto p, CodigoDeBarras c) throws Exception {
        validarProducto(p);
        validarCodigo(c);
        return productoDao.crearProductoConCodigo(p, c);
    }

    // 3. Leer por ID

    public Producto obtenerProducto(long id) throws Exception {
        // Valida que el ID sea mmayor a cero
        if (id <= 0)
            throw new IllegalArgumentException("El ID debe ser mayor a cero.");
        // Pide al DAO que lo busque
        Producto p = productoDao.leer(id);

        if (p == null)
            throw new IllegalArgumentException("No existe un producto con ese ID.");

        return p;
    }

    // 4. Leer todos

    public List<Producto> listarProductos() throws Exception {
        return productoDao.leerTodos();
    }

    // 5. Actualizar

    public boolean actualizarProducto(Producto p) throws Exception {
        // Verifica que tenga un ID válido
        if (p.getId() == null || p.getId() <= 0)
            throw new IllegalArgumentException("ID inválido.");
        // Valida todos los campos de producto.
        validarProducto(p);

        return productoDao.actualizar(p);
    }

    // 6. Eliminar (baja lógica)

    public boolean eliminarProducto(long id) throws Exception {
        if (id <= 0)
            throw new IllegalArgumentException("ID inválido.");

        return productoDao.eliminar(id);
    }

    // VALIDACIONES DE NEGOCIO

    private void validarProducto(Producto p) {
        if (p == null)
            throw new IllegalArgumentException("El producto no puede ser nulo.");

        if (p.getNombre() == null || p.getNombre().isBlank())
            throw new IllegalArgumentException("El nombre del producto es obligatorio.");

        if (p.getPrecio() == null || p.getPrecio().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("El precio no puede ser negativo.");

        if (p.getPeso() != null && p.getPeso().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("El peso no puede ser negativo.");
    }

    private void validarCodigo(CodigoDeBarras c) {

        if (c == null)
            throw new IllegalArgumentException("El código de barras no puede ser nulo.");

        if (c.getTipo() == null)
            throw new IllegalArgumentException("El tipo de código de barras es obligatorio.");

        if (c.getValor() == null || c.getValor().isBlank())
            throw new IllegalArgumentException("El valor del código de barras es obligatorio.");

        // La unicidad del valor se valida en la base, y el DAO
        // devolverá una excepción si se intenta duplicarlo.
    }
}

