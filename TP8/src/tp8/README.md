# Trabajo Práctico: Interfaces y Excepciones en Java

## 📘 Introducción
Este trabajo práctico tiene como objetivo aplicar **Programación Orientada a Objetos (POO)** en Java mediante la **implementación de interfaces** y el **manejo de excepciones**.  

El ejercicio se divide en dos partes:
1. **Interfaces y Polimorfismo**: modelar un sistema de pedidos con productos, clientes, métodos de pago y notificaciones.
2. **Excepciones**: practicar el manejo de errores mediante `try-catch`, `throw`, `throws`, excepciones personalizadas y `try-with-resources`.

---

## 🧩 Parte 1 – Interfaces

### Consignas
1. **Interface `Pagable`**: define el método `calcularTotal()`.
2. **Clase `Producto`**: implementa `Pagable`, retorna su precio.
3. **Clase `Pedido`**: implementa `Pagable`, contiene una lista de productos, cliente y estado.  
   - Al cambiar de estado, debe **notificar al cliente**.
4. **Enum `EstadoPedido`**: define los estados posibles (`CREADO`, `PAGADO`, `EN_PREPARACION`, `ENVIADO`, `ENTREGADO`, `CANCELADO`).
5. **Interface `Pago`**: define `procesarPago(double monto) throws Exception`.
6. **Interface `PagoConDescuento`**: define `aplicarDescuento(double monto, double porcentaje)`.
7. **Clase `TarjetaCredito`**: implementa `Pago` y `PagoConDescuento`.
8. **Clase `PayPal`**: implementa `Pago`.
9. **Interface `Notificable`**: define `void notificar(String mensaje)`.
10. **Clase `Cliente`**: implementa `Notificable` e imprime notificaciones por consola.
11. **Clase `MainEcommerce`**: crea productos, pedidos, simula pagos, descuentos y cambios de estado.

---

## ⚠️ Parte 2 – Excepciones

### Consignas
1. **División segura**  
   - Captura `ArithmeticException` al dividir por cero.
2. **Conversión segura de String a int**  
   - Captura `NumberFormatException` al ingresar texto no numérico.
3. **Lectura de archivo**  
   - Captura `FileNotFoundException` y `IOException`.
4. **Excepción personalizada (`EdadInvalidaException`)**  
   - Lanza error si la edad es menor a 0 o mayor a 120.
5. **Uso de `try-with-resources`**  
   - Aplica en la lectura de archivo para cerrar recursos automáticamente.

Todas las pruebas están implementadas en la clase `EjerciciosExcepciones.java`.

---

## 🛠️ Herramientas utilizadas
- **Lenguaje:** Java 17  
- **IDE recomendado:** Visual Studio Code / IntelliJ IDEA / Eclipse  

---

## 📂 Estructura del repositorio
El repositorio contiene los archivos `.java` correspondientes a cada ejercicio práctico, organizados de manera que puedan ejecutarse individualmente en cualquier IDE de Java.

---

