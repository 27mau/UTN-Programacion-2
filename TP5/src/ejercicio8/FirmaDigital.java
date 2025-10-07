/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio8;
import java.time.LocalDate;

/**
 *
 * @author Mauro
 */
public class FirmaDigital {
    
    private String codigoHash;
    private LocalDate fecha;
    private Usuario usuario; // Agregación
    
    public FirmaDigital(String codigoHash, LocalDate fecha, Usuario ususario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = ususario;
    }
    
    public String getCodigoHash() {
        return codigoHash;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "FirmaDigital [codigoHash = " + codigoHash + ", fecha = " + fecha + ", usuario = " + usuario + "]";
    }
    
}
