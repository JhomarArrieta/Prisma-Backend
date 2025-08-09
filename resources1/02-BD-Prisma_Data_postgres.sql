INSERT INTO preferencias (hijos, tipo_relacion, diferencia_edad) VALUES
('Sí', 'Seria', 5),
('No', 'Casual', 2),
('Indiferente', 'Amistad', 0),
('Sí', 'Casual', 3),
('No', 'Seria', 7);

INSERT INTO usuario (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, ubicacion, fecha_nacimiento, email, contrasena, administrador) VALUES
('Maria', 'De los Ángeles', 'Agudelo', 'Agudelo', 'Itagüí', '1992-01-01', 'mariagudelogga@gmail.com', '$2a$10$.ZZw4NhJCCp5vCL6tS9x/ebJKFffwdgKEtma9iZ5rW3AySEy7.b/y', false),
('Isabel', NULL, 'Pérez', 'Gómez', 'Envigado', '1990-05-15', 'isabel@example.com', '123456', false),
('María', 'Elena', 'Rodríguez', 'López', 'Medellín', '1995-09-22', 'maria@example.com', '123456', false),
('Paula', NULL, 'Ramírez', 'Torres', 'Bello', '1988-12-01', 'paula@example.com', '123456', true),
('Laura', 'Sofía', 'Martínez', NULL, 'Bello', '1993-07-10', 'laura@example.com', '123456', false),
('Andrea', NULL, 'García', 'Fernández', 'Sabaneta', '1998-03-05', 'andrea@example.com', '123456', false);

INSERT INTO preferencias_usuario (id_usuario, id_preferencias) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1);
