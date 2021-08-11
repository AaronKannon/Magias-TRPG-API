package com.kannon.aaron.magiastrpg.controller;

import com.kannon.aaron.magiastrpg.Service.MagiaService;
import com.kannon.aaron.magiastrpg.Service.ResistenciaService;
import com.kannon.aaron.magiastrpg.controller.ondelete.OnDeleteMagiaDeleteResistencia;
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
    ResistenciaService callDelete;

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
        ResponseEntity<Magia> deletar = null;
        try {
            Magia teste = magiaService.getById(idMagia).get();
            //if (!teste.getResistencia().getId().equals(idMagia)) {
            //    teste.setResistencia(null);
            //    updateMagia(teste);
            //}
            magiaService.deleteMagia(idMagia);
            System.out.println("IDResistencia: "+teste.getResistencia().getId());
            checkDelete(teste.getResistencia().getId());
            deletar = (ResponseEntity<Magia>) ResponseEntity.ok();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println(HttpStatus.CONFLICT);
        }
        return deletar;
    }

    public Magia checkExistance(Magia magia) {
        Iterator<Magia> iterator  = getMagiaList().iterator();
        while (iterator.hasNext()) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getResistencia().getTipoResistencia().equals(magia.getResistencia().getTipoResistencia())) {
                System.out.println("Already exists - checkExistance");
                magia.setResistencia(check.getResistencia());
            }
        }
        return magia;
    }

    public void checkDelete(long id) {
        Iterator<Magia> iterator  = getMagiaList().iterator();
        OnDeleteMagiaDeleteResistencia delete = new OnDeleteMagiaDeleteResistencia();
        delete.checkResistencia(id,iterator, callDelete);
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
