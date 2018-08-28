package com.herval.microservices.domain.repository;

import java.util.Collection;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
public interface ReadOnlyRepository<TE, T> {

    boolean contains(T id);

    TE get(T id);

    Collection<TE> getAll();
}
