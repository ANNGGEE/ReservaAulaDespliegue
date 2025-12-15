package com.reservaaulas.modelo;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Reserva {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate fecha;
    private String motivo;
    private Integer numeroAsistentes;

    @ManyToOne
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;

    private LocalDate fechaCreacion = LocalDate.now();

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public Integer getNumeroAsistentes() { return numeroAsistentes; }
    public void setNumeroAsistentes(Integer numeroAsistentes) { this.numeroAsistentes = numeroAsistentes; }
    public Aula getAula() { return aula; }
    public void setAula(Aula aula) { this.aula = aula; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }
}
