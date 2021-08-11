package com.kannon.aaron.magiastrpg.Service;

import com.kannon.aaron.magiastrpg.model.Escola;
import com.kannon.aaron.magiastrpg.model.Nivel;
import com.kannon.aaron.magiastrpg.repository.EscolaRepository;
import com.kannon.aaron.magiastrpg.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    EscolaRepository escolaRepository;

    @Autowired
    public EscolaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public Escola saveEscola(Escola escola) {
        return escolaRepository.save(escola);
    }

    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }

    public Optional<Escola> getById(long idEscola) {
        return escolaRepository.findById(idEscola);
    }

    public Escola updateEscola(Escola escola) {
        return escolaRepository.save(escola);
    }

    public void deleteEscola(long idEscola) {
        escolaRepository.deleteById(idEscola);
    }

}
