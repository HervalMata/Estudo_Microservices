package com.herval.microservices.domain.model.entity;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
public abstract class BaseEntity<T> extends Entity<T> {

    private boolean isModified;

    public BaseEntity(T id, String name){
        super.id = id;
        super.name = name;
        isModified = false;
    }

    public boolean isModified() {
        return isModified;
    }
}
