# 📦 Script de Creación y Carga Masiva — Base de Datos tienda

Este documento explica cómo ejecutar correctamente el script SQL que crea la base de datos tienda, genera sus tablas e inserta datos masivos mediante bloques secuenciales.
Las instrucciones están diseñadas para una primera instalación en cualquier equipo.

---

## 🚀 Requisitos previos

Antes de ejecutar el script, asegurate de tener instalado:

- MySQL Server 8.x o superior
- Cliente MySQL o herramienta compatible (Workbench, DBeaver, CLI, etc.)
- Permisos para crear bases de datos y ejecutar scripts largos

---

## 📘 1. Archivos incluidos

script_unico_tienda.sql → creación de BD, tablas, limpieza inicial y carga masiva
Este README con instrucciones

---

## 🔧 2. Preparación del entorno

1.  Abre tu cliente **MySQL** de preferencia (Workbench, línea de comandos, DBeaver, etc.).
2.  Conéctate a tu **servidor** MySQL local o remoto.
3.  Verifica que tu usuario de MySQL tenga los siguientes **permisos** necesarios:
    * `CREATE DATABASE`
    * `CREATE TABLE`
    * `DROP TABLE`
    * `INSERT`, `DELETE`, `SELECT`

---

## ▶️ 3. Ejecución del Script

Para comenzar, sigue estos pasos:

1.  Abre el archivo **`script_unico_tienda.sql`** completo en tu cliente MySQL.
2.  Ejecútalo de **arriba hacia abajo sin interrupciones**.

El script se encargará de realizar automáticamente las siguientes acciones:

* **Creación** de la base de datos `tienda`.
* **Selección** del esquema (`USE tienda;`).
* **Forzado** del motor de almacenamiento **InnoDB**.
* **Creación** de las tablas `codigo_barras` y `producto`.
* **Limpieza inicial** (`DELETE`) para permitir ejecuciones repetidas.
* **Generación** de una tabla de apoyo `numbers`.
* **Inserción** de datos en bloques masivos.
* **Borrado seguro** de tablas temporales (`DROP TEMPORARY TABLE IF EXISTS ...`).

> 📌 **Nota Importante:** El proceso es completamente automático. No requiere **ninguna acción manual** ni intervención durante la ejecución.

---

## ⏳ 4. Duración Aproximada

Dependiendo del **hardware** y del cliente MySQL que estés utilizando, la carga de cientos de miles de registros puede tardar:

* **Servidores modernos:** Entre **5 y 40 segundos**.
* **Equipos básicos:** Entre **30 segundos y 2 minutos**.

---

## 🔍 5. Verificación Posterior a la Ejecución

Después de que el script haya finalizado su ejecución, puedes verificar la correcta inserción de datos ejecutando las siguientes consultas:

### Conteo de Registros

Para verificar el total de filas en cada tabla, ejecuta:

```sql
-- Total de códigos de barras
SELECT COUNT(*) FROM codigo_barras;

-- Total de productos
SELECT COUNT(*) FROM producto;
```

Ambas cantidades deberían tener la misma cantidad de filas, ya que existe una relación 1:1.

---

## ♻️ 6. Re-ejecución del Script (Idempotencia)

El script ha sido diseñado para ser **idempotente**, lo que significa que puedes volver a ejecutarlo sin causar errores ni duplicados de datos. Esto se logra gracias a:

* `DELETE FROM producto;`
* `DELETE FROM codigo_barras;`
* `DROP TEMPORARY TABLE IF EXISTS ...`

### ⚠️ A Tener en Cuenta

* El script **no elimina la base de datos**; solo limpia las tablas y las vuelve a poblar.
* Si deseas una **reinstalación completa** (empezar absolutamente desde cero), ejecuta manualmente el siguiente comando antes de correr el script:
    ```sql
    DROP DATABASE tienda;
    ```

---

## 🧹 7. Limpieza de Temporales y Estructuras Auxiliares

El script se encarga de la limpieza de manera **automática**:

* Elimina las tablas temporarias usadas durante la generación masiva de datos.
* Deja la base de datos lista para su uso inmediato.
* Evita errores en ejecuciones posteriores al eliminar dependencias temporales.

---

## 🎉 Listo

Una vez ejecutado el script, tendrás disponible la base de datos `tienda` completamente funcional, con **más de medio millón de productos** y sus códigos de barras asociados, lista para ser utilizada.