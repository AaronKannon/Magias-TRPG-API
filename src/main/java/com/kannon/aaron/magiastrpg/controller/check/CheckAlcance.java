package com.kannon.aaron.magiastrpg.controller.check;

import com.kannon.aaron.magiastrpg.Service.AlcanceService;
import com.kannon.aaron.magiastrpg.model.Magia;

import java.util.Iterator;

public class CheckAlcance implements CheckCreateAndDelete{

    @Override
    public Magia onCreate(Iterator<Magia> iterator, Magia magia) {
        while (iterator.hasNext()) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getAlcance().getTipoAlcance().equals(magia.getAlcance().getTipoAlcance())) {
                System.out.println("Already exists - onCreate(Alcance)");
                magia.setResistencia(check.getResistencia());
            }
        }
        return magia;
    }

    @Override
    public void onDelete(long id, Iterator<Magia> iterator, Object callDelete) {
        AlcanceService op = (AlcanceService) callDelete;
        boolean existir = false;
        //System.out.println(id);
        while (iterator.hasNext() && existir==false) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getAlcance().getId().equals(id)) {
                System.out.println("Already exists - onDelete(Alcance)");
                existir = true;
            }
        }
        if (existir==false) {
            op.deleteAlcance(id);
        }
    }
}
