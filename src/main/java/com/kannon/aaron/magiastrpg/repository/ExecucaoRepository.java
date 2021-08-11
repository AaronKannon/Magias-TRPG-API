package com.kannon.aaron.magiastrpg.repository;

import com.kannon.aaron.magiastrpg.model.Alcance;
import com.kannon.aaron.magiastrpg.model.Execucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExecucaoRepository extends JpaRepository<Execucao, Long> {
}
