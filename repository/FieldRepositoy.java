package repository;


import java.util.HashMap;

import pojo.Field;

public class FieldRepositoy {

    private HashMap<Integer, Field> datastore = new HashMap<>();

    public Field createField(int id, Field field) {
        return this.datastore.put(id, new Field(field));
    }

    public Field retrievField(int id) {
        return new Field(this.datastore.get(id));
    }

    
}