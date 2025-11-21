# 📘 Trabajo Final Integrador — Programación II  
### Sistema de Gestión de Productos y Códigos de Barras  
**Java + JDBC + MySQL + Arquitectura en Capas (DAO / Service / Presentación)**

---

## 🎯 Descripción del Proyecto

Este proyecto implementa un sistema de gestión de **Productos** y **Códigos de Barras**, desarrollado en:

- **Java 17+**
- **JDBC**
- **MySQL 8+**
- Arquitectura en capas (Entities, DAO, Service, Presentación)
- Relación **1 → 1** entre Producto y Código de Barras
- CRUD completo de ambas entidades
- Baja lógica
- Validaciones en la capa Service
- Transacciones con **commit** y **rollback**
- Script SQL ejecutable desde cero

El sistema funciona mediante un menú de consola interactivo.

---

## 1️⃣ Requisitos Previos

### 🔹 Java
- Java **17 o superior**
- JDBC Driver (mysql-connector-j)  
- IDE recomendado: IntelliJ / Eclipse / NetBeans

---

### 2️⃣ Configurar la base de datos

Ejecutar el script único `01_esquema.sql` ubicado en la carpeta `/sql`:

```sql
-- Ejecutar este archivo para recrear toda la base
source path/to/01_esquema.sql;
```

### 3️⃣ Configurar MySQL en el proyecto

En MySQLConfig.java, asegurarse de configurar:
```bash
private static final String URL = "jdbc:mysql://localhost:3306/tienda";
private static final String USER = "root";
private static final String PASS = "tu_contraseña";
```

---

## 📂 Estructura del Proyecto

El proyecto está organizado en capas claras para separar responsabilidades y facilitar el mantenimiento:

### 🏗️ **Descripción de las capas**

- **app/**
  - Maneja la interacción con el usuario mediante menús y entrada por consola.
  - No contiene lógica de negocio.
  - Invoca exclusivamente métodos del Service.

- **service/**
  - Implementa reglas de negocio y validaciones.
  - Asegura integridad de datos antes de llamar al DAO.
  - No utiliza conexión a la base ni maneja transacciones.

- **dao/**
  - Gestiona la persistencia con JDBC.
  - Contiene las operaciones CRUD reales contra MySQL.
  - La transacción (commit/rollback) se implementa **solo aquí**, según las consignas del TFI.

- **entities/**
  - Modelos del proyecto: Producto y Código de Barras.
  - Representan filas de la base de datos.
  - Incluyen getters, setters y toString() para visualización.

- **sql/**
  - Script único (setup.sql) que crea la base de datos, tablas y datos iniciales.

---

## ⚙️ Funcionalidades Principales

El sistema implementa todas las operaciones CRUD para **Producto** y **Código de Barras**, respetando la arquitectura en capas y las reglas del Trabajo Final Integrador.

### 🔹 1. CRUD completo (Productos y Códigos)
- Crear, listar, consultar por ID, actualizar y eliminar.
- La eliminación implementa **baja lógica** (`eliminado = true`), manteniendo el historial.
- Listado configurable: **todos**, **primeros 10** o **últimos 10** registros.

### 🔹 2. Validaciones en la capa Service
- Campos obligatorios (ej.: nombre, tipo de código, valor).
- Precio ≥ 0.
- Longitud máxima del valor del código (≤ 20 caracteres).
- Tipo restringido a `EAN8`, `EAN13` o `UPC`.
- Validación de ID > 0 en búsquedas y actualizaciones.

### 🔹 3. Persistencia y acceso a datos (DAO)
- Consultas SQL seguras usando `PreparedStatement`.
- Mapeo de resultados a las entidades del proyecto.
- Consultas JOIN para recuperar productos con su código asociado.
- Uso correcto de `getGeneratedKeys()` para obtener IDs autogenerados.

### 🔹 4. Relación 1 a 1 entre Producto y Código
- La columna `producto.codigo_barras_id` es **UNIQUE**, cumpliendo la relación 1→1.
- Un código solo puede pertenecer a un producto.
- Los listados muestran si un producto tiene o no código asociado.

### 🔹 5. Transacciones (commit y rollback)
- Implementadas **únicamente en la capa DAO**, según las consignas del TFI.
- `conn.setAutoCommit(false)` para operaciones compuestas.
- Se utiliza la misma conexión para:
  - insertar el código  
  - insertar el producto  
- `commit()` si ambos inserts son exitosos.
- `rollback()` si ocurre cualquier error:
  - error simulado (nombre = "ERROR"),  
  - código duplicado (constraint UNIQUE),  
  - violación de FK o 1→1,  
  - excepciones SQL.

Esto garantiza que **Producto y Código se crean o se rechazan juntos**, asegurando la integridad de datos.

### 🔹 6. Script único `setup.sql`
Incluye:
- Creación de la base `tienda`
- Tablas con constraints y FK
- Datos iniciales para pruebas
- Verificación final de estructura




