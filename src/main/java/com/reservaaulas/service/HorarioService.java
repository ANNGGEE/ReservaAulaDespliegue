package com.reservaaulas.service;

import com.reservaaulas.modelo.Horario;
import com.reservaaulas.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    private final HorarioRepository horarioRepo;

    public HorarioService(HorarioRepository horarioRepo) {
        this.horarioRepo = horarioRepo;
    }

    public List<Horario> listar() {
        return horarioRepo.findAll();
    }

    public Horario obtener(Long id) {
        return horarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no válido"));
    }
}
