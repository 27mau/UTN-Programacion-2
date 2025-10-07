/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;
import java.time.LocalDate;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Cripto", "66-21279266-6");
        Cliente cliente = new Cliente("Eleazar Gass", "41610272");
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("6485-2127-9298-0513", LocalDate.of(2033, 6, 06), banco);
    
        // Vincular relaciones
        tarjeta.setCliente(cliente);
        
        // Mostrar resultados
        System.out.println(tarjeta);
        System.out.println("Cliente de la tarjeta: " + tarjeta.getCliente());
        System.out.println("Banco de la tarjeta: " + tarjeta.getBanco());
        System.out.println("Tarjeta del cliente: " + cliente.getTarjeta());
                
    }
}
