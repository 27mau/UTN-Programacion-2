/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear baería
        Bateria b1 = new Bateria("Nokia 6", 3500);
         
        // Crear celular con batería
        Celular c1 = new Celular("24548452", "Nokia", "N6", b1);
        
        // Crear usuario
        Usuario u1 = new Usuario("Mauro Gomez", "11555455");
        
        // Relación bidireccional
        c1.setUsuario(u1);
        
        // Mostrar resultados
        System.out.println(c1);
        System.out.println("Usuario del celular: " + c1.getUsuario());
        System.err.println("Celular del usuario: " + u1.getCelular());
    }
}
