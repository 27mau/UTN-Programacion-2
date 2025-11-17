/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;
import java.sql.*;

/**
 *
 * @author Mauro
 */
public class producto {
    
    private static final String URL = "jdbc:mysql://localhost:3306/tienda";
    private static final String USER = "user_consulta";
    private static final String PASSWORD = "consulta";

    public void buscarPorCategoriaYPrecio(String categoria, double maxPrecio) {
        String sql = """
            SELECT p.id, p.nombre, p.categoria, p.precio, p.valor
            FROM v_productos_economicos p
             WHERE p.categoria = ? AND p.precio <= ?
            ORDER BY p.precio ASC
            LIMIT 10
        """;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Conectado: " + !conn.isClosed()); // Validar conexión

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "Alimentos");
                ps.setDouble(2, 120);

                ResultSet rs = ps.executeQuery();

                boolean found = false; // indicador de resultados

                while (rs.next()) {
                    found = true;
                    System.out.printf("%d - %s (%s): $%.2f - %s%n",
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getString("valor"));
                }

                if (!found) {
                    System.out.println("No se encontraron productos para esa categoría y precio.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error ejecutando consulta: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        producto dao = new producto();
        dao.buscarPorCategoriaYPrecio("Alimentos", 120);
    }
}
