package com.kannon.aaron.magiastrpg.service;

import com.kannon.aaron.magiastrpg.model.Alcance;
import com.kannon.aaron.magiastrpg.repository.AlcanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlcanceService {

    AlcanceRepository alcanceRepository;

    @Autowired
    public AlcanceService(AlcanceRepository alcanceRepository) {
        this.alcanceRepository = alcanceRepository;
    }

    public Alcance saveAlcance(Alcance alcance) {
        return alcanceRepository.save(alcance);
    }

    public List<Alcance> findAll() {
        return alcanceRepository.findAll();
    }

    public Optional<Alcance> getById(long idAlcance) {
        return alcanceRepository.findById(idAlcance);
    }

    public Alcance updateAlcance(Alcance alcance) {
        return alcanceRepository.save(alcance);
    }

    public void deleteAlcance(long idAlcance) {
        alcanceRepository.deleteById(idAlcance);
    }

}
