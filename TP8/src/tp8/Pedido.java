/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8;

/**
 *
 * @author Mauro
 */
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable {
    private List<Producto> productos;
    private Cliente cliente;
    private EstadoPedido estado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.estado = EstadoPedido.CREADO;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void quitarProducto(Producto p) {
        productos.remove(p);
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularTotal();
        }
        return total;
    }

    public void setEstado(EstadoPedido nuevoEstado) {
        EstadoPedido viejo = this.estado;
        this.estado = nuevoEstado;
        // Notificar solo si cambió
        if (viejo != nuevoEstado) {
            cliente.notificar("Estado del pedido cambiado de " + viejo + " a " + nuevoEstado +
                              ". Total: $" + calcularTotal());
        }
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", estado=" + estado +
                ", total=$" + calcularTotal() +
                ", productos=" + productos +
                '}';
    }
}

