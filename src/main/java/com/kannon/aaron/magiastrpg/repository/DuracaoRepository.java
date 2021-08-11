package com.kannon.aaron.magiastrpg.repository;

import com.kannon.aaron.magiastrpg.model.Duracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DuracaoRepository extends JpaRepository<Duracao, Long> {
}
