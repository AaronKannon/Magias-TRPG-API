package com.kannon.aaron.magiastrpg.repository;

import com.kannon.aaron.magiastrpg.model.Resistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResistenciaRepository extends JpaRepository<Resistencia, Long> {
}
