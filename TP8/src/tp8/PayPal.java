/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8;

/**
 *
 * @author Mauro
 */
public class PayPal implements Pago {
    private String cuenta;

    public PayPal(String cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public boolean procesarPago(double monto) throws Exception {
        // Simulación simple
        if (cuenta == null || cuenta.isEmpty()) {
            throw new Exception("Cuenta PayPal inválida.");
        }
        System.out.println("Pago con PayPal aprobado: $" + monto);
        return true;
    }
}

