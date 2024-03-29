package com.kannon.aaron.magiastrpg.repository;

import com.kannon.aaron.magiastrpg.model.Magia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MagiaRepository extends JpaRepository<Magia, Long> {
}
