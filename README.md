# desi2024-dlov

Trabajo Practico DESI 2024

Integrantes:
Dominguez Juan Pablo (juanpdominguez97@gmail.com)
León Agustin (agusleon2009@gmail.com)
Oroquieta Marcelo (oroquieta.m@gmail.com)

Link repo Github: https://github.com/marceoroq/desi2024-dlov

Historias de usuario 1, 3 y 4.

Schema de la base de datos:

Una vez corriendo la aplicacion en Spring y que se hayan
creado las tablas de la aplicacion en la base de datos,
se puede ejecutar el siguiente SQL para llenarla:

-- Insertar las 5 provincias más pobladas de Argentina
INSERT INTO provincia (nombre)
VALUES
('Buenos Aires'),
('Córdoba'),
('Santa Fe'),
('Mendoza'),
('Tucumán');

-- Insertar 2 ciudades por provincia
INSERT INTO ciudad (nombre, codigo_postal, clima, provincia_id)
VALUES
('La Plata', '1900', 'Templado', 1),
('Mar del Plata', '7600', 'Cálido', 1),
('Córdoba', '5000', 'Cálido', 2),
('Villa Carlos Paz', '5152', 'Templado', 2),
('Rosario', '2000', 'Cálido', 3),
('Santa Fe', '3000', 'Templado', 3),
('Mendoza', '5500', 'Cálido', 4),
('San Rafael', '5600', 'Seco', 4),
('San Miguel de Tucumán', '4000', 'Cálido', 5),
('Tafí del Valle', '4135', 'Templado', 5);

-- Insertar 5 personas en la tabla persona
INSERT INTO persona (nombre, apellido, dni)
VALUES
('Juan', 'Pérez', '12345678'),
('María', 'González', '23456789'),
('Carlos', 'Rodríguez', '34567890'),
('Ana', 'López', '45678901'),
('Luis', 'Martínez', '56789012');

-- Insertar 5 camiones
INSERT INTO camion (patente, ciudad_id, marca, modelo)
VALUES
('AB123CD', 1, 'Mercedes-Benz', 2018),
('XY456ZT', 2, 'Volvo', 2020),
('GH789JK', 3, 'Scania', 2019),
('LM321OP', 4, 'MAN', 2017),
('QR654MN', 5, 'Iveco', 2021);

-- Insertar 5 paquetes
INSERT INTO paquete (fragil, peso, destinatario_id, remitente_id, origen_id, destino_id)
VALUES
(TRUE, 2.5, 1, 2, 1, 3), -- Paquete frágil, 2.5 kg, destinatario_id = 1, remitente_id = 2, origen_id = 1, destino_id = 3
(FALSE, 10.0, 2, 3, 2, 4), -- Paquete no frágil, 10.0 kg, destinatario_id = 2, remitente_id = 3, origen_id = 2, destino_id = 4
(TRUE, 1.2, 3, 4, 3, 5), -- Paquete frágil, 1.2 kg, destinatario_id = 3, remitente_id = 4, origen_id = 3, destino_id = 5
(FALSE, 15.3, 4, 5, 4, 1), -- Paquete no frágil, 15.3 kg, destinatario_id = 4, remitente_id = 5, origen_id = 4, destino_id = 1
(TRUE, 7.8, 5, 1, 5, 2); -- Paquete frágil, 7.8 kg, destinatario_id = 5, remitente_id = 1, origen_id = 5, destino_id = 2
