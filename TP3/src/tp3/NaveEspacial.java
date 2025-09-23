/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3;

/**
 *
 * @author Mauro
 */
public class NaveEspacial {
    
    private String nombre;
    private double combustible;
    private final double COMBUSTIBLE_MAXIMO = 100.0;

    // Constructor para inicializar la nave
    public NaveEspacial(String nombre, double combustibleInicial) {
        this.nombre = nombre;
        // Se valida el combustible inicial para que no exceda el máximo
        if (combustibleInicial > COMBUSTIBLE_MAXIMO) {
            this.combustible = COMBUSTIBLE_MAXIMO;
            System.out.println("Atención! El combustible inicial excede el límite. Se ajustó a " + COMBUSTIBLE_MAXIMO + ".");
        } else {
            this.combustible = combustibleInicial;
        }
    }
    
    public double getCombustible() {
    return combustible;
    }

    // Método para simular el despegue
    public void despegar() {
        double consumoDespegue = 10.0;
        if (this.combustible >= consumoDespegue) {
            this.combustible -= consumoDespegue;
            System.out.println(this.nombre + " ha despegado. Combustible restante: " + this.combustible);
        } else {
            System.out.println("Error: No hay suficiente combustible para despegar.");
        }
    }

    // Método para avanzar, consume 1 unidad de combustible por unidad de distancia
    public void avanzar(double distancia) {
        double consumoNecesario = distancia;
        if (this.combustible >= consumoNecesario) {
            this.combustible -= consumoNecesario;
            System.out.println(this.nombre + " avanza " + distancia + " unidades. Combustible restante: " + this.combustible);
        } else {
            System.out.println("Error: Combustible insuficiente para avanzar " + distancia + " unidades.");
        }
    }

    // Método para recargar combustible
    public void recargarCombustible(double cantidad) {
        double nuevoCombustible = this.combustible + cantidad;
        if (nuevoCombustible <= COMBUSTIBLE_MAXIMO) {
            this.combustible = nuevoCombustible;
            System.out.println("Se recargaron " + cantidad + " unidades. Combustible actual: " + this.combustible);
        } else {
            double recargadoParcial = COMBUSTIBLE_MAXIMO - this.combustible;
            this.combustible = COMBUSTIBLE_MAXIMO;
            System.out.println("Solo se recargaron " + recargadoParcial + " unidades. El tanque está lleno.");
        }
    }

    // Método para mostrar el estado actual
    public void mostrarEstado() {
        System.out.println("\n*** Estado de la Nave " + this.nombre + " ***");
        System.out.println("Combustible: " + this.combustible + " / " + this.COMBUSTIBLE_MAXIMO);
        System.out.println("================");
    }

}
