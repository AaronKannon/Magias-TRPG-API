package com.kannon.aaron.magiastrpg.controller.check;

import com.kannon.aaron.magiastrpg.Service.ResistenciaService;
import com.kannon.aaron.magiastrpg.model.Magia;

import java.util.Iterator;

public class CheckResistencia implements CheckCreateAndDelete{
    @Override
    public Magia onCreate(Iterator<Magia> iterator, Magia magia) {
        while (iterator.hasNext()) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getResistencia().getTipoResistencia().equals(magia.getResistencia().getTipoResistencia())) {
                System.out.println("Already exists - onCreate(Resistencia)");
                magia.setResistencia(check.getResistencia());
            }
        }
        return magia;
    }

    @Override
    public void onDelete(long id, Iterator<Magia> iterator, Object callDelete) {
        ResistenciaService op = (ResistenciaService) callDelete;
        boolean existir = false;
        //System.out.println(id);
        while (iterator.hasNext() && existir==false) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getResistencia().getId().equals(id)) {
                System.out.println("Already exists - onDelete(Resistencia)");
                existir = true;
            }
        }
        if (existir==false) {
            op.deleteResistencia(id);
        }
    }

    /*public void onDelete(long id, Iterator<Magia> iterator, ResistenciaService callDelete) {
        boolean existir = false;
        //System.out.println(id);
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
    }*/
}
