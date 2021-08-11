package com.kannon.aaron.magiastrpg.controller.check;

import com.kannon.aaron.magiastrpg.Service.AlvoAreaEfeitoService;
import com.kannon.aaron.magiastrpg.Service.ResistenciaService;
import com.kannon.aaron.magiastrpg.model.Magia;

import java.util.Iterator;

public class CheckAlvoAreaEfeito implements CheckCreateAndDelete{

    @Override
    public Magia onCreate(Iterator<Magia> iterator, Magia magia) {
        while (iterator.hasNext()) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getAlvoAreaEfeito().getTipoAlvoAreaEfeito().equals(magia.getAlvoAreaEfeito().getTipoAlvoAreaEfeito()) &&
                    check.getAlvoAreaEfeito().getDescricao().equals(magia.getAlvoAreaEfeito().getDescricao()) ) {
                System.out.println("Already exists - onCreate(AlvoAreaEfeito)");
                magia.setResistencia(check.getResistencia());
            }
        }
        return magia;
    }

    @Override
    public void onDelete(long id, Iterator<Magia> iterator, Object callDelete) {
        AlvoAreaEfeitoService op = (AlvoAreaEfeitoService) callDelete;
        boolean existir = false;
        //System.out.println(id);
        while (iterator.hasNext() && existir==false) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getAlvoAreaEfeito().getId().equals(id)) {
                System.out.println("Already exists - onDelete(AlvoAreaEfeito)");
                existir = true;
            }
        }
        if (existir==false) {
            op.deleteAlvoAreaEfeito(id);
        }
    }
}
