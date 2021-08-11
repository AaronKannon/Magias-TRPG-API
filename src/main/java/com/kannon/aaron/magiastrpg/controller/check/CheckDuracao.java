package com.kannon.aaron.magiastrpg.controller.check;

import com.kannon.aaron.magiastrpg.Service.DuracaoService;
import com.kannon.aaron.magiastrpg.model.Magia;

import java.util.Iterator;

public class CheckDuracao implements CheckCreateAndDelete{

    @Override
    public Magia onCreate(Iterator<Magia> iterator, Magia magia) {
        while (iterator.hasNext()) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getDuracao().getTipoDuracao().equals(magia.getDuracao().getTipoDuracao())) {
                System.out.println("Already exists - onCreate(Duracao)");
                magia.setResistencia(check.getResistencia());
            }
        }
        return magia;
    }

    @Override
    public void onDelete(long id, Iterator<Magia> iterator, Object callDelete) {
        DuracaoService op = (DuracaoService) callDelete;
        boolean existir = false;
        //System.out.println(id);
        while (iterator.hasNext() && existir==false) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getDuracao().getId().equals(id)) {
                System.out.println("Already exists - onDelete(Duracao)");
                existir = true;
            }
        }
        if (existir==false) {
            op.deleteDuracao(id);
        }
    }
}
