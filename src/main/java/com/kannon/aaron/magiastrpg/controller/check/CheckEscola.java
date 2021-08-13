package com.kannon.aaron.magiastrpg.controller.check;

import com.kannon.aaron.magiastrpg.service.EscolaService;
import com.kannon.aaron.magiastrpg.model.Magia;

import java.util.Iterator;

public class CheckEscola implements CheckCreateAndDelete{


    //EscolaService callEscolaDelete;

    //public CheckEscola(EscolaService callEscolaDelete) {
    //    this.callEscolaDelete = callEscolaDelete;
    //}

    @Override
    public Magia onCreate(Iterator<Magia> iterator, Magia magia) {
        while (iterator.hasNext()) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            try{
                if (check.getNivel().getEscola().getTipoEscola().equals(magia.getNivel().getEscola().getTipoEscola())) {
                    //System.out.println("Already exists - onCreate(Escola)");
                    magia.getNivel().setEscola(check.getNivel().getEscola());
                }
            } catch (NullPointerException e) {
                //System.out.println("É nulo");
            }
        }
        return magia;
    }

    @Override
    public void onDelete(long id, Iterator<Magia> iterator, Object callDelete) {
        EscolaService op = (EscolaService) callDelete;
        boolean existir = false;
        //System.out.println(id);
        while (iterator.hasNext() && existir==false) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getNivel().getEscola().getId().equals(id)) {
                System.out.println("Already exists - onDelete(Escola)");
                existir = true;
            }
        }
        if (existir==false) {
            //System.out.println(op.getById(id).toString());
            op.deleteEscola(id);
        }
    }
}
