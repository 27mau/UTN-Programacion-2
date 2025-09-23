# 📘 Ejercicios de Programación Orientada a Objetos en Java  

Este repositorio contiene **5 ejercicios prácticos** desarrollados en Java aplicando los **principios de la Programación Orientada a Objetos (POO)**: clases, objetos, atributos, métodos, encapsulamiento, modificadores de acceso y reutilización de código.  

Cada ejercicio está implementado con **clases separadas** y en algunos casos se incluye un **menú interactivo con Scanner** para que el usuario pueda ingresar datos manualmente.  

---

## 📂 Contenido de la carpeta

- Archivos `.java` con cada ejercicio numerado.  
- Uso de `Scanner` para la entrada de datos desde teclado.  
- Programas ejecutables desde NetBeans o desde la terminal.

---

## 📝 Ejercicios  

### 1. Registro de Estudiantes 👩‍🎓  
- **Clase:** `Estudiante`  
- **Atributos:** `nombre`, `apellido`, `curso`, `calificación`  
- **Métodos:**  
  - `mostrarInfo()`  
  - `subirCalificacion(puntos)`  
  - `bajarCalificacion(puntos)`  
- **Tarea:** Crear un estudiante, mostrar información, aumentar y disminuir calificaciones.  

---

### 2. Registro de Mascotas 🐶🐱  
- **Clase:** `Mascota`  
- **Atributos:** `nombre`, `especie`, `edad`  
- **Métodos:**  
  - `mostrarInfo()`  
  - `cumplirAnios()`  
- **Tarea:** Crear una mascota, mostrar su información, simular que cumple años y verificar los cambios.  

---

### 3. Encapsulamiento con la Clase Libro 📚  
- **Clase:** `Libro`  
- **Atributos privados:** `titulo`, `autor`, `añoPublicacion`  
- **Métodos:**  
  - `getTitulo()`, `getAutor()`, `getAnioPublicacion()`  
  - `setAnioPublicacion()` con **validación de año**  
- **Tarea:** Crear un libro, intentar modificar el año con un valor inválido y luego con uno válido. Mostrar el estado final.  

---

### 4. Gestión de Gallinas en Granja Digital 🐔  
- **Clase:** `Gallina`  
- **Atributos:** `idGallina`, `edad`, `huevosPuestos`  
- **Métodos:**  
  - `ponerHuevo()` (con cantidad)  
  - `envejecer()` (con cantidad de años)  
  - `mostrarEstado()`  
- **Tarea:** Crear dos gallinas, simular que ponen huevos y envejecen, y mostrar el estado final.  
- **Extra:** Uso de `Scanner` para ingresar manualmente acciones.  

---

### 5. Simulación de Nave Espacial 🚀  
- **Clase:** `NaveEspacial`  
- **Atributos:** `nombre`, `combustible` (máx. 100)  
- **Métodos:**  
  - `despegar()` (consume 20 unidades)  
  - `avanzar(distancia)` (consume `distancia * 2`)  
  - `recargarCombustible(cantidad)` (valida no superar capacidad máxima)  
  - `mostrarEstado()`  
- **Tarea:** Crear una nave, intentar avanzar sin suficiente combustible, recargar y avanzar correctamente.  
- **Extra:** Menú interactivo con `Scanner` para manejar la nave.  

---

## ⚙️ Temas aplicados  
✔️ Clases y objetos  
✔️ Atributos y métodos  
✔️ Estado e identidad de los objetos  
✔️ Encapsulamiento con `private`, `public` y `protected`  
✔️ Getters y Setters con validación  
✔️ Reutilización de código en diferentes contextos  
✔️ Interacción con el usuario usando `Scanner`  

---

## ▶️ Ejecución  
Cada ejercicio cuenta con su propia clase `Main` para ser ejecutado de manera independiente.  

Ejemplo de ejecución en consola:  

```bash
javac Estudiante.java MainEstudiante.java
java MainEstudiante
```

Lo mismo aplica para `Mascota`, `Libro`, `Gallina` y `NaveEspacial`.  

---

## 📂 Estructura del repositorio
El repositorio contiene los archivos `.java` correspondientes a cada ejercicio práctico, organizados de manera que puedan ejecutarse individualmente en cualquier IDE de Java.
