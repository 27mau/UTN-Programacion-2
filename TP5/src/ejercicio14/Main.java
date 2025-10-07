/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio14;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        Proyecto proyecto = new Proyecto("I, Pet Goat II", 450);
        EditorVideo editor = new EditorVideo();
        editor.exportar("MP4", proyecto);
    }
}
