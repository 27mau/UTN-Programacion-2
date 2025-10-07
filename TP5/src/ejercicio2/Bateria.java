/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author Mauro
 */
public class Bateria {
    private String modelo;
    private int capacidad; 
    
    public Bateria(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    @Override
    public String toString() {
        return "Bateria [modelo=" + modelo + ", capacidad=" + capacidad + "mAh]";
    }
}
