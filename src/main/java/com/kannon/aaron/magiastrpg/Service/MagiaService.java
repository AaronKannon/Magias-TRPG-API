package com.kannon.aaron.magiastrpg.Service;

import com.kannon.aaron.magiastrpg.model.Magia;
import com.kannon.aaron.magiastrpg.repository.MagiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagiaService {

    MagiaRepository magiaRepository;

    @Autowired
    public MagiaService(MagiaRepository magiaRepository) {
        this.magiaRepository = magiaRepository;
    }

    public Magia saveMagia(Magia magia) {
        return magiaRepository.save(magia);
    }

    public List<Magia> findAll() {
        return magiaRepository.findAll();
    }

    public Optional<Magia> getById(long idMagia) {
        return magiaRepository.findById(idMagia);
    }

    public Magia updateMagia(Magia magia) {
        return magiaRepository.save(magia);
    }

    public void deleteMagia(long idMagia) {
        magiaRepository.deleteById(idMagia);
    }

}
