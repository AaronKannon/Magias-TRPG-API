package com.kannon.aaron.magiastrpg.controller.check;

import com.kannon.aaron.magiastrpg.model.Magia;

import java.util.Iterator;

public interface CheckCreateAndDelete {
    public Magia onCreate(Iterator<Magia> iterator, Magia magia);
    public void onDelete(long id, Iterator<Magia> iterator, Object callDelete);
}
