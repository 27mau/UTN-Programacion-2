# 🧩 Trabajo Práctico — Colecciones en Java

Este repositorio contiene tres trabajos prácticos desarrollados en **Java**, aplicando los conceptos de **Programación Orientada a Objetos (POO)** y el manejo de **Colecciones (`ArrayList`)**, **Relaciones entre clases**, y **Streams** para filtrado y búsqueda de datos.

---

## 🧱 ESTRUCTURA GENERAL

Este trabajo práctico se divide en **tres ejercicios integradores**, cada uno con sus propias clases y métodos,
enfocados en el aprendizaje y aplicación de los siguientes conceptos:

- Programación Orientada a Objetos (POO)
- Uso de **colecciones dinámicas (`ArrayList`)**
- Encapsulamiento, constructores y métodos
- Relación entre clases (composición y asociación)
- Uso de **Streams** y filtros (`filter`, `collect`)
- Relaciones **bidireccionales 1 a N**
- Uso de **enums**, **sobrecarga de métodos**, y **control de datos**

---

# 🛒 Ejercicio 1 — Sistema de Stock (Productos e Inventario)

### 📌 Objetivo
Diseñar un sistema que gestione un inventario de productos mediante **colecciones**.
Se utilizaron clases y un `enum` para representar categorías y realizar operaciones típicas de un sistema de stock.

### 🧩 Clases principales
- `CategoriaProducto` → Enumeración con descripción de cada categoría.  
- `Producto` → Representa un artículo con `id`, `nombre`, `precio`, `cantidad` y `categoria`.  
- `Inventario` → Contiene un `ArrayList<Producto>` y métodos para agregar, eliminar, buscar y filtrar productos.  
- `SistemaStockMain` → Clase principal que ejecuta las tareas pedidas en la consigna.

### 🧠 Conceptos aplicados
- Uso de **`ArrayList`** para colecciones de objetos.
- Métodos con **responsabilidad única** (`buscar`, `filtrar`, `actualizarStock`).
- Uso de **Streams** para filtrar por categoría o precio.
- Implementación de **`enum`** con descripciones y getters.

---

# 📚 Ejercicio 2 — Biblioteca y Libros (Relación 1 a N con clase Autor)

### 📌 Objetivo
Implementar un sistema para gestionar una **biblioteca** utilizando **colecciones de objetos** y relaciones entre clases.  
Cada libro está asociado a un autor, y el sistema permite realizar operaciones como búsqueda, filtrado, eliminación y conteo.

### 🧩 Clases principales
- `Autor` → Representa un autor con `nombre` y `nacionalidad`.  
- `Libro` → Contiene `isbn`, `titulo`, `autor`, `añoPublicacion`, `genero` y un booleano `disponible`.  
- `Biblioteca` → Administra una lista (`ArrayList<Libro>`) con métodos para agregar, buscar por ISBN, filtrar por autor o año, eliminar libros y listar todos.  
- `SistemaBibliotecaMain` → Clase principal que ejecuta los pasos de la consigna.  

### 🧠 Temas abordados
- Relación **1 a N** entre `Autor` y `Libro`.  
- Uso de **`ArrayList`** para almacenar objetos complejos.  
- Búsqueda y filtrado mediante **Streams**.  
- Métodos personalizados para mostrar información (`mostrarInfo`).  
- Eliminación sincronizada de elementos en colecciones.

---

# 🎓 Ejercicio 3 — Universidad, Profesor y Curso (Relación bidireccional 1 a N)

### 📌 Objetivo
Desarrollar un sistema que gestione una **universidad**, sus **profesores** y **cursos**, aplicando una **relación bidireccional 1 a N**.  
Cada profesor puede dictar varios cursos, y cada curso conoce a su profesor.

### 🧩 Clases principales
- `Profesor` → Tiene `codigo`, `nombre`, `especialidad` y una lista de cursos asignados.  
- `Curso` → Posee `codigo`, `nombre`, `duracionHoras` y una referencia a su profesor.  
- `Universidad` → Administra listas de profesores y cursos, con métodos para agregar, asignar, eliminar y generar reportes.  
- `SistemaUniversidadMain` → Ejecuta las acciones de la consigna.

### 🧠 Temas abordados
- **Relaciones bidireccionales 1 a N** (`Profesor` ↔ `Curso`).  
- Sincronización entre ambos lados de la relación.  
- Métodos de mantenimiento: alta, baja y reasignación de entidades.  
- Generación de **reportes** dinámicos a partir de colecciones.  
- Aplicación de principios de **POO** y consistencia de datos en memoria.

---

## 🛠️ Herramientas utilizadas
- **Lenguaje:** Java 17  
- **IDE recomendado:** Visual Studio Code / IntelliJ IDEA / Eclipse  

---

## 📂 Estructura del repositorio
El repositorio contiene los archivos `.java` correspondientes a cada ejercicio práctico, organizados de manera que puedan ejecutarse individualmente en cualquier IDE de Java.

---