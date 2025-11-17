/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {

    private static String url;
    private static String user;
    private static String password;

    // Bloque estático: La configuración se carga SOLO UNA VEZ
    static {
        
        // Busca el archivo application.properties dentro del classpath.
        try (InputStream is = DatabaseConnection.class.getClassLoader()
             .getResourceAsStream("application.properties")) {

            if (is == null) {
                // Si el archivo no se encuentra, lanzamos un error claro
                throw new IllegalStateException("El archivo 'application.properties' no se encontró en el classpath.");
            }

            Properties props = new Properties();
            props.load(is);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");
            
            // Opcional: Cargar el driver explícitamente si se necesita para Java 8 o anterior
            // Class.forName("com.mysql.cj.jdbc.Driver"); 
            
        } catch (Exception e) {
            // Manejo de errores claro si la carga inicial falla
            System.err.println("Error FATAL al inicializar la configuración de la base de datos.");
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Devuelve una nueva conexión a la base de datos.
     * @throws SQLException si falla la conexión.
     */
    public static Connection getConnection() throws SQLException {
        // Usa las variables estáticas ya cargadas
        return DriverManager.getConnection(url, user, password);
    }
}
