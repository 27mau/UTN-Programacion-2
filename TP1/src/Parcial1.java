/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mauro
 */
class Tarea {
    private String descripcion;
    public Tarea(String d) { this.descripcion = d; }
    public String getDescripcion() { return this.descripcion; }
}

abstract class Persona {
    private String nombre;
    public Persona(String n) { this.nombre = n; }
    public String getNombre() { return this.nombre; }
}

class Voluntario extends Persona {
    private List⟨Tarea⟩ tareas;
    public Voluntario(String n) {
        super(n);
        this.tareas = new ArrayList⟨⟩();
    }
    public void asignarTarea(Tarea t) {
        if(t != null){
            this.tareas.add(t);
        }
    }
    public List⟨Tarea⟩ getTareas() {
        return this.getListaTareas();
    }
}

public class Coordinador {
    public boolean verificarTareaAsignada(Voluntario v, String desc) {
        for (Tarea t : v.obtenerTareas()) {
            if (t.descripcion == desc) {
                return true;
            }
        }
        return false;
    }
}
