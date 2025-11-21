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

## 🛠️ Requisitos Previos

### 🔹 Java
- Java **17 o superior**
```bash
java -version

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




