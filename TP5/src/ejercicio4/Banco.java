/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Mauro
 */
public class Banco {
    
    private String nombre, cuit;
    
    public Banco(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getCuit () {
        return cuit;
    }
    
    @Override
    public String toString() {
        return "Banco [nombre=" + nombre + ", cuit=" + cuit + "]";
    }
}
