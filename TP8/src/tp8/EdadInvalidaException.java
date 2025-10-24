/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8;

/**
 *
 * @author Mauro
 */
public class EdadInvalidaException extends Exception { // Extiende Exception para ser CHECKED
    public EdadInvalidaException(String message) {
        super(message);
    }
}

