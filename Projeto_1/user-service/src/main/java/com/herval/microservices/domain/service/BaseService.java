package com.herval.microservices.domain.service;

import com.herval.microservices.domain.repository.Repository;

import java.util.Collection;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
public class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> _repository;

    public BaseService(Repository<TE, T> repository) {
        super(repository);
        _repository = repository;
    }

    public void add(TE entity) throws Exception{
        _repository.add(entity);
    }

    public Collection<TE> getAll(){
        return _repository.getAll();
    }
}
