/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6;

/**
 *
 * @author Mauro
 */
public class Curso {
    
    private String codigo;
    private String nombre;
    private int duracionHoras;
    private Profesor profesor;

    public Curso(String codigo, String nombre, Profesor profesor, int duracionHoras) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
        this.duracionHoras = duracionHoras;

        // Si el curso tiene profesor al crearse, lo agregamos a su lista
        if (profesor != null) {
            profesor.agregarCurso(this);
        }
    }
    
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getDuracionHoras() { return duracionHoras; }
    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void mostrarInfo() {
        System.out.printf("Curso: %-30s | Código: %s | Duración: %dh | Profesor: %s%n",
                nombre, codigo, duracionHoras,
                (profesor != null ? profesor.getNombre() : "Sin asignar"));
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %dh", nombre, codigo, duracionHoras);
    }

}
