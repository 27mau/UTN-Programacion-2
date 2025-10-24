/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8;

/**
 *
 * @author Mauro
 */
public class TarjetaCredito implements Pago, PagoConDescuento {
    private String titular;
    private String numero;

    public TarjetaCredito(String titular, String numero) {
        this.titular = titular;
        this.numero = numero;
    }

    @Override
    public boolean procesarPago(double monto) throws Exception {
        // Simulación: si número termina en 0, falla
        if (numero.endsWith("0")) {
            throw new Exception("Pago rechazado por el banco.");
        }
        System.out.println("Pago con tarjeta aprobado: $" + monto);
        return true;
    }

    @Override
    public double aplicarDescuento(double monto, double porcentaje) {
        return monto * (1 - porcentaje / 100.0);
    }
}
