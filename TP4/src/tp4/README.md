# 📘 Trabajo Práctico de Programación Orientada a Objetos (POO)

## Tema: Clase Empleado y Gestión de Salarios
Este proyecto implementa una clase `Empleado` en Java, aplicando los principios de Programación Orientada a Objetos (POO), y un programa de prueba `TestEmpleado` con interacción por consola para gestionar una lista de empleados.

---

## 📌 Consignas del TP
1. **Modelar una clase `Empleado`** con los atributos:
- `id`
- `nombre`
- `puesto`
- `salario`

2. **Usar `this` en los constructores** para diferenciar parámetros de atributos.

3. **Sobrecarga de constructores:**- Uno con todos los atributos.- Otro solo con `nombre` y `puesto`, asignando un `id` automático y un salario por defecto.

4. **Sobrecarga de métodos:**
- `actualizarSalario(double porcentaje)` → incrementa salario según un porcentaje.
- `actualizarSalario(int cantidad)` → incrementa salario por monto fijo.

5. **Método `toString()`** para mostrar un empleado de forma legible.

6. **Atributos estáticos:**- `totalEmpleados` que lleve la cuenta de cuántos empleados fueron creados.

7. **Encapsulamiento:**- Atributos privados.- Métodos `get` y `set` para cada atributo.

8. **Clase `TestEmpleado` con `main`:**
- Pedir al usuario cuántos empleados quiere cargar.
- Leer datos por consola (`Scanner`).
- Crear empleados usando los constructores disponibles.
- Mostrar la lista de empleados cargados.
- Preguntar si quiere actualizar salarios por **porcentaje** o **monto fijo**.
- Aplicar la actualización a **todos los empleados**.- Mostrar la lista después de la actualización.
- Imprimir la cantidad total de empleados creados.

---

## 📖 Conceptos trabajados
- Uso de **`this`** en constructores.
- **Sobrecarga de constructores** y de métodos.
- **Atributos estáticos** y contadores de instancias.
- **Encapsulamiento** con getters y setters.
- **toString()** para representación legible.- Entrada por teclado con **`Scanner`**.

---

## 📂 Estructura del repositorio
El repositorio contiene los archivos `.java` correspondientes a cada ejercicio práctico, organizados de manera que puedan ejecutarse individualmente en cualquier IDE de Java.