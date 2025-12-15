package com.reservaaulas.dto;

import java.time.LocalDate;
import java.util.List;

public class ReservaDTO {

    public LocalDate fecha;
    public String motivo;
    public Integer numeroAsistentes;
    public Long aulaId;
    public List<Long> horarioIds;
}
