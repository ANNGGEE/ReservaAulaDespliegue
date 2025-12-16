package com.reservaaulas.repository;

import com.reservaaulas.modelo.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByDia(Integer dia);
    List<Horario> findByDiaAndTipo(Integer dia, String tipo);
}
