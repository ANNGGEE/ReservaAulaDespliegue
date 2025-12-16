package com.reservaaulas.service;

import com.reservaaulas.dto.AulaDTO;
import com.reservaaulas.modelo.Aula;
import com.reservaaulas.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    private final AulaRepository aulaRepo;

    public AulaService(AulaRepository aulaRepo) {
        this.aulaRepo = aulaRepo;
    }

    public List<Aula> listar(Integer capacidad, Boolean ordenadores) {
        if (capacidad != null) {
            return aulaRepo.findByCapacidadGreaterThanEqual(capacidad);
        }
        if (Boolean.TRUE.equals(ordenadores)) {
            return aulaRepo.findByEsAulaDeOrdenadoresTrue();
        }
        return aulaRepo.findAll();
    }

    public Aula obtener(Long id) {
        return aulaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula no encontrada"));
    }

    public Aula crear(AulaDTO dto) {
        Aula aula = new Aula();
        aula.setNombre(dto.nombre);
        aula.setCapacidad(dto.capacidad);
        aula.setEsAulaDeOrdenadores(dto.esAulaDeOrdenadores);
        aula.setNumeroOrdenadores(dto.numeroOrdenadores);
        return aulaRepo.save(aula);
    }

    public Aula modificar(Long id, AulaDTO dto) {
        Aula aula = obtener(id);
        aula.setNombre(dto.nombre);
        aula.setCapacidad(dto.capacidad);
        aula.setEsAulaDeOrdenadores(dto.esAulaDeOrdenadores);
        aula.setNumeroOrdenadores(dto.numeroOrdenadores);
        return aulaRepo.save(aula);
    }

    public void eliminar(Long id) {
        aulaRepo.deleteById(id);
    }
}
