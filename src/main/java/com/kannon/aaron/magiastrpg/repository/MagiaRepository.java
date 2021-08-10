package com.kannon.aaron.magiastrpg.repository;

import com.kannon.aaron.magiastrpg.model.Magia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MagiaRepository extends JpaRepository<Magia, Long> {
    /*@Modifying
    @Transactional
    @Query("UPDATE Magia m SET m.descricao = :descricao WHERE m.id = :idMagia")
    public Magia updateMagiaDescricao(@Param("idMagia") long idMagia, @Param("descricao") String descricao);*/
}
