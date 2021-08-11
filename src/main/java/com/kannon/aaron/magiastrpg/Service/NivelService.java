package com.kannon.aaron.magiastrpg.Service;

import com.kannon.aaron.magiastrpg.model.Alcance;
import com.kannon.aaron.magiastrpg.model.Nivel;
import com.kannon.aaron.magiastrpg.repository.AlcanceRepository;
import com.kannon.aaron.magiastrpg.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelService {

    NivelRepository nivelRepository;

    @Autowired
    public NivelService(NivelRepository nivelRepository) {
        this.nivelRepository = nivelRepository;
    }

    public Nivel saveNivel(Nivel nivel) {
        return nivelRepository.save(nivel);
    }

    public List<Nivel> findAll() {
        return nivelRepository.findAll();
    }

    public Optional<Nivel> getById(long idNivel) {
        return nivelRepository.findById(idNivel);
    }

    public Nivel updateNivel(Nivel nivel) {
        return nivelRepository.save(nivel);
    }

    public void deleteNivel(long idNivel) {
        nivelRepository.deleteById(idNivel);
    }

}
