-- Aula de prueba
INSERT INTO aula (id, nombre, capacidad, es_aula_de_ordenadores, numero_ordenadores)
VALUES (1, 'Aula 101', 30, false, 0)
ON CONFLICT (id) DO NOTHING;

-- Horario de prueba (tabla timerows)
INSERT INTO timerows (id, dia, fila, inicio, fin, type)
VALUES (1, 0, 1, '08:30', '09:25', 'lectivo')
ON CONFLICT (id) DO NOTHING;

-- Reserva de prueba
INSERT INTO reserva (
    fecha,
    motivo,
    numero_asistentes,
    aula_id,
    horario_id,
    fecha_creacion
) VALUES (
             '2025-12-18',
             'Reserva desde data.sql',
             20,
             1,
             1,
             CURRENT_DATE
         );
