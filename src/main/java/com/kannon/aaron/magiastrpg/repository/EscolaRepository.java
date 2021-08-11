package com.kannon.aaron.magiastrpg.repository;

import com.kannon.aaron.magiastrpg.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
