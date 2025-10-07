/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Mauro
 */
public class Celular {
    
    private String imei;
    private String marca;
    private String modelo;
    private Bateria bateria;   // Agregación
    private Usuario usuario;   // Asociación bidireccional

    public Celular(String imei, String marca, String modelo, Bateria bateria) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria;
    }
    
    public void setUsuario(Usuario usuario) {
        if (this.usuario != usuario) {
            this.usuario = usuario;
            if (usuario != null && usuario.getCelular() != this) {
                // Aquí está la llamada. Debe coincidir la firma en Celular y Usuario.
                usuario.setCelular(this); 
            }
        }
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    @Override
    public String toString() {
        return "Celular [IMEI=" + imei + ", marca=" + marca + ", modelo=" + modelo + ", " + bateria + "]";
    }
}
