/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio14;

/**
 *
 * @author Mauro
 */
public class EditorVideo {
    public void exportar(String formato, Proyecto proyecto) {
        
        // Dependencia de creación: se crea un Render dentro del método
        Render render = new Render(formato, proyecto);
        System.out.println("Exportando render...");
        System.out.println(render);
    }
}
