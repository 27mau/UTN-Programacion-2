# 💻 Relaciones entre Clases en Java — Ejercicios UML

Este proyecto contiene **14 casos prácticos de relaciones entre clases en Java**, desarrollados con sus respectivos **diagramas UML (formato UMLetino)** y **implementaciones en código Java**.

Cada ejercicio aborda un tipo distinto de relación: **asociación, agregación, composición, dependencia de uso y dependencia de creación**, junto con sus respectivas direcciones (unidireccional o bidireccional).

---

## 🧩 Ejercicios

### 1️⃣ Persona - Domicilio  
**Relación:** Asociación bidireccional  
**Dirección:** ↔  
**Descripción:** Cada persona tiene un domicilio y cada domicilio pertenece a una persona.

---

### 2️⃣ Celular - Batería - Usuario  
**Relaciones:**  
- Agregación: `Celular → Batería`  
- Asociación bidireccional: `Celular ↔ Usuario`

---

### 3️⃣ Libro - Autor - Editorial  
**Relaciones:**  
- Asociación unidireccional: `Libro → Autor`  
- Agregación: `Libro → Editorial`

---

### 4️⃣ TarjetaDeCrédito - Cliente - Banco  
**Relaciones:**  
- Asociación bidireccional: `TarjetaDeCrédito ↔ Cliente`  
- Agregación: `TarjetaDeCrédito → Banco`

---

### 5️⃣ Computadora - PlacaMadre - Propietario  
**Relaciones:**  
- Composición: `Computadora → PlacaMadre`  
- Asociación bidireccional: `Computadora ↔ Propietario`

---

### 6️⃣ Reserva - Cliente - Mesa  
**Relaciones:**  
- Asociación unidireccional: `Reserva → Cliente`  
- Agregación: `Reserva → Mesa`

---

### 7️⃣ Vehículo - Motor - Conductor  
**Relaciones:**  
- Agregación: `Vehículo → Motor`  
- Asociación bidireccional: `Vehículo ↔ Conductor`

---

### 8️⃣ Documento - FirmaDigital - Usuario  
**Relaciones:**  
- Composición: `Documento → FirmaDigital`  
- Agregación: `FirmaDigital → Usuario`

---

### 9️⃣ CitaMédica - Paciente - Profesional  
**Relaciones:**  
- Asociación unidireccional: `CitaMédica → Paciente`  
- Asociación unidireccional: `CitaMédica → Profesional`

---

### 🔟 CuentaBancaria - ClaveSeguridad - Titular  
**Relaciones:**  
- Composición: `CuentaBancaria → ClaveSeguridad`  
- Asociación bidireccional: `CuentaBancaria ↔ Titular`

---

### 1️⃣1️⃣ Reproductor - Canción - Artista  
**Relaciones:**  
- Asociación unidireccional: `Canción → Artista`  
- Dependencia de uso: `Reproductor.reproducir(Cancion)`

---

### 1️⃣2️⃣ Impuesto - Contribuyente - Calculadora  
**Relaciones:**  
- Asociación unidireccional: `Impuesto → Contribuyente`  
- Dependencia de uso: `Calculadora.calcular(Impuesto)`

---

### 1️⃣3️⃣ GeneradorQR - Usuario - CódigoQR  
**Relaciones:**  
- Asociación unidireccional: `CódigoQR → Usuario`  
- Dependencia de creación: `GeneradorQR.generar(String, Usuario)`

---

### 1️⃣4️⃣ EditorVideo - Proyecto - Render  
**Relaciones:**  
- Asociación unidireccional: `Render → Proyecto`  
- Dependencia de creación: `EditorVideo.exportar(String, Proyecto)`

---

## 📂 Estructura de carpetas sugerida

*(Cada carpeta contiene las clases Java y su diagrama UMLetino en formato `.uxf`.)*

---

## 🛠️ Herramientas utilizadas
- **Lenguaje:** Java 17  
- **Diagramas:** UMLet / UMLetino (formato `.uxf`)  
- **IDE recomendado:** Visual Studio Code / IntelliJ IDEA / Eclipse  

---

## 📂 Estructura del repositorio
El repositorio contiene los archivos `.java` correspondientes a cada ejercicio práctico, organizados de manera que puedan ejecutarse individualmente en cualquier IDE de Java.

---
