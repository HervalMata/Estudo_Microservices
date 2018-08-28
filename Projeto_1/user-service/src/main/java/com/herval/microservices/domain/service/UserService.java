package com.herval.microservices.domain.service;

import com.herval.microservices.domain.model.entity.Entity;
import com.herval.microservices.domain.model.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
public interface UserService {

    public void add(User booking) throws Exception;

    public void update(User booking) throws Exception;

    public void delete(String id) throws Exception;

    public Entity findById(String id) throws Exception;

    public Collection<User> findByNsme(String name) throws Exception;

    public Collection<User> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
