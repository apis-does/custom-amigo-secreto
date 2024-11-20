INSERT INTO jugador (nombre, email, telefono)
VALUES ('Doris', 'doris.salazar.jv@gmail.com', 994376854),
       ('Alejandro', 'alejandro.ramirez.od@gmail.com', 978873319),
       ('Valentina', 'vale.salazar.fernandez.12@gmail.com', 961718640),
       ('Claudia', 'claudia.fernandez1801@gmail.com',968454054);

INSERT INTO juego (nombre, reglas, precio_minimo, precio_maximo, fecha_inicio, fecha_sorteo)
VALUES ('Navidad 2024', 'Estas son reglas de prueba', 20000, 50000, '2024-12-01', '2024-12-24'),
       ('Navidad 2025', 'Estas son reglas de prueba', 20000, 50000, '2025-12-01', '2025-12-24'),
       ('Navidad 2026', 'Estas son reglas de prueba', 20000, 50000, '2026-12-01', '2026-12-24');

INSERT INTO deseo (nombre, descripcion, url, precio, jugador_id, juego_id)
VALUES ('Deseo 1', 'Este es el deseo 1', 'https://www.google.com', 10000, 1, 1),
       ('Deseo 2', 'Este es el deseo 2', 'https://www.google.com', 15000, 1, 1),
       ('Deseo 1', 'Este es el deseo 1', 'https://www.google.com', 35000, 2, 1),
       ('Deseo 1', 'Este es el deseo 1', 'https://www.google.com', 5000, 3, 1),
       ('Deseo 2', 'Este es el deseo 2', 'https://www.google.com', 50000, 3, 1),
       ('Iphone pro max', 'Necesito un iphone 16 pro max jiji', 'https://www.google.com', 1200000, 1, 2),
       ('Audifonos', 'Audifonos de casco porfa :(', 'https://www.google.com', 10000, 2, 2),
       ('Libro 1 ', 'Quiero libros porque soy muy lectora', 'https://www.google.com', 35000, 3, 2),
       ('Libro 2 ', 'Quiero libros porque soy muy lectora', 'https://www.google.com', 35000, 3, 2);

INSERT INTO sorteo (juego_id, jugador_id, amigo_secreto_id)
VALUES (1, 1, 2),
       (1, 2, 3),
       (1, 3, 1);