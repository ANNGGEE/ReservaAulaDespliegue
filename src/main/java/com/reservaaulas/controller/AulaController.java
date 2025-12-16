package com.reservaaulas.controller;

import com.reservaaulas.dto.AulaDTO;
import com.reservaaulas.service.AulaService;
import org.springframework.web.bind.annotation.*;
import com.reservaaulas.modelo.Aula;
import com.reservaaulas.modelo.Reserva;
import com.reservaaulas.repository.AulaRepository;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping
    public List<Aula> listar(
            @RequestParam(required = false) Integer capacidad,
            @RequestParam(required = false) Boolean ordenadores) {
        return aulaService.listar(capacidad, ordenadores);
    }

    @GetMapping("/{id}")
    public Aula obtener(@PathVariable Long id) {
        return aulaService.obtener(id);
    }

    @PostMapping
    public Aula crear(@RequestBody AulaDTO dto) {
        return aulaService.crear(dto);
    }

    @PutMapping("/{id}")
    public Aula modificar(@PathVariable Long id, @RequestBody AulaDTO dto) {
        return aulaService.modificar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        aulaService.eliminar(id);
    }
}
