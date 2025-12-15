package com.reservaaulas.repository;

import com.reservaaulas.modelo.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

    List<Aula> findByCapacidadGreaterThanEqual(Integer capacidad);

    List<Aula> findByEsAulaDeOrdenadoresTrue();
}
