package com.kannon.aaron.magiastrpg.service;

import com.kannon.aaron.magiastrpg.model.AlvoAreaEfeito;
import com.kannon.aaron.magiastrpg.repository.AlvoAreaEfeitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlvoAreaEfeitoService {

    AlvoAreaEfeitoRepository alvoAreaEfeitoRepository;

    @Autowired
    public AlvoAreaEfeitoService(AlvoAreaEfeitoRepository alvoAreaEfeitoRepository) {
        this.alvoAreaEfeitoRepository = alvoAreaEfeitoRepository;
    }

    public AlvoAreaEfeito saveAlvoAreaEfeito(AlvoAreaEfeito alvoAreaEfeito) {
        return alvoAreaEfeitoRepository.save(alvoAreaEfeito);
    }

    public List<AlvoAreaEfeito> findAll() {
        return alvoAreaEfeitoRepository.findAll();
    }

    public Optional<AlvoAreaEfeito> getById(long idAlvoAreaEfeito) {
        return alvoAreaEfeitoRepository.findById(idAlvoAreaEfeito);
    }

    public AlvoAreaEfeito updateAlvoAreaEfeito(AlvoAreaEfeito alvoAreaEfeito) {
        return alvoAreaEfeitoRepository.save(alvoAreaEfeito);
    }

    public void deleteAlvoAreaEfeito(long idAlvoAreaEfeito) {
        alvoAreaEfeitoRepository.deleteById(idAlvoAreaEfeito);
    }

}
