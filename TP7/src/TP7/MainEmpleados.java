/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularSueldo();

    public void mostrarTipo() {
        System.out.println("Empleado: " + nombre);
    }
}

class EmpleadoPlanta extends Empleado {
    private double salarioBase;
    private double bono;

    public EmpleadoPlanta(String nombre, double salarioBase, double bono) {
        super(nombre);
        this.salarioBase = salarioBase;
        this.bono = bono;
    }

    @Override
    public double calcularSueldo() {
        return salarioBase + bono;
    }
}

class EmpleadoTemporal extends Empleado {
    private int diasTrabajados;
    private double pagoPorDia;

    public EmpleadoTemporal(String nombre, int diasTrabajados, double pagoPorDia) {
        super(nombre);
        this.diasTrabajados = diasTrabajados;
        this.pagoPorDia = pagoPorDia;
    }

    @Override
    public double calcularSueldo() {
        return diasTrabajados * pagoPorDia;
    }
}

public class MainEmpleados {
    public static void main(String[] args) {
        
        // Se declara una lista genérica que solo puede contener referencias de tipo Empleado.
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        // Se produce el Upcasting implícito.
        empleados.add(new EmpleadoPlanta("Loana", 60000, 5000));
        // La lista almacena referencias de la superclase(Empleado), 
        // pero los objetos reales son los de la subclases
        empleados.add(new EmpleadoTemporal("Mauro", 25, 1800));

        for (Empleado e : empleados) {
            // Al llamar a e.calcularSueldo(), ocurre el Polimorfismo por Sobrescritura (Overriding)
            System.out.println("Empleado: " + e.nombre + " | Sueldo: " + e.calcularSueldo());

            // Se utiliza el operador instanceof para verificar la clase real del objeto al que apunta la referencia e.
            if (e instanceof EmpleadoPlanta) {
                System.out.println("→ Es empleado de planta");
            } else if (e instanceof EmpleadoTemporal) {
                System.out.println("→ Es empleado temporal");
            }
        }
    }
}
