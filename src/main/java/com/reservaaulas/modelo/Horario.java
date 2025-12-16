package com.reservaaulas.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "timerows")
public class Horario {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "dia")
    private Integer dia;   // 0 = lunes

    @Column(name = "fila")
    private Integer fila;

    @Column(name = "inicio")
    private String inicio;

    @Column(name = "fin")
    private String fin;

    @Column(name = "type")
    private String tipo; // lectivo, recreo, mediodia

    @OneToMany(mappedBy = "horario")
    private List<Reserva> reservas = new ArrayList<>();

//    @Enumerated(EnumType.STRING)
//    private DiaSemana diaSemana;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
