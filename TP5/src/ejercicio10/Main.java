/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10;
import java.time.LocalDate;

/**
 *
 * @author Mauro
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear clave de seguridad
        ClaveSeguridad clave = new ClaveSeguridad(2127, LocalDate.now());

        // Crear cuenta bancaria (con composición hacia clave)
        CuentaBancaria cuenta = new CuentaBancaria("725-002330", 95000.0, clave);

        // Crear titular
        Titular titular = new Titular("Mayra Diaz", 45000208);

        // Asociar titular y cuenta (bidireccional)
        cuenta.setTitular(titular);

        // Mostrar resultados
        System.out.println(cuenta);
        System.out.println("Titular de la cuenta: " + cuenta.getTitular());
        System.out.println("Cuenta del titular: " + titular.getCuenta());
    }
}
