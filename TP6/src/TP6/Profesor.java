/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class Profesor {
    
    private String codigo;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;

    public Profesor(String codigo, String nombre, String especialidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public List<Curso> getCursos() { return cursos; }
    
    // Agrega curso al profesor (si no está ya asignado)
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            curso.setProfesor(this); // sincroniza el lado del curso
        }
    }
    
    // Remueve un curso del profesor
    public void removerCurso(Curso curso) {
        cursos.remove(curso);
    }

    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre + " (" + codigo + ") - Especialidad: " + especialidad);
        if (cursos.isEmpty()) {
            System.out.println("  Sin cursos asignados.");
        } else {
            System.out.println("  Cursos asignados:");
            for (Curso c : cursos) {
                System.out.println("   → " + c.getNombre());
            }
        }
    }

    @Override
    public String toString() {
        return nombre + " - " + especialidad;
    }

}
