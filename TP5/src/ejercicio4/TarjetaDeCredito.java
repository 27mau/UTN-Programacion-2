/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;
import java.time.LocalDate;

/**
 *
 * @author Mauro
 */
public class TarjetaDeCredito {
    
    private String numero;
    private LocalDate fechaVencimiento;
    private Cliente cliente;    // Asociación bidireccional
    private Banco banco;    // Agregación
    
    public TarjetaDeCredito(String numero, LocalDate fechaVencimiento, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.banco = banco;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        cliente.setTarjeta(this); // Mantiene la bidereccionalidad
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public Banco getBanco() {
        return banco;
    }
    
    @Override
    public String toString() {
        return "TarjetaDeCredito [numero=" + numero + ", fechaVencimiento=" + fechaVencimiento + ", " + banco + "]";
    }
    
}
