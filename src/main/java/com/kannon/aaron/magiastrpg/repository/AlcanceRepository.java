package com.kannon.aaron.magiastrpg.repository;

import com.kannon.aaron.magiastrpg.model.Alcance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlcanceRepository extends JpaRepository<Alcance, Long> {
}
