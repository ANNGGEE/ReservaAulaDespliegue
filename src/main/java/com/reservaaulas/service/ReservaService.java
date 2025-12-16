package com.reservaaulas.service;

import com.reservaaulas.modelo.Aula;
import com.reservaaulas.modelo.Horario;
import com.reservaaulas.modelo.Reserva;
import com.reservaaulas.repository.HorarioRepository;
import org.springframework.stereotype.Service;
import com.reservaaulas.repository.AulaRepository;
import com.reservaaulas.repository.ReservaRepository;
import com.reservaaulas.dto.ReservaDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepo;
    private final AulaRepository aulaRepo;
    private final HorarioRepository horarioRepo;

    public ReservaService(ReservaRepository reservaRepo,
                          AulaRepository aulaRepo,
                          HorarioRepository horarioRepo) {
        this.reservaRepo = reservaRepo;
        this.aulaRepo = aulaRepo;
        this.horarioRepo = horarioRepo;
    }

    public List<Reserva> listar() {
        return reservaRepo.findAll();
    }

    public List<Reserva> crearReserva(ReservaDTO dto) {

        if (dto.fecha.isBefore(LocalDate.now())) {
            throw new RuntimeException("No se permiten reservas en el pasado");
        }

        Aula aula = aulaRepo.findById(dto.aulaId)
                .orElseThrow(() -> new RuntimeException("Aula no encontrada"));

        if (dto.numeroAsistentes > aula.getCapacidad()) {
            throw new RuntimeException("Supera la capacidad del aula");
        }

        List<Horario> horarios = horarioRepo.findAllById(dto.horarioIds);

        if (horarios.size() != dto.horarioIds.size()) {
            throw new RuntimeException("Algún horario no existe");
        }

        int diaFecha = dto.fecha.getDayOfWeek().getValue() - 1;

        for (Horario h : horarios) {
            if (!"lectivo".equals(h.getTipo())) {
                throw new RuntimeException("No se puede reservar recreos o mediodía");
            }
            if (!h.getDia().equals(diaFecha)) {
                throw new RuntimeException("Horario no corresponde al día de la fecha");
            }
        }

        List<Reserva> solapadas = reservaRepo.buscarSolapamientos(
                aula.getId(), dto.fecha, horarios
        );

        if (!solapadas.isEmpty()) {
            throw new RuntimeException("El aula ya está reservada en ese horario");
        }

        List<Reserva> creadas = new ArrayList<>();

        for (Horario h : horarios) {
            Reserva r = new Reserva();
            r.setFecha(dto.fecha);
            r.setMotivo(dto.motivo);
            r.setNumeroAsistentes(dto.numeroAsistentes);
            r.setAula(aula);
            r.setHorario(h);
            creadas.add(reservaRepo.save(r));
        }

        return creadas;
    }

    public void eliminar(Long id) {
        reservaRepo.deleteById(id);
    }
}
