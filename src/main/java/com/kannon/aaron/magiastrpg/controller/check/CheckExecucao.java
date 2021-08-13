package com.kannon.aaron.magiastrpg.controller.check;

import com.kannon.aaron.magiastrpg.service.ExecucaoService;
import com.kannon.aaron.magiastrpg.model.Magia;

import java.util.Iterator;

public class CheckExecucao implements CheckCreateAndDelete{

    @Override
    public Magia onCreate(Iterator<Magia> iterator, Magia magia) {
        while (iterator.hasNext()) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            try{
                if (check.getExecucao().getTipoExecucao().equals(magia.getExecucao().getTipoExecucao())) {
                    //System.out.println("Already exists - onCreate(Execucao)");
                    magia.setExecucao(check.getExecucao());
                }
            } catch (NullPointerException e) {
                //System.out.println("É nulo");
            }
        }
        return magia;
    }

    @Override
    public void onDelete(long id, Iterator<Magia> iterator, Object callDelete) {
        ExecucaoService op = (ExecucaoService) callDelete;
        boolean existir = false;
        //System.out.println(id);
        while (iterator.hasNext() && existir==false) {
            Magia check = iterator.next();
            //System.out.println(check.toString());
            if (check.getExecucao().getId().equals(id)) {
                System.out.println("Already exists - onDelete(Execucao)");
                existir = true;
            }
        }
        if (existir==false) {
            op.deleteExecucao(id);
        }
    }
}
