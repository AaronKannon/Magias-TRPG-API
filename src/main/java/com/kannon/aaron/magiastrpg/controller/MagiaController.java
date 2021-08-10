package com.kannon.aaron.magiastrpg.controller;

import com.kannon.aaron.magiastrpg.Service.MagiaService;
import com.kannon.aaron.magiastrpg.model.Magia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/magia")
public class MagiaController {

    @Autowired
    MagiaService magiaService;

    @PostMapping
    public Magia createMagia(@RequestBody Magia magia) {
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
    public Magia updateJornada(@RequestBody Magia magia) {
        return magiaService.updateMagia(magia);
    }

    @DeleteMapping("/{idMagia}")
    public ResponseEntity<Magia> deleteById(@PathVariable("idMagia") long idMagia) throws NoSuchElementException {
        try {
            magiaService.deleteMagia(idMagia);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println(HttpStatus.CONFLICT);
        }
        return (ResponseEntity<Magia>) ResponseEntity.ok();
    }

    public boolean checkExistance(Magia magia) {
        boolean check = false;
        Iterator<Magia> iterator  = getMagiaList().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getResistencia().equals(magia.getResistencia().getTipoResistencia())) {
                System.out.println("Already exists");
            }
            else {
                check = true;
            }
        }
        return check;
    }

}
