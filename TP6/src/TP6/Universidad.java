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
public class Universidad {
    
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    // Agregar profesor
    public void agregarProfesor(Profesor profesor) {
        if (!profesores.contains(profesor)) {
            profesores.add(profesor);
        }
    }
    
    // Agregar curso
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }
    
    // Asignar profesor a curso
    public void asignarProfesorACurso(String codigoCurso, Profesor profesor) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigoCurso)) {
                Profesor anterior = c.getProfesor();
                if (anterior != null) {
                    anterior.removerCurso(c); // quita del anterior
                }
                c.setProfesor(profesor);
                profesor.agregarCurso(c);
                System.out.println("Profesor " + profesor.getNombre() + " asignado a " + c.getNombre());
                return;
            }
        }
        System.out.println("Alerta!!️ Curso no encontrado: " + codigoCurso);
    }
    
    // Remover curso y sincronizar
    public void removerCurso(String codigoCurso) {
        Curso cursoAEliminar = null;
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigoCurso)) {
                cursoAEliminar = c;
                break;
            }
        }
        if (cursoAEliminar != null) {
            Profesor prof = cursoAEliminar.getProfesor();
            if (prof != null) {
                prof.removerCurso(cursoAEliminar);
            }
            cursos.remove(cursoAEliminar);
            System.out.println("x Curso eliminado: " + codigoCurso);
        } else {
            System.out.println("x No se encontró el curso: " + codigoCurso);
        }
    }
    
    // Remover profesor (dejar sus cursos sin profesor)
    public void removerProfesor(String codigoProfesor) {
        Profesor profesorAEliminar = null;
        for (Profesor p : profesores) {
            if (p.getCodigo().equalsIgnoreCase(codigoProfesor)) {
                profesorAEliminar = p;
                break;
            }
        }
        if (profesorAEliminar != null) {
            for (Curso c : profesorAEliminar.getCursos()) {
                c.setProfesor(null);
            }
            profesores.remove(profesorAEliminar);
            System.out.println(" Profesor eliminado: " + codigoProfesor);
        } else {
            System.out.println("Alerta!!️ Profesor no encontrado: " + codigoProfesor);
        }
    }
    
    // Listar cursos con su profesor
    public void listarCursos() {
        
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
    }

    // Listar profesores con sus cursos
    public void listarProfesores() {
        
        for (Profesor p : profesores) {
            p.mostrarInfo();
        }
    }

    // Reporte: cantidad de cursos por profesor
    public void reporteCursosPorProfesor() {
        
        for (Profesor p : profesores) {
            System.out.println(p.getNombre() + ": " + p.getCursos().size() + " curso(s)");
        }
    }
}
