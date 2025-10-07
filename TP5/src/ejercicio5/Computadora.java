/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5;

/**
 *
 * @author Mauro
 */
public class Computadora {
    private String marca;
    private String numeroSerie;
    private PlacaMadre placaMadre;   // Composición
    private Propietario propietario; // Asociación bidireccional

    public Computadora(String marca, String numeroSerie, String modeloPlaca, String chipset) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        // Composición: la placa madre se crea dentro de la computadora
        this.placaMadre = new PlacaMadre(modeloPlaca, chipset);
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
        propietario.setComputadora(this); // Mantiene la bidireccionalidad
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public PlacaMadre getPlacaMadre() {
        return placaMadre;
    }

    @Override
    public String toString() {
        return "Computadora [marca=" + marca + ", numeroSerie=" + numeroSerie + ", " + placaMadre + "]";
    }
}
