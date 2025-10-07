/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear propietario
        Propietario propietario = new Propietario("Daren Guerrero", 39116609);

        // Crear computadora (compone su placa madre)
        Computadora compu = new Computadora("ASUS", "F16", "Core 5 210H", "H-610");

        // Asociar propietario ↔ computadora
        compu.setPropietario(propietario);

        // Mostrar resultados
        System.out.println(compu);
        System.out.println("Propietario de la computadora: " + compu.getPropietario());
        System.out.println("Computadora del propietario: " + propietario.getComputadora());
    }
}
