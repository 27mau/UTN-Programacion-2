/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.dao;

import TPI.config.DatabaseConnection;
import TPI.entities.Producto;
import TPI.entities.CodigoDeBarras;
import TPI.entities.TipoCodigo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Mauro
 */


public class ProductoDaoJdbc implements GenericDao<Producto> {

    private final CodigoDeBarrasDaoJdbc codigoDao = new CodigoDeBarrasDaoJdbc();

    // 1. MÉTODO TRANSACCIONAL -> CREA CODIGO + PRODUCTO

    public Producto crearProductoConCodigo(Producto producto, CodigoDeBarras codigo) throws Exception {
        Connection conn = null;

        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // INICIO TRANSACCIÓN

            // 1) Insertar código de barras
            CodigoDeBarras creadoCodigo = codigoDao.crear(codigo, conn);

            // 2) Asociarlo al producto
            producto.setCodigoBarras(creadoCodigo);

            // 3) Insertar producto
            Producto creadoProducto = this.crear(producto, conn);

            // (OPCIONAL) ERROR FORZADO PARA DEMOSTRAR ROLLBACK
            if ("ERROR".equalsIgnoreCase(producto.getNombre())) {
                throw new RuntimeException("Error simulado para demostrar rollback.");
            }

            // 4) Confirmar transacción
            conn.commit();
            return creadoProducto;

        } catch (Exception e) {
            if (conn != null) conn.rollback(); // REVERTIR TODO
            throw e;

        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    // 2. CREAR PRODUCTO (SOPORTA `Connection` EXTERNA)

    public Producto crear(Producto p, Connection externalConn) throws Exception {
        boolean closeConn = false;
        Connection conn = externalConn;

        if (conn == null) {
            conn = DatabaseConnection.getConnection();
            closeConn = true;
        }

        String sql = "INSERT INTO producto (eliminado, nombre, marca, categoria, precio, peso, codigo_barras_id) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setBoolean(1, p.isEliminado());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getMarca());
            ps.setString(4, p.getCategoria());
            ps.setBigDecimal(5, p.getPrecio());

            if (p.getPeso() != null)
                ps.setBigDecimal(6, p.getPeso());
            else
                ps.setNull(6, Types.DECIMAL);

            if (p.getCodigoBarras() != null && p.getCodigoBarras().getId() != null)
                ps.setLong(7, p.getCodigoBarras().getId());
            else
                ps.setNull(7, Types.BIGINT);

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getLong(1));
                }
            }

            return p;

        } finally {
            if (closeConn) conn.close();
        }
    }

    @Override
    public Producto crear(Producto p) throws Exception {
        return crear(p, null);
    }

    // 3. LEER POR ID

    @Override
    public Producto leer(long id) throws Exception {
        String sql = """
                SELECT 
                    p.*, 
                    c.id AS c_id, c.tipo, c.valor, c.fecha_asignacion, c.observaciones, c.eliminado AS c_eliminado
                FROM producto p
                LEFT JOIN codigo_barras c ON p.codigo_barras_id = c.id
                WHERE p.id = ? AND p.eliminado = FALSE
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto p = mapProducto(rs);
                    CodigoDeBarras c = mapCodigo(rs);
                    p.setCodigoBarras(c);
                    return p;
                }
            }
        }
        return null;
    }

    // 4. LEER TODOS

    @Override
    public List<Producto> leerTodos() throws Exception {
        List<Producto> lista = new ArrayList<>();

        String sql = """
                SELECT 
                    p.*, 
                    c.id AS c_id, c.tipo, c.valor, c.fecha_asignacion, c.observaciones, c.eliminado AS c_eliminado
                FROM producto p
                LEFT JOIN codigo_barras c ON p.codigo_barras_id = c.id
                WHERE p.eliminado = FALSE
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = mapProducto(rs);
                p.setCodigoBarras(mapCodigo(rs));
                lista.add(p);
            }
        }

        return lista;
    }

    // 5. ACTUALIZAR

    @Override
    public boolean actualizar(Producto p) throws Exception {
        String sql = "UPDATE producto SET nombre=?, marca=?, categoria=?, precio=?, peso=?, codigo_barras_id=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getMarca());
            ps.setString(3, p.getCategoria());
            ps.setBigDecimal(4, p.getPrecio());

            if (p.getPeso() != null)
                ps.setBigDecimal(5, p.getPeso());
            else
                ps.setNull(5, Types.DECIMAL);

            if (p.getCodigoBarras() != null && p.getCodigoBarras().getId() != null)
                ps.setLong(6, p.getCodigoBarras().getId());
            else
                ps.setNull(6, Types.BIGINT);

            ps.setLong(7, p.getId());

            return ps.executeUpdate() > 0;
        }
    }

    // 6. ELIMINAR (BAJA LÓGICA)

    @Override
    public boolean eliminar(long id) throws Exception {
        String sql = "UPDATE producto SET eliminado = TRUE WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // MÉTODOS AUXILIARES DE MAPEADO

    private Producto mapProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setEliminado(rs.getBoolean("eliminado"));
        p.setNombre(rs.getString("nombre"));
        p.setMarca(rs.getString("marca"));
        p.setCategoria(rs.getString("categoria"));
        p.setPrecio(rs.getBigDecimal("precio"));
        p.setPeso(rs.getBigDecimal("peso"));
        return p;
    }

    private CodigoDeBarras mapCodigo(ResultSet rs) throws SQLException {
        Long id = rs.getLong("c_id");

        if (rs.wasNull()) return null;

        CodigoDeBarras c = new CodigoDeBarras();
        c.setId(id);
        c.setEliminado(rs.getBoolean("c_eliminado"));
        c.setTipo(TipoCodigo.valueOf(rs.getString("tipo")));
        c.setValor(rs.getString("valor"));

        Date f = rs.getDate("fecha_asignacion");
        c.setFechaAsignacion(f != null ? f.toLocalDate() : null);

        c.setObservaciones(rs.getString("observaciones"));
        return c;
    }
}
