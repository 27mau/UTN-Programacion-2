-- Creación de base de datos y tablas con PK, FK, UNIQUE, CHECK.

DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda;
USE tienda;

-- Forzar motor InnoDB
SET default_storage_engine = InnoDB;

-- 1. CREACIÓN DE TABLAS (PK, FK, UNIQUE, CHECK)
CREATE TABLE codigo_barras (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  eliminado BOOLEAN NOT NULL DEFAULT FALSE,
  tipo ENUM('EAN13', 'EAN8', 'UPC') NOT NULL,
  valor VARCHAR(20) NOT NULL UNIQUE,
  fecha_asignacion DATE,
  observaciones VARCHAR(255),
  CHECK (CHAR_LENGTH(valor) <= 20)
);

CREATE TABLE producto (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  eliminado BOOLEAN NOT NULL DEFAULT FALSE,
  nombre VARCHAR(120) NOT NULL,
  marca VARCHAR(80),
  categoria VARCHAR(80),
  precio DECIMAL(10,2) NOT NULL CHECK (precio >= 0),
  peso DECIMAL(10,3),
  codigo_barras_id BIGINT UNIQUE,
	FOREIGN KEY (codigo_barras_id)
    REFERENCES codigo_barras(id)
    ON DELETE CASCADE
);

-- DELETE FROM producto;
-- DELETE FROM codigo_barras;

-- 2. Inserción de registros en bloque, generación secuencial.

DROP TABLE IF EXISTS numbers;
CREATE TABLE numbers (n INT PRIMARY KEY NOT NULL AUTO_INCREMENT);
INSERT INTO numbers VALUES (NULL);
INSERT INTO numbers VALUES (NULL);

CREATE TEMPORARY TABLE tmp_insert (
    n INT PRIMARY KEY,
    tipo ENUM('EAN13','EAN8','UPC'),
    valor VARCHAR(20),
    fecha_asignacion DATE,
    observaciones VARCHAR(255)
);

-- Bloque 1
SET @start_n = 1;
SET @end_n = 174000;
SET @offset = 0;

-- 1️ Preparar los datos en la tabla temporal
INSERT INTO tmp_insert (n, tipo, valor, fecha_asignacion, observaciones)
SELECT
    n,
    CASE WHEN n % 6 IN (1,4,0) THEN 'EAN13'
         WHEN n % 6 = 3 THEN 'EAN8'
         ELSE 'UPC' END,
    CASE WHEN n % 6 = 1 THEN CONCAT('779', LPAD(n + @offset, 10, '0'))
         WHEN n % 6 = 3 THEN CONCAT('99', LPAD(n, 6, '0'))
         WHEN n % 6 = 4 THEN CONCAT('001', LPAD(n + @offset, 10, '0'))
         WHEN n % 6 = 2 THEN CONCAT('543', LPAD(n, 9, '0'))
         WHEN n % 6 = 5 THEN CONCAT('42', LPAD(n, 8, '0'))
         ELSE CONCAT('871', LPAD(n + @offset, 10, '0')) END,
    DATE_ADD('2024-01-01', INTERVAL (RAND() * 300) DAY),
    'Parte 1 (1 - 174000)'
FROM numbers
WHERE n BETWEEN @start_n AND @end_n;

-- 2️ Insertar en codigo_barras
INSERT INTO codigo_barras (tipo, valor, fecha_asignacion, observaciones)
SELECT tipo, valor, fecha_asignacion, observaciones
FROM tmp_insert;

-- 3️ Crear tabla temporal para mapear valor → id
CREATE TEMPORARY TABLE tmp_map AS
SELECT t.n, c.id AS codigo_barras_id
FROM tmp_insert t
JOIN codigo_barras c ON t.valor = c.valor;

-- 4️ Insertar productos usando el id real
INSERT INTO producto (nombre, categoria, marca, precio, peso, codigo_barras_id)
SELECT
    CONCAT('Ítem ', m.n, ' - ',
           CASE
               WHEN m.n % 6 = 1 THEN 'Bebida '
               WHEN m.n % 6 = 2 THEN 'Prenda '
               WHEN m.n % 6 = 3 THEN 'Tecno '
               WHEN m.n % 6 = 4 THEN 'Decoración '
               WHEN m.n % 6 = 5 THEN 'Muñeco '
               ELSE 'Utensilio '
           END, FLOOR(RAND() * 1000)),
    CASE
        WHEN m.n % 6 = 1 THEN 'Alimentos'
        WHEN m.n % 6 = 2 THEN 'Ropa'
        WHEN m.n % 6 = 3 THEN 'Electrodomésticos'
        WHEN m.n % 6 = 4 THEN 'Hogar'
        WHEN m.n % 6 = 5 THEN 'Juguetería'
        ELSE 'Bazar'
    END,
    CONCAT('Marca_M', FLOOR(RAND() * 10) + 1),
    ROUND(RAND() * 300 + 10, 2),
    ROUND(RAND() * 5 + 0.1, 3),
    m.codigo_barras_id
FROM tmp_map m;

-- 5 Limpiar temporales para el siguiente bloque
TRUNCATE TABLE tmp_insert;
DROP TEMPORARY TABLE tmp_map;

-- BLoque 2
SET @start_n = 174001;
SET @end_n = 348000;
SET @offset = 1000000; -- offset para evitar duplicados

INSERT INTO tmp_insert (n, tipo, valor, fecha_asignacion, observaciones)
SELECT
    n,
    CASE WHEN n % 6 IN (1,4,0) THEN 'EAN13'
         WHEN n % 6 = 3 THEN 'EAN8'
         ELSE 'UPC' END,
    CASE WHEN n % 6 = 1 THEN CONCAT('779', LPAD(n + @offset, 10, '0'))
         WHEN n % 6 = 3 THEN CONCAT('99', LPAD(n, 6, '0'))
         WHEN n % 6 = 4 THEN CONCAT('001', LPAD(n + @offset, 10, '0'))
         WHEN n % 6 = 2 THEN CONCAT('543', LPAD(n, 9, '0'))
         WHEN n % 6 = 5 THEN CONCAT('42', LPAD(n, 8, '0'))
         ELSE CONCAT('871', LPAD(n + @offset, 10, '0')) END,
    DATE_ADD('2024-01-01', INTERVAL (RAND() * 300) DAY),
    'Parte 2 (174001 - 348000)'
FROM numbers
WHERE n BETWEEN @start_n AND @end_n;

INSERT INTO codigo_barras (tipo, valor, fecha_asignacion, observaciones)
SELECT tipo, valor, fecha_asignacion, observaciones
FROM tmp_insert;

CREATE TEMPORARY TABLE tmp_map AS
SELECT t.n, c.id AS codigo_barras_id
FROM tmp_insert t
JOIN codigo_barras c ON t.valor = c.valor;

INSERT INTO producto (nombre, categoria, marca, precio, peso, codigo_barras_id)
SELECT
    CONCAT('Ítem ', m.n, ' - ',
           CASE
               WHEN m.n % 6 = 1 THEN 'Bebida '
               WHEN m.n % 6 = 2 THEN 'Prenda '
               WHEN m.n % 6 = 3 THEN 'Tecno '
               WHEN m.n % 6 = 4 THEN 'Decoración '
               WHEN m.n % 6 = 5 THEN 'Muñeco '
               ELSE 'Utensilio '
           END, FLOOR(RAND() * 1000)),
    CASE
        WHEN m.n % 6 = 1 THEN 'Alimentos'
        WHEN m.n % 6 = 2 THEN 'Ropa'
        WHEN m.n % 6 = 3 THEN 'Electrodomésticos'
        WHEN m.n % 6 = 4 THEN 'Hogar'
        WHEN m.n % 6 = 5 THEN 'Juguetería'
        ELSE 'Bazar'
    END,
    CONCAT('Marca_M', FLOOR(RAND() * 10) + 1),
    ROUND(RAND() * 300 + 10, 2),
    ROUND(RAND() * 5 + 0.1, 3),
    m.codigo_barras_id
FROM tmp_map m;

TRUNCATE TABLE tmp_insert;
DROP TEMPORARY TABLE tmp_map;

-- Bloque 3
SET @start_n = 348001;
SET @end_n = 522000;
SET @offset = 2000000; -- offset único

INSERT INTO tmp_insert (n, tipo, valor, fecha_asignacion, observaciones)
SELECT
    n,
    CASE WHEN n % 6 IN (1,4,0) THEN 'EAN13'
         WHEN n % 6 = 3 THEN 'EAN8'
         ELSE 'UPC' END,
    CASE WHEN n % 6 = 1 THEN CONCAT('779', LPAD(n + @offset, 10, '0'))
         WHEN n % 6 = 3 THEN CONCAT('99', LPAD(n, 6, '0'))
         WHEN n % 6 = 4 THEN CONCAT('001', LPAD(n + @offset, 10, '0'))
         WHEN n % 6 = 2 THEN CONCAT('543', LPAD(n, 9, '0'))
         WHEN n % 6 = 5 THEN CONCAT('42', LPAD(n, 8, '0'))
         ELSE CONCAT('871', LPAD(n + @offset, 10, '0')) END,
    DATE_ADD('2024-01-01', INTERVAL (RAND() * 300) DAY),
    'Parte 3 (348001 - 522000)'
FROM numbers
WHERE n BETWEEN @start_n AND @end_n;

INSERT INTO codigo_barras (tipo, valor, fecha_asignacion, observaciones)
SELECT tipo, valor, fecha_asignacion, observaciones
FROM tmp_insert;

CREATE TEMPORARY TABLE tmp_map AS
SELECT t.n, c.id AS codigo_barras_id
FROM tmp_insert t
JOIN codigo_barras c ON t.valor = c.valor;

INSERT INTO producto (nombre, categoria, marca, precio, peso, codigo_barras_id)
SELECT
    CONCAT('Ítem ', m.n, ' - ',
           CASE
               WHEN m.n % 6 = 1 THEN 'Bebida '
               WHEN m.n % 6 = 2 THEN 'Prenda '
               WHEN m.n % 6 = 3 THEN 'Tecno '
               WHEN m.n % 6 = 4 THEN 'Decoración '
               WHEN m.n % 6 = 5 THEN 'Muñeco '
               ELSE 'Utensilio '
           END, FLOOR(RAND() * 1000)),
    CASE
        WHEN m.n % 6 = 1 THEN 'Alimentos'
        WHEN m.n % 6 = 2 THEN 'Ropa'
        WHEN m.n % 6 = 3 THEN 'Electrodomésticos'
        WHEN m.n % 6 = 4 THEN 'Hogar'
        WHEN m.n % 6 = 5 THEN 'Juguetería'
        ELSE 'Bazar'
    END,
    CONCAT('Marca_M', FLOOR(RAND() * 10) + 1),
    ROUND(RAND() * 300 + 10, 2),
    ROUND(RAND() * 5 + 0.1, 3),
    m.codigo_barras_id
FROM tmp_map m;

-- Limpieza de tablas temporales. Se usa IF EXISTS para evitar fallos
-- si la tabla ya fue eliminada o no se creó en la sesión actual,
-- asegurando que el script es idempotente y no falla en re-ejecuciones.
DROP TEMPORARY TABLE IF EXISTS tmp_insert;
DROP TEMPORARY TABLE IF EXISTS tmp_map;

-- Verificar total de datos cargados
SELECT COUNT(*) FROM codigo_barras;
SELECT COUNT(*) FROM producto;

-- Probar FK y ON DELETE CASCADE
DELETE FROM codigo_barras WHERE id = 10;
SELECT * FROM producto WHERE codigo_barras_id = 10; -- Debe estar vacío

-- Probar consultas rápidas --
SELECT * FROM producto LIMIT 10;
SELECT categoria, COUNT(*) FROM producto GROUP BY categoria;
-- 20 primeros códigos de barras insertados
SELECT * FROM codigo_barras ORDER BY id ASC LIMIT 20;
-- 20 primeros productos insertados
SELECT * FROM producto ORDER BY id ASC LIMIT 20;

-- 20 últimos códigos de barras insertados
SELECT * FROM codigo_barras ORDER BY id DESC LIMIT 20;
-- 20 últimos productos insertados
SELECT * FROM producto ORDER BY id DESC LIMIT 20;

-- Crear índice
CREATE INDEX idx_categoria ON producto(categoria);

-- Mara como eliminado ID específico
UPDATE producto SET eliminado = TRUE WHERE id = 393221;
-- Verificar un ID Específico
SELECT * FROM producto WHERE id = 393221;