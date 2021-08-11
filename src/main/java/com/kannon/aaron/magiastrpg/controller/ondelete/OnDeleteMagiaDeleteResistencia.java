package com.kannon.aaron.magiastrpg.controller.ondelete;

import com.kannon.aaron.magiastrpg.Service.ResistenciaService;
import com.kannon.aaron.magiastrpg.model.Magia;

import java.util.Iterator;

public class OnDeleteMagiaDeleteResistencia {

    public void checkResistencia (long id, Iterator<Magia> iterator, ResistenciaService callDelete) {
        boolean existir = false;
        System.out.println(id);
        while (iterator.hasNext() && existir==false) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getResistencia().getId().equals(id)) {
                System.out.println("Already exists - checkResistencia");
                existir = true;
            }
        }
        if (existir==false) {
            callDelete.deleteResistencia(id);
        }
    }
}
