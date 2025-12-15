package com.reservaaulas.modelo;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    private Integer sesionDia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    @OneToMany(mappedBy = "horario")
    private List<Reserva> reservas = new ArrayList<>();

    public enum DiaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES
    }
}
