/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7;

/**
 *
 * @author Mauro
 */
class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println("Sonido genérico...");
    }

    public void describirAnimal() {
        System.out.println("Soy un animal llamado " + nombre);
    }
}

class Perro extends Animal {
    public Perro(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() {
        System.out.println("Guau guau!");
    }
}

class Gato extends Animal {
    public Gato(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() {
        System.out.println("Miau miau!");
    }
}

class Vaca extends Animal {
    public Vaca(String nombre) { super(nombre); }

    @Override
    public void hacerSonido() {
        System.out.println("Muuu!");
    }
}

public class MainAnimales {
    
    public static void main(String[] args) {
        // El tipo del arreglo es Animal (la clase base o superclase) animales
        Animal[] animales = {
            new Perro("Samy"),
            new Gato("Laira"),
            new Vaca("Vanina")
        };

        // El programa itera sobre cada elemento () en el arreglo. 
        // Cada variable es tratada como un objeto de tipo en el código fuente.aanimalesaAnimal
        for (Animal a : animales) {
            a.describirAnimal();
            a.hacerSonido(); // Polimorfismo
        }
    }
}

