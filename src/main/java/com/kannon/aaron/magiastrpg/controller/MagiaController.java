package com.kannon.aaron.magiastrpg.controller;

import com.kannon.aaron.magiastrpg.service.*;
import com.kannon.aaron.magiastrpg.controller.check.*;
import com.kannon.aaron.magiastrpg.model.Magia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/magia")
public class MagiaController {

    @Autowired
    MagiaService magiaService;

    @Autowired
    ResistenciaService resistenciaService;

    @Autowired
    DuracaoService duracaoService;

    @Autowired
    AlvoAreaEfeitoService alvoAreaEfeitoService;

    @Autowired
    AlcanceService alcanceService;

    @Autowired
    ExecucaoService execucaoService;

    @Autowired
    NivelService nivelService;

    @Autowired
    EscolaService escolaService;

    //Checkers
    CheckEscola escola = new CheckEscola();
    CheckNivel nivel = new CheckNivel();
    CheckExecucao execucao = new CheckExecucao();
    CheckAlcance alcance = new CheckAlcance();
    CheckAlvoAreaEfeito alvoAreaEfeito = new CheckAlvoAreaEfeito();
    CheckDuracao duracao = new CheckDuracao();
    CheckResistencia resistencia = new CheckResistencia();

    @PostMapping
    public Magia createMagia(@RequestBody Magia magia) {
        magia = checkExistance(magia);
        //System.out.println(magia.toString());
        return magiaService.saveMagia(magia);
    }

    @GetMapping
    public List<Magia> getMagiaList() {
        return magiaService.findAll();
    }

    @GetMapping("/{idMagia}")
    public ResponseEntity<Magia> getMagiaById(@PathVariable("idMagia") long idMagia) throws NoSuchElementException {
        return ResponseEntity.ok(magiaService.getById(idMagia).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Magia updateMagia(@RequestBody Magia magia) {
        return magiaService.updateMagia(magia);
    }

    @DeleteMapping("/{idMagia}")
    public ResponseEntity<Magia> deleteById(@PathVariable("idMagia") long idMagia) {
        Magia teste = null;
        try {
            teste = magiaService.getById(idMagia).get();
            magiaService.deleteMagia(idMagia);
            //System.out.println("IDResistencia: "+teste.getResistencia().getId());
            checkDelete(teste);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(teste);
    }

    public Magia checkExistance(Magia magia) {

        //Check Escola
        magia = escola.onCreate(getMagiaList().iterator(),magia);

        //Check Nivel
        magia = nivel.onCreate(getMagiaList().iterator(),magia);

        //Check Execucao
        magia = execucao.onCreate(getMagiaList().iterator(),magia);

        //Check Alcance
        magia = alcance.onCreate(getMagiaList().iterator(),magia);

        //Check AlvoAreaEfeito
        magia = alvoAreaEfeito.onCreate(getMagiaList().iterator(),magia);

        //Check Duracao
        magia = duracao.onCreate(getMagiaList().iterator(),magia);

        //Check Resistencia
        magia = resistencia.onCreate(getMagiaList().iterator(),magia);

        return magia;
        /*Iterator<Magia> iterator  = getMagiaList().iterator();
        while (iterator.hasNext()) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getResistencia().getTipoResistencia().equals(magia.getResistencia().getTipoResistencia())) {
                System.out.println("Already exists - checkExistance");
                magia.setResistencia(check.getResistencia());
            }
        }
        return magia;*/
    }

    public void checkDelete(Magia check) {
        Iterator<Magia> iterator  = getMagiaList().iterator();

        //Check Nivel
        nivel.onDelete(check.getNivel().getId(),iterator, nivelService);

        //Check Escola
        escola.onDelete(check.getNivel().getEscola().getId(),iterator, escolaService);

        //Check Execucao
        execucao.onDelete(check.getExecucao().getId(),iterator, execucaoService);

        //Check Alcance
        alcance.onDelete(check.getAlcance().getId(),iterator, alcanceService);

        //Check AlvoAreaEfeito
        alvoAreaEfeito.onDelete(check.getAlvoAreaEfeito().getId(),iterator, alvoAreaEfeitoService);

        //Check Duracao
        duracao.onDelete(check.getDuracao().getId(),iterator, duracaoService);

        //Check Resistencia
        resistencia.onDelete(check.getResistencia().getId(),iterator, resistenciaService);
        /*Iterator<Magia> iterator  = getMagiaList().iterator();
        boolean existir = false;
        while (iterator.hasNext() && existir==false) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getResistencia().getId().equals(id)) {
                System.out.println("Already exists - checkDelete");
                existir = true;
            }
        }
        if (existir==false) {
            callDelete.deleteResistencia(id);
        }*/
    }

}
