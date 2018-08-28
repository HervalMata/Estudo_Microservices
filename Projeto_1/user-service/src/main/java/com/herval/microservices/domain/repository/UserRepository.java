package com.herval.microservices.domain.repository;

import java.util.Collection;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
public interface UserRepository<Booking, String> extends Repository<Booking, String> {

    boolean containsName(String name);

    public Collection<Booking> findByName(String name) throws Exception;
}
