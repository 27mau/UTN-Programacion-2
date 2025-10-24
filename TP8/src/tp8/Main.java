/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp8;

/**
 *
 * @author Mauro
 */
public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Luz Montero", "luz.clarita@email.com");

        Producto p1 = new Producto("Camiseta", 1500);
        Producto p2 = new Producto("Sombrero", 800);
        Producto p3 = new Producto("Pantalones", 2000);

        Pedido pedido = new Pedido(cliente);
        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);
        pedido.agregarProducto(p3);

        System.out.println("Pedido inicial: " + pedido);

        // Cambiar estado y observar notificación
        pedido.setEstado(EstadoPedido.EN_PREPARACION);

        // Procesar pago con descuento usando TarjetaCredito
        TarjetaCredito tarjeta = new TarjetaCredito("Luz Montero", "2111982702");
        try {
            double total = pedido.calcularTotal();
            double totalConDesc = tarjeta.aplicarDescuento(total, 15); // 10% off
            if (tarjeta.procesarPago(totalConDesc)) {
                pedido.setEstado(EstadoPedido.PAGADO);
            }
        } catch (Exception ex) {
            System.out.println("Error al procesar pago: " + ex.getMessage());
        }

        // Simular envío
        pedido.setEstado(EstadoPedido.ENVIADO);
        pedido.setEstado(EstadoPedido.ENTREGADO);

        System.out.println("Pedido final: " + pedido);
    }
}

