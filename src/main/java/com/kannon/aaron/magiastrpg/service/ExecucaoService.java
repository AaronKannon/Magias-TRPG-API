package com.kannon.aaron.magiastrpg.service;

import com.kannon.aaron.magiastrpg.model.Execucao;
import com.kannon.aaron.magiastrpg.repository.ExecucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExecucaoService {

    ExecucaoRepository execucaoRepository;

    @Autowired
    public ExecucaoService(ExecucaoRepository execucaoRepository) {
        this.execucaoRepository = execucaoRepository;
    }

    public Execucao saveExecucao(Execucao execucao) {
        return execucaoRepository.save(execucao);
    }

    public List<Execucao> findAll() {
        return execucaoRepository.findAll();
    }

    public Optional<Execucao> getById(long idExecucao) {
        return execucaoRepository.findById(idExecucao);
    }

    public Execucao updateExecucao(Execucao alcance) {
        return execucaoRepository.save(alcance);
    }

    public void deleteExecucao(long idExecucao) {
        execucaoRepository.deleteById(idExecucao);
    }

}
