/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio9;
import java.time.LocalDate;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear paciente
        Paciente paciente = new Paciente("Flavio Gutierrez", "Medife");

        // Crear profesional
        Profesional profesional = new Profesional("Dra. Meli", "Cardiología");

        // Crear cita médica
        CitaMedica cita = new CitaMedica(LocalDate.of(2025, 11, 7), "10:30", paciente, profesional);

        // Mostrar datos
        System.out.println(cita);
        System.out.println("Paciente: " + cita.getPaciente().getNombre());
        System.out.println("Profesional: " + cita.getProfesional().getNombre());
    }
}
