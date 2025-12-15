package com.reservaaulas.service;

import com.reservaaulas.modelo.Aula;
import com.reservaaulas.modelo.Reserva;
import org.springframework.stereotype.Service;
import com.reservaaulas.repository.AulaRepository;
import com.reservaaulas.repository.ReservaRepository;
import com.reservaaulas.dto.ReservaDTO;

import java.time.LocalDate;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepo;
    private final AulaRepository aulaRepo;

    public ReservaService(ReservaRepository reservaRepo, AulaRepository aulaRepo) {
        this.reservaRepo = reservaRepo;
        this.aulaRepo = aulaRepo;
    }

    public Reserva crearReserva(ReservaDTO dto) {
        if (dto.fecha.isBefore(LocalDate.now())) {
            throw new RuntimeException("No se permiten reservas en el pasado");
        }

        Aula aula = aulaRepo.findById(dto.aulaId)
                .orElseThrow(() -> new RuntimeException("Aula no encontrada"));

        if (dto.numeroAsistentes > aula.getCapacidad()) {
            throw new RuntimeException("Número de asistentes supera la capacidad");
        }

        Reserva reserva = new Reserva();
        reserva.setFecha(dto.fecha);
        reserva.setMotivo(dto.motivo);
        reserva.setNumeroAsistentes(dto.numeroAsistentes);
        reserva.setAula(aula);

        return reservaRepo.save(reserva);
    }
}
