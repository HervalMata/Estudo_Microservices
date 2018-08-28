package com.herval.microservices.domain.repository;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {

    void add(TE entity);

    void remove(T id);

    void update(TE entity);
}
