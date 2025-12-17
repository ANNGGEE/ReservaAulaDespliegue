-- --------------------------------------------------------
-- BASE DE DATOS RESERVAAULAS
-- --------------------------------------------------------

DROP DATABASE IF EXISTS reservaaulas;
CREATE DATABASE reservaaulas;
USE reservaaulas;

-- --------------------------------------------------------
-- TABLA USUARIO
-- --------------------------------------------------------
CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         role VARCHAR(50) NOT NULL
);

-- --------------------------------------------------------
-- TABLA AULA
-- --------------------------------------------------------
CREATE TABLE aula (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      nombre VARCHAR(100) NOT NULL,
                      capacidad INT NOT NULL,
                      es_aula_de_ordenadores BOOLEAN NOT NULL DEFAULT FALSE,
                      numero_ordenadores INT DEFAULT 0
);

-- --------------------------------------------------------
-- TABLA TRAMO_HORARIO
-- --------------------------------------------------------
CREATE TABLE tramo_horario (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               dia_semana VARCHAR(20) NOT NULL,
                               sesion_dia INT NOT NULL,
                               hora_inicio TIME NOT NULL,
                               hora_fin TIME NOT NULL,
                               tipo_tramo VARCHAR(20) NOT NULL
);

-- --------------------------------------------------------
-- TABLA RESERVA
-- --------------------------------------------------------
CREATE TABLE reserva (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         aula_id BIGINT NOT NULL,
                         usuario_id BIGINT NOT NULL,
                         fecha DATE NOT NULL,
                         motivo VARCHAR(255) NOT NULL,
                         numero_asistentes INT NOT NULL,
                         tramo_horario_id BIGINT NOT NULL,
                         FOREIGN KEY (aula_id) REFERENCES aula(id) ON DELETE CASCADE,
                         FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
                         FOREIGN KEY (tramo_horario_id) REFERENCES tramo_horario(id) ON DELETE CASCADE
);

-- --------------------------------------------------------
-- DATOS INICIALES: USUARIOS
-- --------------------------------------------------------
INSERT INTO usuario (nombre, email, password, role) VALUES
                                                        ('Juan Pérez', 'juan@mail.com', '1234', 'USER'),
                                                        ('Ana López', 'ana@mail.com', '1234', 'USER');

-- --------------------------------------------------------
-- DATOS INICIALES: AULAS
-- --------------------------------------------------------
INSERT INTO aula (nombre, capacidad, es_aula_de_ordenadores, numero_ordenadores) VALUES
                                                                                     ('Aula 101', 30, false, 0),
                                                                                     ('Aula 102', 25, true, 10);

-- --------------------------------------------------------
-- DATOS INICIALES: TRAMOS HORARIOS
-- --------------------------------------------------------
INSERT INTO tramo_horario (dia_semana, sesion_dia, hora_inicio, hora_fin, tipo_tramo) VALUES
                                                                                          ('Lunes', 0, '08:30:00', '09:25:00', 'lectivo'),
                                                                                          ('Lunes', 1, '09:25:00', '10:20:00', 'lectivo'),
                                                                                          ('Lunes', 2, '10:20:00', '10:35:00', 'recreo'),
                                                                                          ('Lunes', 3, '10:35:00', '11:30:00', 'lectivo'),
                                                                                          ('Martes', 0, '08:30:00', '09:25:00', 'lectivo'),
                                                                                          ('Martes', 1, '09:25:00', '10:20:00', 'lectivo');

-- --------------------------------------------------------
-- DATOS INICIALES: RESERVAS
-- --------------------------------------------------------
INSERT INTO reserva (aula_id, usuario_id, fecha, motivo, numero_asistentes, tramo_horario_id) VALUES
                                                                                                  (1, 1, '2025-12-18', 'Clase de Matemáticas', 25, 0),
                                                                                                  (2, 2, '2025-12-18', 'Clase de Física', 20, 1);
