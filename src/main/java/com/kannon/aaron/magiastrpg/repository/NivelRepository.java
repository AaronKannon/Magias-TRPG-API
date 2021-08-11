package com.kannon.aaron.magiastrpg.repository;

import com.kannon.aaron.magiastrpg.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {
}
