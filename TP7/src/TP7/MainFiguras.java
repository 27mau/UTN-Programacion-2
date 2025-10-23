/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7;

/**
 *
 * @author Mauro
 */
abstract class Figura {
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularArea();

    public void mostrarInfo() {
        // La implementación de calcularArea() se resolverá en tiempo de ejecución (polimorfismo)
        System.out.println("Figura: " + nombre + " | Área: " + calcularArea());
    }
}

class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    private double base, altura;

    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}

public class MainFiguras {
    
    public static void main(String[] args) {
        Figura[] figuras = {
            new Circulo(10),
            new Rectangulo(8, 14)
        };

        for (Figura f : figuras) {
            f.mostrarInfo(); // Polimorfismo: llama al método correcto según el objeto
        }
    }
}
