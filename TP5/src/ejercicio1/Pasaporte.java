/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5;
import java.time.LocalDate;


/**
 *
 * @author Mauro
 */

   

public class Pasaporte {
    
    private String numero;
    private LocalDate fechaEmision;
    private Foto foto;
    private Titular titular;
    
    public Pasaporte(String numero, LocalDate fechaEmision, String imagen, String formato) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        // Composición: la foto se crea dentro del pasaporte
        this.foto = new Foto(imagen, formato);
    }
    
    public void setTitular(Titular titular) {
        this.titular = titular;
        titular.setPasaporte(this); // Bidireccional
    }
    
    public Titular getTitular() {
        return titular;
    }
    
    public Foto getFoto() {
        return foto;
    }
    
    @Override
    public String toString() {
        return "Pasaporte [numero=" + numero + ", fechaEmision=" + fechaEmision + ", " + foto + "]";
    }
}

