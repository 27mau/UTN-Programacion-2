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
public class CitaMedica {
    
    private LocalDate fecha;
    private String hora;
    private Paciente paciente;      // Asociación unidireccional
    private Profesional profesional; // Asociación unidireccional

    public CitaMedica(LocalDate fecha, String hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    @Override
    public String toString() {
        return "CitaMédica [fecha = " + fecha + ", hora = " + hora + ", paciente = " + paciente + ", profesional = " + profesional + "]";
    }
}
