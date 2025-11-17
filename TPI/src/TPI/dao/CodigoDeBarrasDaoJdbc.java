/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.dao;

import TPI.entities.CodigoDeBarras;
import TPI.entities.TipoCodigo;
import TPI.config.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Mauro
 */

/**
 * DAO JDBC para la tabla codigo_barras.
 * Implementa operaciones CRUD básicas + baja lógica.
 */

public class CodigoDeBarrasDaoJdbc implements GenericDao<CodigoDeBarras> {

    // 1. CREAR

    public CodigoDeBarras crear(CodigoDeBarras c, Connection externalConn) throws Exception {
        boolean closeConn = false;
        Connection conn = externalConn;

        if (conn == null) {
            conn = DatabaseConnection.getConnection();
            closeConn = true;
        }

        String sql = "INSERT INTO codigo_barras (eliminado, tipo, valor, fecha_asignacion, observaciones) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setBoolean(1, c.isEliminado());
            ps.setString(2, c.getTipo().name());
            ps.setString(3, c.getValor());

            if (c.getFechaAsignacion() != null)
                ps.setDate(4, Date.valueOf(c.getFechaAsignacion()));
            else
                ps.setNull(4, Types.DATE);

            ps.setString(5, c.getObservaciones());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    c.setId(rs.getLong(1));
                }
            }

            return c;

        } finally {
            if (closeConn && conn != null) conn.close();
        }
    }

    @Override
    public CodigoDeBarras crear(CodigoDeBarras c) throws Exception {
        return crear(c, null);
    }

    // 2. LEER POR ID

    @Override
    public CodigoDeBarras leer(long id) throws Exception {
        String sql = """
                SELECT *
                FROM codigo_barras
                WHERE id = ? AND eliminado = FALSE
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapCodigo(rs);
                }
            }
        }

        return null;
    }

    // 3. LEER TODOS

    @Override
    public List<CodigoDeBarras> leerTodos() throws Exception {
        List<CodigoDeBarras> lista = new ArrayList<>();

        String sql = "SELECT * FROM codigo_barras WHERE eliminado = FALSE";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapCodigo(rs));
            }
        }

        return lista;
    }

    // 4. ACTUALIZAR

    @Override
    public boolean actualizar(CodigoDeBarras c) throws Exception {
        String sql = """
                UPDATE codigo_barras
                SET tipo = ?, valor = ?, fecha_asignacion = ?, observaciones = ?
                WHERE id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getTipo().name());
            ps.setString(2, c.getValor());

            if (c.getFechaAsignacion() != null)
                ps.setDate(3, Date.valueOf(c.getFechaAsignacion()));
            else
                ps.setNull(3, Types.DATE);

            ps.setString(4, c.getObservaciones());
            ps.setLong(5, c.getId());

            return ps.executeUpdate() > 0;
        }
    }

    // 5. ELIMINAR (BAJA LÓGICA)

    @Override
    public boolean eliminar(long id) throws Exception {
        String sql = "UPDATE codigo_barras SET eliminado = TRUE WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // MÉTODO AUXILIAR DE MAPEADO

    private CodigoDeBarras mapCodigo(ResultSet rs) throws SQLException {
        CodigoDeBarras c = new CodigoDeBarras();

        c.setId(rs.getLong("id"));
        c.setEliminado(rs.getBoolean("eliminado"));
        c.setTipo(TipoCodigo.valueOf(rs.getString("tipo")));
        c.setValor(rs.getString("valor"));

        Date f = rs.getDate("fecha_asignacion");
        c.setFechaAsignacion(f != null ? f.toLocalDate() : null);

        c.setObservaciones(rs.getString("observaciones"));
        return c;
    }
}
