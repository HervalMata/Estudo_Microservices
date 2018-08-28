package com.herval.microservices.domain.service;

import com.herval.microservices.domain.model.entity.Entity;
import com.herval.microservices.domain.model.entity.User;
import com.herval.microservices.domain.repository.Repository;
import com.herval.microservices.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/*
 * Criado Por Herval Mata em 27/08/2018
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User, String> implements UserService {

    private UserRepository<User, String> userRepository;

    @Autowired
    public UserServiceImpl(UserRepository<User, String> userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) throws Exception {
        if (userRepository.containsName(user.getName())) {
            throw new Exception(String.format("There is already a product with the name - %s", user.getName()));
        }

        if (user.getName() == null || "".equals(user.getName())) {
            throw new Exception("Booking name cannot be null or empty string.");
        }
        super.add(user);
    }

    @Override
    public void update(User user) throws Exception {
        userRepository.update(user);
    }

    @Override
    public void delete(String id) throws Exception {
        userRepository.remove(id);
    }

    @Override
    public Entity findById(String id) throws Exception {
        return userRepository.get(id);
    }

    @Override
    public Collection<User> findByNsme(String name) throws Exception {
        return userRepository.findByName(name);
    }

    @Override
    public Collection<User> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
