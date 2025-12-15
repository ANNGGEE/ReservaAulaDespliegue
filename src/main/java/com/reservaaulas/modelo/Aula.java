package com.reservaaulas.modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Aula {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Integer capacidad;
    private Boolean esAulaDeOrdenadores;
    private Integer numeroOrdenadores;

    // Relación con reservas
    @OneToMany(mappedBy = "aula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
    public Boolean getEsAulaDeOrdenadores() { return esAulaDeOrdenadores; }
    public void setEsAulaDeOrdenadores(Boolean esAulaDeOrdenadores) { this.esAulaDeOrdenadores = esAulaDeOrdenadores; }
    public Integer getNumeroOrdenadores() { return numeroOrdenadores; }
    public void setNumeroOrdenadores(Integer numeroOrdenadores) { this.numeroOrdenadores = numeroOrdenadores; }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
