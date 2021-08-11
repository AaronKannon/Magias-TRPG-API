package com.kannon.aaron.magiastrpg.service;

import com.kannon.aaron.magiastrpg.model.Resistencia;
import com.kannon.aaron.magiastrpg.repository.ResistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResistenciaService {

    ResistenciaRepository resistenciaRepository;

    @Autowired
    public ResistenciaService(ResistenciaRepository resistenciaRepository) {
        this.resistenciaRepository = resistenciaRepository;
    }

    public Resistencia saveResistencia(Resistencia resistencia) {
        return resistenciaRepository.save(resistencia);
    }

    public List<Resistencia> findAll() {
        return resistenciaRepository.findAll();
    }

    public Optional<Resistencia> getById(long idResistencia) {
        return resistenciaRepository.findById(idResistencia);
    }

    public Resistencia updateResistencia(Resistencia resistencia) {
        return resistenciaRepository.save(resistencia);
    }

    public void deleteResistencia(long idResistencia) {
        resistenciaRepository.deleteById(idResistencia);
    }

}
