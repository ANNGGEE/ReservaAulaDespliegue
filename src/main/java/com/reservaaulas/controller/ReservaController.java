package com.reservaaulas.controller;

import com.reservaaulas.modelo.Reserva;
import org.springframework.web.bind.annotation.*;
import com.reservaaulas.repository.ReservaRepository;
import com.reservaaulas.dto.ReservaDTO;
import com.reservaaulas.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listar();
    }

    @PostMapping
    public List<Reserva> crear(@RequestBody ReservaDTO dto) {
        return reservaService.crearReserva(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
    }
}
