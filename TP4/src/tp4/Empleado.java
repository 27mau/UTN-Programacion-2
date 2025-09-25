/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;

/**
 *
 * @author Mauro
 */
public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private double salario;


    // Atributos estáticos para control global
    private static int totalEmpleados = 0; // contador de instancias creadas
    private static int contadorId = 0;     // usado para generar ids automáticos

    // Constructor que recibe todos los atributos (uso de "this")
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id; // this para diferenciar atributo/parametro
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++; // incrementa contador global
        // Aseguramos que el contadorId avance si se pasó un id mayor
        if (id > contadorId) {
            contadorId = id;
        }
    }
    
    // Constructor sobrecargado: sólo nombre y puesto
    // Asigna id automático y salario por defecto
    public Empleado(String nombre, String puesto) {
        this.id = ++contadorId; // id automático (pre-incremento)
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 10000.0; // salario por defecto (ejemplo)
        totalEmpleados++;
    }
    
    // Getter y Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
        if (id > contadorId) contadorId = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPuesto() {
        return puesto;
    }
    
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        if (salario >= 0) this.salario = salario;
    }
   
    // Método actualizarSalario
    public void actualizarSalario(double porcentaje) {
        // Validación
        if (porcentaje <= -100.0) return;
        this.salario += this.salario * (porcentaje / 100.0);
    }
    
    // Se usa int para diferenciar la firma
    public void actualizarSalario(int cantidad) {
        this.salario += cantidad;
    }
    
    // 
    public void actualizarSalario(double cantidad, boolean esPorcentaje) {
        if (esPorcentaje) {
            actualizarSalario(cantidad); // llama a la versión porcentaje
        } else {
            this.salario += cantidad; // suma cantidad fija (double)
        }
    }    
    
    // toString
    @Override
    public String toString() {
        return String.format("Empleado {id=%d, nombre='%s', puesto='%s', salario=%.2f}",
                             id, nombre, puesto, salario);
    }
    
    // Método estático para mostrar total de empleados
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }
    
    
}
