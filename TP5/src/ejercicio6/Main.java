/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Clarita Luz", "98051321");
        Mesa mesa = new Mesa(19, 4);
        Reserva reserva = new Reserva(LocalDate.of(2025, 11, 21), LocalTime.of(21, 0), cliente, mesa);

        System.out.println(reserva);
        System.out.println("Cliente de la reserva: " + reserva.getCliente());
        System.out.println("Mesa reservada: " + reserva.getMesa());
    }
}
