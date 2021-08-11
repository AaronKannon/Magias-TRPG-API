package com.kannon.aaron.magiastrpg.repository;

import com.kannon.aaron.magiastrpg.model.AlvoAreaEfeito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlvoAreaEfeitoRepository extends JpaRepository<AlvoAreaEfeito, Long> {
}
