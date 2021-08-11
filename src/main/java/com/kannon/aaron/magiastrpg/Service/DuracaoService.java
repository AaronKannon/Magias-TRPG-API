package com.kannon.aaron.magiastrpg.Service;

import com.kannon.aaron.magiastrpg.model.Duracao;
import com.kannon.aaron.magiastrpg.model.Resistencia;
import com.kannon.aaron.magiastrpg.repository.DuracaoRepository;
import com.kannon.aaron.magiastrpg.repository.ResistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuracaoService {

    DuracaoRepository duracaoRepository;

    @Autowired
    public DuracaoService(DuracaoRepository duracaoRepository) {
        this.duracaoRepository = duracaoRepository;
    }

    public Duracao saveDuracao(Duracao duracao) {
        return duracaoRepository.save(duracao);
    }

    public List<Duracao> findAll() {
        return duracaoRepository.findAll();
    }

    public Optional<Duracao> getById(long idDuracao) {
        return duracaoRepository.findById(idDuracao);
    }

    public Duracao updateDuracao(Duracao duracao) {
        return duracaoRepository.save(duracao);
    }

    public void deleteDuracao(long idDuracao) {
        duracaoRepository.deleteById(idDuracao);
    }

}
