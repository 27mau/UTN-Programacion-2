/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10;
import java.time.LocalDate;

/**
 *
 * @author Mauro
 */
public class ClaveSeguridad {
    
    private int codigo;
    private LocalDate ultimaModificacion;

    public ClaveSeguridad(int codigo, LocalDate ultimaModificacion) {
        this.codigo = codigo;
        this.ultimaModificacion = ultimaModificacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getUltimaModificacion() {
        return ultimaModificacion;
    }

    @Override
    public String toString() {
        return "ClaveSeguridad [codigo = " + codigo + ", ultimaModificacion = " + ultimaModificacion + "]";
    }
}
