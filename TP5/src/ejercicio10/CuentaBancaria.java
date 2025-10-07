/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio10;

/**
 *
 * @author Mauro
 */
public class CuentaBancaria {
    
    private String cbu;
    private double saldo;
    private ClaveSeguridad clave;  // Composición
    private Titular titular;        // Asociación bidireccional

    public CuentaBancaria(String cbu, double saldo, ClaveSeguridad clave) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.clave = clave;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
        titular.setCuenta(this); // Mantener bidireccionalidad
    }

    public Titular getTitular() {
        return titular;
    }

    public ClaveSeguridad getClave() {
        return clave;
    }

    @Override
    public String toString() {
        return "CuentaBancaria [CBU = " + cbu + ", saldo = " + saldo + ", clave = " + clave + "]";
    }
}
