package com.reservaaulas.controller;

import org.springframework.web.bind.annotation.*;
import com.reservaaulas.modelo.Aula;
import com.reservaaulas.modelo.Reserva;
import com.reservaaulas.repository.AulaRepository;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    private final AulaRepository aulaRepo;

    public AulaController(AulaRepository aulaRepo) {
        this.aulaRepo = aulaRepo;
    }

    @GetMapping
    public List<Aula> listar(
            @RequestParam(required = false) Integer capacidad,
            @RequestParam(required = false) Boolean ordenadores
    ) {
        if (capacidad != null) {
            return aulaRepo.findByCapacidadGreaterThanEqual(capacidad);
        }
        if (Boolean.TRUE.equals(ordenadores)) {
            return aulaRepo.findByEsAulaDeOrdenadoresTrue();
        }
        return aulaRepo.findAll();
    }

    @GetMapping("/{id}")
    public Aula obtener(@PathVariable Long id) {
        return aulaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula no encontrada"));
    }

    @PostMapping
    public Aula crear(@RequestBody Aula aula) {
        return aulaRepo.save(aula);
    }

    @PutMapping("/{id}")
    public Aula modificar(@PathVariable Long id, @RequestBody Aula aula) {
        Aula existente = obtener(id);
        aula.setId(existente.getId());
        return aulaRepo.save(aula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        aulaRepo.deleteById(id);
    }

    @GetMapping("/{id}/reservas")
    public List<Reserva> reservasDeAula(@PathVariable Long id) {
        return obtener(id).getReservas();
    }
}
