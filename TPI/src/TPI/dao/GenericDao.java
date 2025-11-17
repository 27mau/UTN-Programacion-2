/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.dao;
import java.util.List;
/**
 *
 * @author Mauro
 */
public interface GenericDao<T> {
      
    // Mediante el uso de tipos genéricos (<T>), la misma estructura es reutilizable para cualquier entidad del dominio, 
    // promoviendo una arquitectura consistente y evitando duplicación de código.
    // La interfaz incluye métodos para crear, leer por ID, listar registros, actualizar y realizar baja lógica.
    T crear(T t) throws Exception;
    T leer(long id) throws Exception;
    List<T> leerTodos() throws Exception;
    boolean actualizar(T t) throws Exception;
    boolean eliminar(long id) throws Exception;  // baja lógica
}
