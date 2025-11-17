/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mauro
 */

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tienda?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String pass = "killer0mu";

        // DriverManager: es la clase que administra los drivers JDBC y permite obtener una conexión con getConnection()
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("✅ Conexión exitosa a MySQL!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
