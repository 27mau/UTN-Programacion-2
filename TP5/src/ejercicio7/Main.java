/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear motor
        Motor motor = new Motor("Diesel", "BB3Q-6006-FA");

        // Crear vehículo con motor (agregación)
        Vehiculo vehiculo = new Vehiculo("CC666CC", "Ford Ranger", motor);

        // Crear conductor
        Conductor conductor = new Conductor("Esteban Quito", "LIC-212706");

        // Asociar vehículo ↔ conductor
        vehiculo.setConductor(conductor);

        // Mostrar resultados
        System.out.println(vehiculo);
        System.out.println("Conductor del vehículo: " + vehiculo.getConductor());
        System.out.println("Vehículo del conductor: " + conductor.getVehiculo());
    }
}
