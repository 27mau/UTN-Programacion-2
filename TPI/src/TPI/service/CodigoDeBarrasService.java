/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.service;

import TPI.dao.CodigoDeBarrasDaoJdbc;
import TPI.entities.CodigoDeBarras;
import java.util.List;

/**
 *
 * @author Mauro
 */


public class CodigoDeBarrasService {

    private final CodigoDeBarrasDaoJdbc codigoDao = new CodigoDeBarrasDaoJdbc();

    // 1. Crear código

    public CodigoDeBarras crearCodigo(CodigoDeBarras c) throws Exception {
        validarCodigo(c);
        return codigoDao.crear(c);
    }

    // 2. Leer por ID

    public CodigoDeBarras obtenerCodigo(long id) throws Exception {
        // Me aseguro de que el ID sea válido.
        if (id <= 0)
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");

        CodigoDeBarras c = codigoDao.leer(id);

        // Si el DAO devuelve null, informo que no existe ese código.
        if (c == null)
            throw new IllegalArgumentException("No existe un código de barras con ese ID.");

        return c;
    }

    // 3. Listar todos

    public List<CodigoDeBarras> listarCodigos() throws Exception {
        return codigoDao.leerTodos();
    }

    // 4. Actualizar código

    public boolean actualizarCodigo(CodigoDeBarras c) throws Exception {
        // Verifica que tenga un ID válido.
        if (c.getId() == null || c.getId() <= 0)
            throw new IllegalArgumentException("ID inválido para actualización.");

        validarCodigo(c);

        return codigoDao.actualizar(c);
    }

    // 5. Eliminar (baja lógica)

    public boolean eliminarCodigo(long id) throws Exception {
        // Antes de eliminar se verifica que el ID sea mayor que cero.
        if (id <= 0)
            throw new IllegalArgumentException("ID inválido.");

        return codigoDao.eliminar(id);
    }

    // VALIDACIONES DE NEGOCIO

    private void validarCodigo(CodigoDeBarras c) {

        if (c == null)
            throw new IllegalArgumentException("El código de barras no puede ser nulo.");

        if (c.getTipo() == null)
            throw new IllegalArgumentException("El tipo es obligatorio (EAN8, EAN13 o UPC).");

        if (c.getValor() == null || c.getValor().isBlank())
            throw new IllegalArgumentException("El valor del código es obligatorio.");

        if (c.getValor().length() > 20)
            throw new IllegalArgumentException("El valor no puede superar los 20 caracteres.");

        // unicidad del valor -> lo valida MySQL + DAO
    }
}
