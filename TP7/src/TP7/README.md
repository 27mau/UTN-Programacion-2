# 🧩 Trabajo Práctico: Herencia y Polimorfismo en Java

## 🎯 Objetivo General
Comprender y aplicar los conceptos de **herencia** y **polimorfismo** en la Programación Orientada a Objetos, reconociendo su importancia para:
- La **reutilización de código**.
- La **creación de jerarquías de clases**.
- El **diseño flexible y escalable** de programas en Java.

---

## 🧠 Temas trabajados

### 🔹 Herencia
- Uso de `extends` para crear jerarquías entre clases.
- Aplicación del principio **“es un” (is-a)**.
- Reutilización de atributos y métodos de la superclase.

### 🔹 Modificadores de acceso
- Control de visibilidad con `private`, `protected` y `public`.

### 🔹 Constructores y `super`
- Invocación al constructor de la superclase mediante `super(...)`.
- Inicialización correcta de atributos heredados.

### 🔹 Polimorfismo
- Capacidad de que un mismo método tenga diferentes comportamientos según el objeto.
- **Llamadas dinámicas** a métodos sobrescritos en tiempo de ejecución.

### 🔹 Sobrescritura de métodos (`@Override`)
- Redefinición de métodos heredados para personalizar el comportamiento.
- Uso del decorador `@Override` para evitar errores de compilación y mejorar la legibilidad.

### 🔹 Clases y métodos abstractos
- Definición de estructuras base que deben ser implementadas por las subclases.
- Aplicación del modificador `abstract` para métodos sin cuerpo.

### 🔹 Upcasting, Downcasting e `instanceof`
- **Upcasting:** conversión automática de una subclase a su superclase.
- **Downcasting:** conversión manual de una superclase a su tipo específico.
- Uso de `instanceof` para verificar el tipo real del objeto antes de convertirlo.

---

## 💻 Ejercicios desarrollados

### 🧩 1. Vehículos y Herencia Básica
- Se implementó una jerarquía entre `Vehículo` y `Auto`.
- `Auto` hereda de `Vehículo` y agrega el atributo `cantidadPuertas`.
- Se aplicó **sobrescritura del método `mostrarInfo()`** para mostrar información más completa.
- Conceptos aplicados: herencia, uso de `super`, encapsulamiento y `@Override`.

---

### 🧩 2. Figuras Geométricas y Métodos Abstractos
- Clase abstracta `Figura` con atributo `nombre` y método abstracto `calcularArea()`.
- Subclases: `Círculo` y `Rectángulo` implementan el cálculo del área.
- Se creó un **array de figuras** y se invocó `calcularArea()` de forma **polimórfica**.
- Conceptos aplicados: clases y métodos abstractos, herencia, polimorfismo.

---

### 🧩 3. Empleados y Polimorfismo
- Clase abstracta `Empleado` con método `calcularSueldo()`.
- Subclases: `EmpleadoPlanta` y `EmpleadoTemporal`, cada una con su propio cálculo.
- Se utilizó una lista de empleados (`ArrayList`) y el método se invocó polimórficamente.
- Se aplicó `instanceof` para identificar el tipo de empleado.
- Conceptos aplicados: polimorfismo, `instanceof`, downcasting, herencia y métodos abstractos.

---

### 🧩 4. Animales y Comportamiento Sobrescrito
- Clase base `Animal` con métodos `hacerSonido()` y `describirAnimal()`.
- Subclases: `Perro`, `Gato` y `Vaca` sobrescriben `hacerSonido()` con comportamientos específicos.
- Se creó una lista de animales y se recorrió usando **polimorfismo**, ejecutando el método correspondiente a cada tipo.
- Conceptos aplicados: sobrescritura de métodos, polimorfismo dinámico y `@Override`.

---

## 🔧 Conclusiones

- La **herencia** permite reutilizar código y crear jerarquías lógicas entre clases.
- El **polimorfismo** brinda flexibilidad, haciendo que un mismo método actúe de diferentes formas según el tipo real del objeto.
- La **sobrescritura** permite redefinir comportamientos heredados sin perder la relación jerárquica.
- El uso de **`super()`** y **`@Override`** mejora la claridad y la seguridad del código.
- Las **clases abstractas** son esenciales para diseñar modelos base que guían la implementación de las subclases.
- Los operadores **`instanceof`**, **upcasting** y **downcasting** facilitan el manejo de tipos y la conversión segura de objetos.
- En conjunto, estos conceptos fortalecen el diseño modular, reutilizable y extensible de las aplicaciones en Java.

---

## 🛠️ Herramientas utilizadas
- **Lenguaje:** Java 17  
- **IDE recomendado:** Visual Studio Code / IntelliJ IDEA / Eclipse  

---

## 📂 Estructura del repositorio
El repositorio contiene los archivos `.java` correspondientes a cada ejercicio práctico, organizados de manera que puedan ejecutarse individualmente en cualquier IDE de Java.

---