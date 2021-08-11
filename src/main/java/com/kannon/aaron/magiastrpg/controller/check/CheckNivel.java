package com.kannon.aaron.magiastrpg.controller.check;

import com.kannon.aaron.magiastrpg.service.NivelService;
import com.kannon.aaron.magiastrpg.model.Magia;

import java.util.Iterator;

public class CheckNivel implements CheckCreateAndDelete{

    @Override
    public Magia onCreate(Iterator<Magia> iterator, Magia magia) {
        while (iterator.hasNext()) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if ((check.getNivel().isArcano() == magia.getNivel().isArcano()) &&
                    (check.getNivel().isDivino() == magia.getNivel().isDivino()) &&
                    (check.getNivel().getValorNivel() == magia.getNivel().getValorNivel())) {
                System.out.println("Already exists - onCreate(Nivel)");
                magia.setNivel(check.getNivel());
            }
        }
        return magia;
    }

    @Override
    public void onDelete(long id, Iterator<Magia> iterator, Object callDelete) {
        NivelService op = (NivelService) callDelete;
        boolean existir = false;
        //System.out.println(id);
        while (iterator.hasNext() && existir==false) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getNivel().getId().equals(id)) {
                System.out.println("Already exists - onDelete(Nivel)");
                existir = true;
            }
        }
        if (existir==false) {
            op.deleteNivel(id);
        }
    }
}
