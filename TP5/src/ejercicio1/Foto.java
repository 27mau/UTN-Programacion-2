/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5;

/**
 *
 * @author Mauro
 */


public class Foto {
    private String imagen; // Representaría la ruta o el contenido binario simplificado
    private String formato;

    // Constructor
    public Foto(String imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }

    // Getters
    public String getImagen() {
        return imagen;
    }

    public String getFormato() {
        return formato;
    }
    
    @Override
    public String toString() {
        return "Foto [imagen=" + imagen + ", formato=" + formato + "]";
    }
}