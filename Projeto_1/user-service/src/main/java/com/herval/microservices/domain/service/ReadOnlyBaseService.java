package com.herval.microservices.domain.service;

import com.herval.microservices.domain.repository.ReadOnlyRepository;
import com.herval.microservices.domain.repository.Repository;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
public class ReadOnlyBaseService<TE, T> {

    private ReadOnlyRepository<TE, T> repository;

    ReadOnlyBaseService(ReadOnlyRepository<TE,T> repository) {
        this.repository = repository;
    }
}
