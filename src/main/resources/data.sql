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
-- DATOS INICIALES: TRAMOS HORARIOS
-- --------------------------------------------------------
INSERT INTO tramo_horario (dia_semana, sesion_dia, hora_inicio, hora_fin, tipo_tramo) VALUES
                                                                                          ('Lunes', 0, '08:30:00', '09:25:00', 'lectivo'),
                                                                                          ('Lunes', 1, '09:25:00', '10:20:00', 'lectivo'),
                                                                                          ('Lunes', 2, '10:20:00', '10:35:00', 'recreo'),
                                                                                          ('Lunes', 3, '10:35:00', '11:30:00', 'lectivo'),
                                                                                          ('Lunes', 4, '11:30:00', '12:25:00', 'lectivo'),
                                                                                          ('Lunes', 5, '12:25:00', '12:40:00', 'recreo'),
                                                                                          ('Lunes', 6, '12:40:00', '13:35:00', 'lectivo'),
                                                                                          ('Lunes', 7, '13:35:00', '14:30:00', 'lectivo'),
                                                                                          ('Lunes', 8, '14:30:00', '15:25:00', 'lectivo'),
                                                                                          ('Lunes', 9, '15:25:00', '16:00:00', 'mediodia'),
                                                                                          ('Lunes', 10, '16:00:00', '16:55:00', 'lectivo'),
                                                                                          ('Lunes', 11, '16:55:00', '17:50:00', 'lectivo'),
                                                                                          ('Lunes', 12, '17:50:00', '18:45:00', 'lectivo'),
                                                                                          ('Lunes', 13, '18:45:00', '19:00:00', 'recreo'),
                                                                                          ('Lunes', 14, '19:00:00', '19:55:00', 'lectivo'),
                                                                                          ('Lunes', 15, '19:55:00', '20:50:00', 'lectivo'),
                                                                                          ('Lunes', 16, '20:50:00', '21:45:00', 'lectivo'),

                                                                                          ('Martes', 0, '08:30:00', '09:25:00', 'lectivo'),
                                                                                          ('Martes', 1, '09:25:00', '10:20:00', 'lectivo'),
                                                                                          ('Martes', 2, '10:20:00', '10:35:00', 'recreo'),
                                                                                          ('Martes', 3, '10:35:00', '11:30:00', 'lectivo'),
                                                                                          ('Martes', 4, '11:30:00', '12:25:00', 'lectivo'),
                                                                                          ('Martes', 5, '12:25:00', '12:40:00', 'recreo'),
                                                                                          ('Martes', 6, '12:40:00', '13:35:00', 'lectivo'),
                                                                                          ('Martes', 7, '13:35:00', '14:30:00', 'lectivo'),
                                                                                          ('Martes', 8, '14:30:00', '15:25:00', 'lectivo'),
                                                                                          ('Martes', 9, '15:25:00', '16:00:00', 'mediodia'),
                                                                                          ('Martes', 10, '16:00:00', '16:55:00', 'lectivo'),
                                                                                          ('Martes', 11, '16:55:00', '17:50:00', 'lectivo'),
                                                                                          ('Martes', 12, '17:50:00', '18:45:00', 'lectivo'),
                                                                                          ('Martes', 13, '18:45:00', '19:00:00', 'recreo'),
                                                                                          ('Martes', 14, '19:00:00', '19:55:00', 'lectivo'),
                                                                                          ('Martes', 15, '19:55:00', '20:50:00', 'lectivo'),
                                                                                          ('Martes', 16, '20:50:00', '21:45:00', 'lectivo');
