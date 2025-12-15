package com.reservaaulas.repository;

import com.reservaaulas.modelo.Horario;
import com.reservaaulas.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r " +
            "WHERE r.aula.id = :aulaId " +
            "AND r.fecha = :fecha " +
            "AND r.horario IN :horarios")
    List<Reserva> buscarSolapamientos(@Param("aulaId") Long aulaId,
                                      @Param("fecha") LocalDate fecha,
                                      @Param("horarios") List<Horario> horarios);
}
